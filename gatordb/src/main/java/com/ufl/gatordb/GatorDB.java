package com.ufl.gatordb;

import java.util.HashMap;

class GatorDB implements InMemoryDB {
  private HashMap<String, Integer> db; // database
  private HashMap<String, Integer> transaction; // stores changes for an active transaction

  public GatorDB() {
    db = new HashMap<>();
  }

  @Override
  public Integer get(String key) {
    if (!db.containsKey(key)) {
      return null;
    }
    return db.get(key);
  }

  @Override
  public void put(String key, int value) throws NoOpenTransaction {
    if (transaction == null) {
      throw new NoOpenTransaction("Failure: no transaction in progress.");
    }
    transaction.put(key, value);
  }

  @Override
  public void begin_transaction() throws MultipleTransactions {
    if (transaction != null) {
      throw new MultipleTransactions("Failure: a transaction already exists.");
    }
    transaction = new HashMap<>();
  }

  @Override
  public void commit() throws NoOpenTransaction {
    if (transaction == null) {
      throw new NoOpenTransaction("Failure: no transaction in progress.");
    }

    db.putAll(transaction);
    transaction = null;
  }

  @Override
  public void rollback() throws NoOpenTransaction {
    if (transaction == null) {
      throw new NoOpenTransaction("Failure: no transaction in progress.");
    }

    transaction = null;
  }
}
