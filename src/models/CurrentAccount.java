package models;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public class CurrentAccount extends Account {

    private double overdraftLimit = 1000.0;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }

        if (getBalance() - amount < -overdraftLimit) {
            throw new InsufficientBalanceException(
                    "Overdraft limit exceeded."
            );
        }

        setBalance(getBalance() - amount);
    }
}