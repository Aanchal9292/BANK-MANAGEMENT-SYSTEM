package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;
import com.jdbcconnectivity.bankmanagement.model.Account;
import com.jdbcconnectivity.bankmanagement.service.AccountService;
import com.jdbcconnectivity.bankmanagement.service.impl.AccountServiceImpl;
import com.jdbcconnectivity.bankmanagement.model.Transaction;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class AccountController {
    private AccountService accountService = new AccountServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addAccount(Account account) { accountService.addAccount(account); }
    public Account getAccountByNo(String accountNo) { return accountService.getAccountByNo(accountNo); }
    public List<Account> getAllAccounts() { return accountService.getAllAccounts(); }
    public void updateAccount(Account account) { accountService.updateAccount(account); }
    public void deleteAccount(String accountNo) { accountService.deleteAccount(accountNo); }

    // New interactive methods with table display
    public void addAccount() {
        System.out.print("Enter account number: ");
        String accountNo = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter account type: ");
        String type = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        Account account = new Account(accountNo, customerId, type, balance, "active", new Timestamp(System.currentTimeMillis()));
        try {
            addAccount(account);
            System.out.println("Account added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAccount() {
        System.out.print("Enter account number: ");
        String accountNo = scanner.nextLine();
        Account account = getAccountByNo(accountNo);
        if (account != null) {
            App.printTableHeader("Account No", "Type", "Balance", "Status", "Created At");
            App.printTableRow(account.getAccountNo(), account.getAccountType(), account.getBalance(), account.getStatus(), account.getCreatedAt());
            App.printTableFooter();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void viewAccountsByCustomer() {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        List<Account> accounts = getAllAccounts();
        boolean found = false;
        App.printTableHeader("Account No", "Type", "Balance", "Status", "Created At");
        for (Account a : accounts) {
            if (a.getCustomerId() == customerId) {
                App.printTableRow(a.getAccountNo(), a.getAccountType(), a.getBalance(), a.getStatus(), a.getCreatedAt());
                found = true;
            }
        }
        App.printTableFooter();
        if (!found) {
            System.out.println("No accounts found for this customer!");
        }
    }

    public void deposit() {
        System.out.print("Enter account number: ");
        String accountNo = scanner.nextLine();
        Account account = getAccountByNo(accountNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        account.setBalance(account.getBalance() + amount);
        updateAccount(account);
        // Add transaction
        TransactionController transactionController = new TransactionController();
        transactionController.addTransaction(new Transaction(0, accountNo, "Deposit", amount, new Timestamp(System.currentTimeMillis()), "Deposit"));
        System.out.println("Deposit successful! New balance: " + account.getBalance());
    }

    public void withdraw() {
        System.out.print("Enter account number: ");
        String accountNo = scanner.nextLine();
        Account account = getAccountByNo(accountNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (amount <= 0 || amount > account.getBalance()) {
            System.out.println("Invalid amount or insufficient balance!");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        updateAccount(account);
        // Add transaction
        TransactionController transactionController = new TransactionController();
        transactionController.addTransaction(new Transaction(0, accountNo, "Withdraw", amount, new Timestamp(System.currentTimeMillis()), "Withdrawal"));
        System.out.println("Withdrawal successful! New balance: " + account.getBalance());
    }

    public void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        String accountNo = scanner.nextLine();
        deleteAccount(accountNo);
        System.out.println("Account deleted successfully!");
    }
}