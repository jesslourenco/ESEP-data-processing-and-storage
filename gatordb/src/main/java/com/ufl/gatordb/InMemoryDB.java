package com.ufl.gatordb;

interface inMemoryDB {
  int get(String key);

  void put(String key, int val);

  void begin_transaction();

  void commit();

  void rollback();
}
