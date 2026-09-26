package models;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public class SavingsAccount extends Account {

    private double minimumBalance = 500.0;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }

        if (getBalance() - amount < minimumBalance) {
            throw new InsufficientBalanceException(
                    "Cannot withdraw: Minimum balance of 500 required."
            );
        }

        setBalance(getBalance() - amount);
    }
}