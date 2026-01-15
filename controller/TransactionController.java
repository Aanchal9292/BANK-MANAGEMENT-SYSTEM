package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;
import com.jdbcconnectivity.bankmanagement.model.Transaction;
import com.jdbcconnectivity.bankmanagement.service.TransactionService;
import com.jdbcconnectivity.bankmanagement.service.impl.TransactionServiceImpl;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class TransactionController {
    private TransactionService transactionService = new TransactionServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addTransaction(Transaction transaction) { transactionService.addTransaction(transaction); }
    public Transaction getTransactionById(int transId) { return transactionService.getTransactionById(transId); }
    public List<Transaction> getAllTransactions() { return transactionService.getAllTransactions(); }
    public void updateTransaction(Transaction transaction) { transactionService.updateTransaction(transaction); }
    public void deleteTransaction(int transId) { transactionService.deleteTransaction(transId); }

    // New interactive methods with table display
    public void addTransaction() {
        System.out.print("Enter account number: ");
        String accountNo = scanner.nextLine();
        System.out.print("Enter type (e.g., Deposit): ");
        String type = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        Transaction transaction = new Transaction(0, accountNo, type, amount, new Timestamp(System.currentTimeMillis()), description);
        try {
            addTransaction(transaction);
            System.out.println("Transaction added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewTransaction() {
        System.out.print("Enter transaction ID: ");
        int transId = scanner.nextInt();
        scanner.nextLine();
        Transaction transaction = getTransactionById(transId);
        if (transaction != null) {
            App.printTableHeader("Trans ID", "Type", "Amount", "Date", "Description");
            App.printTableRow(transaction.getTransId(), transaction.getType(), transaction.getAmount(), transaction.getTransDate(), transaction.getDescription());
            App.printTableFooter();
        } else {
            System.out.println("Transaction not found!");
        }
    }

    public void viewTransactionsByAccount() {
        System.out.print("Enter account number: ");
        String accountNo = scanner.nextLine();
        List<Transaction> transactions = getAllTransactions();
        boolean found = false;
        App.printTableHeader("Trans ID", "Type", "Amount", "Date", "Description");
        for (Transaction t : transactions) {
            if (t.getAccountNo().equals(accountNo)) {
                App.printTableRow(t.getTransId(), t.getType(), t.getAmount(), t.getTransDate(), t.getDescription());
                found = true;
            }
        }
        App.printTableFooter();
        if (!found) {
            System.out.println("No transactions found for this account!");
        }
    }

    public void deleteTransaction() {
        System.out.print("Enter transaction ID to delete: ");
        int transId = scanner.nextInt();
        scanner.nextLine();
        deleteTransaction(transId);
        System.out.println("Transaction deleted successfully!");
    }
}