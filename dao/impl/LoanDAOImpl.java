package com.jdbcconnectivity.bankmanagement.dao.impl;

import com.jdbcconnectivity.bankmanagement.dao.LoanDAO;
import com.jdbcconnectivity.bankmanagement.model.Loan;
import com.jdbcconnectivity.bankmanagement.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAOImpl implements LoanDAO {
    @Override
    public void addLoan(Loan loan) {
        String sql = "INSERT INTO loans (customer_id, loan_type, amount, interest_rate, tenure_months, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loan.getCustomerId());
            stmt.setString(2, loan.getLoanType());
            stmt.setDouble(3, loan.getAmount());
            stmt.setDouble(4, loan.getInterestRate());
            stmt.setInt(5, loan.getTenureMonths());
            stmt.setString(6, loan.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Loan getLoanById(int loanId) {
        String sql = "SELECT * FROM loans WHERE loan_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loanId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Loan(rs.getInt("loan_id"), rs.getInt("customer_id"), rs.getString("loan_type"), rs.getDouble("amount"), rs.getDouble("interest_rate"), rs.getInt("tenure_months"), rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Loan> getAllLoans() {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM loans";
        try (Connection conn = DatabaseUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loans.add(new Loan(rs.getInt("loan_id"), rs.getInt("customer_id"), rs.getString("loan_type"), rs.getDouble("amount"), rs.getDouble("interest_rate"), rs.getInt("tenure_months"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loans;
    }

    @Override
    public void updateLoan(Loan loan) {
        String sql = "UPDATE loans SET customer_id = ?, loan_type = ?, amount = ?, interest_rate = ?, tenure_months = ?, status = ? WHERE loan_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loan.getCustomerId());
            stmt.setString(2, loan.getLoanType());
            stmt.setDouble(3, loan.getAmount());
            stmt.setDouble(4, loan.getInterestRate());
            stmt.setInt(5, loan.getTenureMonths());
            stmt.setString(6, loan.getStatus());
            stmt.setInt(7, loan.getLoanId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLoan(int loanId) {
        String sql = "DELETE FROM loans WHERE loan_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loanId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}