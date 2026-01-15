package com.jdbcconnectivity.bankmanagement.dao;

import com.jdbcconnectivity.bankmanagement.model.LoanPayment;
import java.util.List;

public interface LoanPaymentDAO {
    void addLoanPayment(LoanPayment loanPayment);
    LoanPayment getLoanPaymentById(int paymentId);
    List<LoanPayment> getAllLoanPayments();
    void updateLoanPayment(LoanPayment loanPayment);
    void deleteLoanPayment(int paymentId);
}