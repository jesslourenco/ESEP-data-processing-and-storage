package com.ufl.gatordb;

import java.util.HashMap;

class GatorDB implements inMemoryDB {
  private HashMap<String, Integer> db; // database
  //
  private HashMap<String, Integer> transaction; // stores changes for an active transaction
  private boolean isActiveTransaction = false;

  public void GatorDB() {
    db = new HashMap<>();
  }

  @Override
  public int get(String key) {
    return 0;
  }

  @Override
  public void put(String key, int val) {
    return;
  }

  @Override
  public void begin_transaction() {
    return;
  }

  @Override
  public void commit() {
    return;
  }

  @Override
  public void rollback() {
    return;
  }
}
