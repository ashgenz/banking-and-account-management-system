package main;

import java.util.Scanner;
import service.Bank;

public class Main {

    private static Bank bank = new Bank();
    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {

        String ch;

        System.out.println("===== BANK APPLICATION =====");

        while (true) {

            System.out.println("\nEnter command:");
            System.out.println("create");
            System.out.println("deposit");
            System.out.println("withdraw");
            System.out.println("transfer");
            System.out.println("exit");

            ch = sc1.nextLine();

            if (ch.equalsIgnoreCase("exit")) {
                break;
            }

            switch (ch.toLowerCase()) {

                // ================= CREATE ACCOUNT =================
                case "create":

                    System.out.print("Enter account type (savings/current): ");
                    String type = sc1.nextLine();

                    System.out.print("Enter account number: ");
                    String accNum = sc1.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = sc1.nextLine();

                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = sc1.nextDouble();
                    sc1.nextLine(); // consume Enter

                    

                    break;

                // ================= DEPOSIT =================
                case "deposit":

                    System.out.print("Enter account number: ");
                    String depositAccNum = sc1.nextLine();

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc1.nextDouble();
                    sc1.nextLine();

                    

                    break;

                // ================= WITHDRAW =================
                case "withdraw":

                    System.out.print("Enter account number: ");
                    String withdrawAccNum = sc1.nextLine();

                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc1.nextDouble();
                    sc1.nextLine();

                    

                    break;

                // ================= TRANSFER =================
                case "transfer":

                    System.out.print("Enter source account number: ");
                    String fromAcc = sc1.nextLine();

                    System.out.print("Enter target account number: ");
                    String toAcc = sc1.nextLine();

                    System.out.print("Enter transfer amount: ");
                    double transferAmount = sc1.nextDouble();
                    sc1.nextLine();

                    bank.TransferFunds(
                            fromAcc,
                            toAcc,
                            transferAmount
                    );

                    break;

                // ================= INVALID COMMAND =================
                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        sc1.close();

        System.out.println("\nThank you for using the Bank Application.");
    }
}