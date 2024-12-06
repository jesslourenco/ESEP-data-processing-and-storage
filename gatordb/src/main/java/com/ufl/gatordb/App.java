package com.ufl.gatordb;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("""
                    Welcome to GatorDB!
                   .-._   _ _ _ _ _ _ _ _
        .-''-.__.-'00  '-' ' ' ' ' ' ' ' '-.
        '.___ '    .   .--_'-' '-' '-' _'-' '._
         V: V 'vv-'   '_   '.       .'  _..' '.'.
           '=.____.=_.--'   :_.__.__:_   '.   : :
                   (((____.-'        '-.  /   : :
                                     (((-'\\ .' /
                                   _____..'  .'
                                  '-._____.-'
              """);
    // Art by Shanaka Dias

    System.out.println();

    GatorDB db = new GatorDB();
    Scanner sc = new Scanner(System.in);
    int op;

    outerLoop: for (;;) {
      System.out.println("Menu ");
      System.out.println("1. Get - Retrieve a value given a key");
      System.out.println("2. Begin a Transaction");
      System.out.println("3. Put - Create or Update an entry");
      System.out.println("4. Commit Transaction");
      System.out.println("5. Rollback Transaction");
      System.out.println("6. Quit");

      System.out.println();

      try {
        System.out.println("Select your operation: ");
        op = sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please provide an integer value");
        sc.next();
        continue;
      }

      switch (op) {
        case 1 -> {
          // Get
          System.out.print("Key: ");
          String key = sc.next();

          Integer value = db.get(key);
          System.out.println(value);
        }

        case 2 -> {
          try {
            // Start transaction
            db.begin_transaction();
            System.out.println("Success: new transaction started.");
          } catch (InMemoryDB.MultipleTransactions e) {
            System.out.println(e.getMessage());
          }
        }

        case 3 -> {
          // Put
          System.out.print("Key: ");
          String key = sc.next();

          System.out.print("Value: ");
          int value = sc.nextInt();

          try {
            db.put(key, value);
            System.out.println("Success: entry added to the database.");
          } catch (InMemoryDB.NoOpenTransaction e) {
            System.out.println(e.getMessage());
          } catch (InputMismatchException e) {
            System.out.println("Failure: Invalid value for entry (must be an integer).");
            sc.next();
            continue;
          }
        }

        case 4 -> {
          // Commit
          System.out.println("Committing your changes...");

          try {
            db.commit();
            System.out.println("Success");
          } catch (InMemoryDB.NoOpenTransaction e) {
            System.out.println(e.getMessage());
          }
        }

        case 5 -> {
          // Rollback
          System.out.println("Rolling back your changes...");

          try {
            db.rollback();
            System.out.println("Success");
          } catch (InMemoryDB.NoOpenTransaction e) {
            System.out.println(e.getMessage());
          }
        }

        case 6 -> {
          // Exit
          System.out.println("Thanks for using GatorDB! Goodbye.");
          sc.close();
          break outerLoop;
        }

        default -> {
          System.out.println("Invalid option.");
        }
      }

      System.out.println("================================================");

    }
  }
}
