package com.jdbcconnectivity.bankmanagement.service;

import com.jdbcconnectivity.bankmanagement.model.Transaction;
import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    Transaction getTransactionById(int transId);
    List<Transaction> getAllTransactions();
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int transId);
}