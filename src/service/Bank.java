package service;

import java.util.HashMap;


import exception.*;
import models.Account;
import models.SavingAccount;
import models.CurrentAccount;


/**
 * Bank
 */
//all methods are public becuase pallavi will use these in Main.java using import (like - import <package-name.className)


//a object of this class=one bank (only one object made,but methods called mutilple times)
public class Bank {
    //declared hasmap
    private HashMap<String,Account> accounts;
    public Bank(){
        //initialized hashmap
        this.accounts =new HashMap();

    }
    public void createAccount(String type, String accNum, String name, double initialDeposit) throws InvalidAmountException {
        //make the account type and push in hasmap
        //make account object

        try{
            //if Account with accNum already present 
        if (initialDeposit<=0) {
                throw new InvalidAmountException("Error: Deposit amount must be greater than zero.");
        }
        if (accounts.containsKey(accNum)) {
            System.out.println("Error: Account number already exists!");
        }

        //make account block
        Account newAcc;
        if(type.equalsIgnoreCase("savings")){
            newAcc= new SavingAccount(accNum,name,initialDeposit);
        }
        else if(type.equalsIgnoreCase("current")) {
            newAcc= new CurrentAccount(accNum,name,initialDeposit);
        }
        else{
            System.out.println("Error: wrong Account type");
        }
        accounts.put(accNum, newAcc);
        System.out.println("Your "+ type+" Account created sucessfully!");
        }
        catch(InvalidAmountException e){
            System.out.println(e);
        }
    }
    public Account  findAccount(String accountNumber) throws InvalidAccountOperationException  {
        //return Account object or  throws InvalidAccountOperationException if missing/not found in map.
            
            Account Acc = accounts.get(accountNumber);
            //if return null throw InvalidAccountOperationException("Account not found.").
            if(Acc==null){
                throw new InvalidAccountOperationException("Error: Account not Found!");
            }
            System.out.println(accountNumber+" Account found!");
        
        return Acc;
    }
    public void depositMoney(String accNum, double amount) throws InvalidAmountException,InvalidAccountOperationException {
        //find account and call deposit method
        //InvalidAccountOperationException, InvalidAmountException
        try{
        if(amount<=0){
            throw new InvalidAmountException("Error: Deposit amount must be greater than zero.");

            }
        Account Acc=findAccount(accNum);
        // if(Acc==null){
        //         throw new InvalidAccountOperationException("Account not Found!");
        // }
        //if return nothing throw 
        Acc.deposit(amount);
        System.out.println("rupees"+amount+"credited to"+accNum+".");
        //if invlaid amount throw
        }
        catch(InvalidAccountOperationException e){
            System.out.println(e);
        }
        catch(InvalidAmountException e){
            System.out.println(e);
        }
        
    }
    public void withdrawMoney(String accNum, double amount)throws InvalidAmountException,InvalidAccountOperationException,InsufficientBalanceException{
        //Finds account and invokes its withdraw() method
        //InvalidAccountOperationException, InsufficientBalanceException, InvalidAmountException
     try{
        if(amount<=0){
            throw new InvalidAmountException("Error: Deposit amount must be greater than zero.");

            }
        Account Acc=findAccount(accNum);
        // if(Acc==null){
        //         throw new InvalidAccountOperationException("Account not Found!");
        // }
        //if return nothing throw 
        if(amount>Acc.getBalance()){
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        Acc.withdraw(amount);
        System.out.println("rupees"+amount+"debited from"+accNum+".");
        //if invlaid amount throw
        }
        catch(InvalidAccountOperationException e){
            System.out.println(e);
        }
        catch(InvalidAmountException e){
            System.out.println(e);
        }
        catch(InsufficientBalanceException e){
            System.out.println(e);
        }

    }
    public void TransferFunds(String fromAcc, String toAcc, double amount) {
        //withdraw from source account,deposit to target account
        //validation logic -

        
        try{
        if(amount<=0){
            throw new InvalidAmountException("Error: Deposit amount must be greater than zero.");

            }
         Account sourceAcc = findAccount(fromAcc);
        Account targetAcc =  findAccount(toAcc);
        // if(sourceAcc==null){
        //         throw new InvalidAccountOperationException("source Account not Found!");
        // }
        // if(targetAcc==null){
        //         throw new InvalidAccountOperationException("target Account not Found!");
        // }
        //if return nothing throw 
        if(amount>sourceAcc.getBalance()){
            throw new InsufficientBalanceException("Insufficient Balance in source Account!");
        }
        sourceAcc.withdraw(amount);
        targetAcc.deposit(amount);
        System.out.println("rupees"+amount+"debited from"+sourceAcc+"and credited to " + targetAcc+".");
        //if invlaid amount throw
        }
        catch(InvalidAccountOperationException e){
            System.out.println(e);
        }
        catch(InvalidAmountException e){
            System.out.println(e);
        }
        catch(InsufficientBalanceException e){
            System.out.println(e);
        }

    }
    
}