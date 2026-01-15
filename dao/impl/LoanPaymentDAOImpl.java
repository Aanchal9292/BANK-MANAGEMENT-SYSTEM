package com.jdbcconnectivity.bankmanagement.dao.impl;

import com.jdbcconnectivity.bankmanagement.dao.LoanPaymentDAO;
import com.jdbcconnectivity.bankmanagement.model.LoanPayment;
import com.jdbcconnectivity.bankmanagement.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanPaymentDAOImpl implements LoanPaymentDAO {
    @Override
    public void addLoanPayment(LoanPayment loanPayment) {
        String sql = "INSERT INTO loan_payments (loan_id, emi_amount, payment_date, remaining_amt) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loanPayment.getLoanId());
            stmt.setDouble(2, loanPayment.getEmiAmount());
            stmt.setTimestamp(3, loanPayment.getPaymentDate());
            stmt.setDouble(4, loanPayment.getRemainingAmt());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LoanPayment getLoanPaymentById(int paymentId) {
        String sql = "SELECT * FROM loan_payments WHERE payment_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new LoanPayment(rs.getInt("payment_id"), rs.getInt("loan_id"), rs.getDouble("emi_amount"), rs.getTimestamp("payment_date"), rs.getDouble("remaining_amt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LoanPayment> getAllLoanPayments() {
        List<LoanPayment> loanPayments = new ArrayList<>();
        String sql = "SELECT * FROM loan_payments";
        try (Connection conn = DatabaseUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loanPayments.add(new LoanPayment(rs.getInt("payment_id"), rs.getInt("loan_id"), rs.getDouble("emi_amount"), rs.getTimestamp("payment_date"), rs.getDouble("remaining_amt")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loanPayments;
    }

    @Override
    public void updateLoanPayment(LoanPayment loanPayment) {
        String sql = "UPDATE loan_payments SET loan_id = ?, emi_amount = ?, payment_date = ?, remaining_amt = ? WHERE payment_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loanPayment.getLoanId());
            stmt.setDouble(2, loanPayment.getEmiAmount());
            stmt.setTimestamp(3, loanPayment.getPaymentDate());
            stmt.setDouble(4, loanPayment.getRemainingAmt());
            stmt.setInt(5, loanPayment.getPaymentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLoanPayment(int paymentId) {
        String sql = "DELETE FROM loan_payments WHERE payment_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}