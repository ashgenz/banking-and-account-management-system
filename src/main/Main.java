package main;

import java.util.Scanner;
import exceptions.*; 
import service.Bank; 
import models.Account;

/**
 * Main entry point for the Banking & Account Management System.
 */
public class Main {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== BANKING & ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Open Account (Savings/Current)");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = -1;
            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } else {
                    System.out.println("Error: Please enter a valid numeric menu choice.");
                    scanner.nextLine(); // Clear invalid input
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error reading input: " + e.getMessage());
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1: // Open Account
                    try {
                        System.out.print("Enter account type (savings/current): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter account number: ");
                        String accNum = scanner.nextLine();
                        System.out.print("Enter account holder name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter initial deposit amount: ");
                        double initialDeposit = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        bank.createAccount(type, accNum, name, initialDeposit);
                    } catch (Exception e) {
                        System.out.println("Error processing account creation: " + e.getMessage());
                    } finally {
                        System.out.println("[Log] Account creation attempt completed.");
                    }
                    break;

                case 2: // Deposit Money
                    try {
                        System.out.print("Enter account number: ");
                        String accNum = scanner.nextLine();
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        bank.depositMoney(accNum, amount);
                    } catch (Exception e) {
                        System.out.println("Error processing deposit: " + e.getMessage());
                    } finally {
                        System.out.println("[Log] Deposit transaction attempt completed.");
                    }
                    break;

                case 3: // Withdraw Money
                    try {
                        System.out.print("Enter account number: ");
                        String accNum = scanner.nextLine();
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        bank.withdrawMoney(accNum, amount);
                    } catch (Exception e) {
                        System.out.println("Error processing withdrawal: " + e.getMessage());
                    } finally {
                        System.out.println("[Log] Withdrawal transaction attempt completed.");
                    }
                    break;

                case 4: // Transfer Funds
                    try {
                        System.out.print("Enter source account number: ");
                        String fromAcc = scanner.nextLine();
                        System.out.print("Enter target account number: ");
                        String toAcc = scanner.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        bank.TransferFunds(fromAcc, toAcc, amount);
                    } catch (Exception e) {
                        System.out.println("Error processing fund transfer: " + e.getMessage());
                    } finally {
                        System.out.println("[Log] Transfer transaction attempt completed.");
                    }
                    break;

                case 5: // View Account Details
                    try {
                        System.out.print("Enter account number to view: ");
                        String accNum = scanner.nextLine();
                        Account acc = bank.findAccount(accNum);
                        System.out.println("--- Account Details ---");
                        System.out.println("Account Number: " + acc.getAccountNumber());
                        System.out.println("Account Holder: " + acc.getAccountHolderName());
                        System.out.println("Current Balance: " + acc.getBalance());
                    } catch (InvalidAccountOperationException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("[Log] View account details attempt completed.");
                    }
                    break;

                case 6: // Exit
                    System.out.println("Thank you for using the Banking & Account Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 and 6.");
            }
        }
    }
}