package com.ufl.gatordb;

interface InMemoryDB {
  public Integer get(String key);

  public void put(String key, int value) throws NoOpenTransaction;

  public void begin_transaction() throws MultipleTransactions;

  public void commit() throws NoOpenTransaction;

  public void rollback() throws NoOpenTransaction;

  public static class NoOpenTransaction extends Exception {
    public NoOpenTransaction(String message) {
      super(message);
    }
  }

  public static class MultipleTransactions extends Exception {
    public MultipleTransactions(String message) {
      super(message);
    }
  }
}
