package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.TransactionDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.TransactionDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.Transaction;
import com.jdbcconnectivity.bankmanagement.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    @Override
    public void addTransaction(Transaction transaction) {
        if (transaction.getAccountNo() == null || transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Account number and positive amount are required");
        }
        transactionDAO.addTransaction(transaction);
    }

    @Override
    public Transaction getTransactionById(int transId) {
        return transactionDAO.getTransactionById(transId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        transactionDAO.updateTransaction(transaction);
    }

    @Override
    public void deleteTransaction(int transId) {
        transactionDAO.deleteTransaction(transId);
    }
}