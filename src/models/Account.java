package models;

import exceptions.InvalidAmountException;
import exceptions.InsufficientBalanceException;
import interfaces.BankOperations;

public abstract class Account implements BankOperations {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if(amount <=0 ) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        
        this.balance += amount;
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;

    public void displayAccountDetails() {
        System.out.println("--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
    }

}