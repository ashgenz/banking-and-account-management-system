package interfaces;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public interface BankOperations {

    void deposit(double amount) throws InvalidAmountException;

    void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException;
}
