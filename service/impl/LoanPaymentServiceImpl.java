package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.LoanPaymentDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.LoanPaymentDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.LoanPayment;
import com.jdbcconnectivity.bankmanagement.service.LoanPaymentService;
import java.util.List;

public class LoanPaymentServiceImpl implements LoanPaymentService {
    private LoanPaymentDAO loanPaymentDAO = new LoanPaymentDAOImpl();

    @Override
    public void addLoanPayment(LoanPayment loanPayment) {
        if (loanPayment.getLoanId() <= 0 || loanPayment.getEmiAmount() <= 0) {
            throw new IllegalArgumentException("Valid Loan ID and positive EMI amount are required");
        }
        loanPaymentDAO.addLoanPayment(loanPayment);
    }

    @Override
    public LoanPayment getLoanPaymentById(int paymentId) {
        return loanPaymentDAO.getLoanPaymentById(paymentId);
    }

    @Override
    public List<LoanPayment> getAllLoanPayments() {
        return loanPaymentDAO.getAllLoanPayments();
    }

    @Override
    public void updateLoanPayment(LoanPayment loanPayment) {
        loanPaymentDAO.updateLoanPayment(loanPayment);
    }

    @Override
    public void deleteLoanPayment(int paymentId) {
        loanPaymentDAO.deleteLoanPayment(paymentId);
    }
}