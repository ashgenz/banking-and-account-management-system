
package main;

import java.util.Scanner;
import service.Bank;

public class Main {

    private static Bank bank = new Bank();
    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {

        String ch;

        System.out.println("Enter command: create, deposit, withdraw or exit");

        while (!(ch = sc1.nextLine()).equalsIgnoreCase("exit")) {

            switch (ch.toLowerCase()) {

                case "create":
                    bank.createAccount();
                    break;

                case "deposit":
                    bank.depositMoney();
                    break;

                case "withdraw":
                    bank.withdrawMoney();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Enter next command:");
        }

        sc1.close();

        System.out.println("Thank you for using the Bank Application.");
    }
}