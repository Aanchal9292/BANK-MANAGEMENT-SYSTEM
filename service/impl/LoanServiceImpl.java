package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.LoanDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.LoanDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.Loan;
import com.jdbcconnectivity.bankmanagement.service.LoanService;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private LoanDAO loanDAO = new LoanDAOImpl();

    @Override
    public void addLoan(Loan loan) {
        if (loan.getCustomerId() <= 0 || loan.getAmount() <= 0) {
            throw new IllegalArgumentException("Valid Customer ID and positive amount are required");
        }
        loanDAO.addLoan(loan);
    }

    @Override
    public Loan getLoanById(int loanId) {
        return loanDAO.getLoanById(loanId);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanDAO.getAllLoans();
    }

    @Override
    public void updateLoan(Loan loan) {
        loanDAO.updateLoan(loan);
    }

    @Override
    public void deleteLoan(int loanId) {
        loanDAO.deleteLoan(loanId);
    }
}