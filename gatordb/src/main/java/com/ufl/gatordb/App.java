package com.ufl.gatordb;

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

    outerLoop: for (;;) {
      System.out.println("Select your operation: ");
      System.out.println("1. Get - Retrieve a value given a key");
      System.out.println("2. Begin a Transaction");
      System.out.println("3. Put - Create or Update an entry");
      System.out.println("4. Commit Transaction");
      System.out.println("5. Rollback Transaction");
      System.out.println("6. Quit");

      System.out.println();

      int op = sc.nextInt();

      switch (op) {
        case 1 -> {
          System.out.print("Key: ");
          String key = sc.next();

          try {
            int value = db.get(key);
            System.out.println(value);
          } catch (Exception e) {
            System.out.println("null");
          }
        }

        case 2 -> {
          try {
            db.begin_transaction();
            System.out.println("Success: new transaction started.");
          } catch (Exception e) {
            System.out.println("Failure: a transaction already exists.");
          }
        }

        case 3 -> {
          System.out.print("Key: ");
          String key = sc.next();

          System.out.print("Value: ");
          int value = sc.nextInt();

          try {
            db.put(key, value);
            System.out.println("Success: entry added to the database.");
          } catch (Exception e) {
            System.out.println("Failure: no transaction in progress.");
          }
        }

        case 4 -> {
          System.out.println("Committing your changes...");

          try {
            db.commit();
            System.out.println("Success");
          } catch (Exception e) {
            System.out.println("Failure: no transaction in progress.");
          }
        }

        case 5 -> {
          System.out.println("Rolling back your changes...");

          try {
            db.rollback();
            System.out.println("Success");
          } catch (Exception e) {
            System.out.println("Failure: no transaction in progress.");
          }
        }

        case 6 -> {
          System.out.println("Thanks for using GatorDB! Goodbye.");
          sc.close();
          break outerLoop;
        }

        default -> {
          System.out.println("Please select a valid option");
        }
      }

      System.out.println("================================================");

    }
  }
}
