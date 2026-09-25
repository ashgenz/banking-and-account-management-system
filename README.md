# 💳 Banking & Account Management System

> A robust, enterprise-grade console-based banking application built from scratch in **Java**, strictly adhering to advanced Object-Oriented Programming (OOP) principles, clean package architectures, and secure custom exception handling workflows.
> 
> 

---

## 🚀 Project Overview

The **Banking & Account Management System** is engineered to simulate real-world core banking operations. It empowers users to open diverse account types (Savings and Current), execute deposits, process strict withdrawals, conduct secure multi-account fund transfers, and review account records on demand—all seamlessly managed within an in-memory data collection layout.

---

## 🛠️ Core Technical Stack & OOP Pillars

* **Object-Oriented Design**: Full implementation of Encapsulation, Abstraction, Inheritance, and Polymorphism.
* **Exception Safety**: Custom runtime exception hierarchy backed by explicit `try-catch-finally`, `throw`, and `throws` control routing.


* **In-Memory Management**: Powered by Java Collections (`HashMap<String, Account>`) for rapid account indexing and retrieval.


* **Interactive Interface**: Clean, text-based Command Line Interface (CLI) loop driven by Java `Scanner` utilities.



---

## 📂 Project Structure & Architecture

The source code is modularized into dedicated packages to achieve strict separation of concerns:

```text
BankingSystem/
│
└───src/
    ├───exceptions/
    │   ├───InsufficientBalanceException.java
    │   ├───InvalidAmountException.java
    │   └───InvalidAccountOperationException.java
    │
    ├───interfaces/
    │   └───BankOperations.java
    │
    ├───models/
    │   ├───Account.java (Abstract)
    │   ├───SavingsAccount.java
    │   └───CurrentAccount.java
    │
    ├───service/
    │   └───Bank.java
    │
    └───main/
        └───Main.java

```

---

## 🔍 Detailed Component & Class Breakdown

### 1. Package: `exceptions`

Implements domain-specific error handling to capture operational breaches without failing catastrophically.

* **`InsufficientBalanceException.java`**: Thrown when a withdrawal or fund transfer exceeds available liquidity limits. Extends `RuntimeException`.


* **`InvalidAmountException.java`**: Thrown when a transaction amount evaluates to zero or a negative digit. Extends `RuntimeException`.


* **`InvalidAccountOperationException.java`**: Thrown during faulty lookups of non-existent account IDs or illicit transactional triggers. Extends `RuntimeException`.



### 2. Package: `interfaces`

* **`BankOperations.java`**: The foundational blueprint contract outlining core transactional signatures:
* `void deposit(double amount) throws InvalidAmountException;`

* `void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;`




### 3. Package: `models`

Contains the core hierarchy implementing business logic rules and data protection.

* **`Account.java` (Abstract)**: Implements `BankOperations`. Secures data fields via **Encapsulation** (`private String accountNumber`, `private String accountHolderName`, `private double balance`). Exposes safe accessor/mutator methods, common deposit validation rules, and defines the abstract `withdraw()` method layout.


* **`SavingsAccount.java`**: Inherits from `Account`. Overrides `withdraw()` to enforce a rigid minimum balance boundary (e.g., maintaining at least $500.0).


* **`CurrentAccount.java`**: Inherits from `Account`. Overrides `withdraw()` to support modern banking features like structured overdraft tolerances.



### 4. Package: `service`

* **`Bank.java`**: Acts as the central transaction manager housing a `HashMap<String, Account>` index. It exposes high-level APIs to open accounts, look up targets securely, and coordinate safe multi-account fund transfers (`transferFunds`).



### 5. Package: `main`

* **`Main.java`**: Drives the user experience loop (`while(true)`). It presents a structured menu structure, routes inputs into the service tier, and wraps operations safely inside `try-catch-finally` blocks to maintain continuous uptime.



---

## 🕹️ Interactive Menu Preview

When launching the application via `Main.java`, users are greeted with the following control console:

```text
========================================
   WELCOME TO THE CORE BANKING SYSTEM   
========================================
1. Open New Account (Savings / Current)
2. Deposit Funds
3. Withdraw Funds
4. Transfer Funds Between Accounts
5. View Account Details
6. Exit System
========================================
Select an option (1-6): 

```

---

## 🚀 Getting Started & Compilation

To compile and launch the application directly from your terminal:

1. Navigate to the root directory `BankingSystem/src/`.
2. Compile all packages together:
```bash
javac main/Main.java models/*.java exceptions/*.java interfaces/*.java service/*.java

```


3. Run the application:
```bash
java main.Main

```