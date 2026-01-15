package com.jdbcconnectivity.bankmanagement.dao.impl;

import com.jdbcconnectivity.bankmanagement.dao.TransactionDAO;
import com.jdbcconnectivity.bankmanagement.model.Transaction;
import com.jdbcconnectivity.bankmanagement.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (account_no, type, amount, trans_date, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transaction.getAccountNo());
            stmt.setString(2, transaction.getType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setTimestamp(4, transaction.getTransDate());
            stmt.setString(5, transaction.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaction getTransactionById(int transId) {
        String sql = "SELECT * FROM transactions WHERE trans_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Transaction(rs.getInt("trans_id"), rs.getString("account_no"), rs.getString("type"), rs.getDouble("amount"), rs.getTimestamp("trans_date"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Connection conn = DatabaseUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(rs.getInt("trans_id"), rs.getString("account_no"), rs.getString("type"), rs.getDouble("amount"), rs.getTimestamp("trans_date"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET account_no = ?, type = ?, amount = ?, trans_date = ?, description = ? WHERE trans_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transaction.getAccountNo());
            stmt.setString(2, transaction.getType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setTimestamp(4, transaction.getTransDate());
            stmt.setString(5, transaction.getDescription());
            stmt.setInt(6, transaction.getTransId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransaction(int transId) {
        String sql = "DELETE FROM transactions WHERE trans_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}