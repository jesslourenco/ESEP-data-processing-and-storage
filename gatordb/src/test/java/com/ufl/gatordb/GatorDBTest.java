
package com.ufl.gatordb;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GatorDBTest {
  @Test
  void testGetNonExistentKey() {
    GatorDB db = new GatorDB();
    assertNull(db.get("A"), "Expected null for a non-existent key");
  }

  @Test
  void testPutWithoutTransaction() {
    GatorDB db = new GatorDB();
    assertThrows(InMemoryDB.NoOpenTransaction.class, () -> db.put("A", 5),
        "Expected an exception when no transaction is in progress");
  }

  @Test
  void testTransactionFlow() throws Exception {
    GatorDB db = new GatorDB();

    db.begin_transaction();

    db.put("A", 5);
    assertNull(db.get("A"), "Expected null because transaction changes are not committed");

    db.put("A", 6);

    db.commit();
    assertEquals(6, db.get("A"), "Expected value 6 after committing the transaction");

    assertThrows(InMemoryDB.NoOpenTransaction.class, db::commit,
        "Expected an exception for commit with no transaction");

    assertThrows(InMemoryDB.NoOpenTransaction.class, db::rollback,
        "Expected an exception for commit with no transaction");

    assertNull(db.get("B"), "Expected null for a non-existent key");

    db.begin_transaction();

    db.put("B", 10);

    db.rollback();
    assertNull(db.get("B"),
        "Expected null because changes were rolled back");
  }
}
