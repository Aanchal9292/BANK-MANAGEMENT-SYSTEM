package com.jdbcconnectivity.bankmanagement.dao;

import com.jdbcconnectivity.bankmanagement.model.Loan;
import java.util.List;

public interface LoanDAO {
    void addLoan(Loan loan);
    Loan getLoanById(int loanId);
    List<Loan> getAllLoans();
    void updateLoan(Loan loan);
    void deleteLoan(int loanId);
}
