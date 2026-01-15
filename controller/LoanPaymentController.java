package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;

import com.jdbcconnectivity.bankmanagement.model.LoanPayment;
import com.jdbcconnectivity.bankmanagement.service.LoanPaymentService;
import com.jdbcconnectivity.bankmanagement.service.impl.LoanPaymentServiceImpl;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class LoanPaymentController {
    private LoanPaymentService loanPaymentService = new LoanPaymentServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addLoanPayment(LoanPayment loanPayment) { loanPaymentService.addLoanPayment(loanPayment); }
    public LoanPayment getLoanPaymentById(int paymentId) { return loanPaymentService.getLoanPaymentById(paymentId); }
    public List<LoanPayment> getAllLoanPayments() { return loanPaymentService.getAllLoanPayments(); }
    public void updateLoanPayment(LoanPayment loanPayment) { loanPaymentService.updateLoanPayment(loanPayment); }
    public void deleteLoanPayment(int paymentId) { loanPaymentService.deleteLoanPayment(paymentId); }

    // New interactive methods with table display
    public void addLoanPayment() {
        System.out.print("Enter loan ID: ");
        int loanId = scanner.nextInt();
        System.out.print("Enter EMI amount: ");
        double emiAmount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter remaining amount: ");
        double remainingAmt = scanner.nextDouble();
        scanner.nextLine();
        LoanPayment loanPayment = new LoanPayment(0, loanId, emiAmount, new Timestamp(System.currentTimeMillis()), remainingAmt);
        try {
            addLoanPayment(loanPayment);
            System.out.println("Loan Payment added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewLoanPayment() {
        System.out.print("Enter payment ID: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine();
        LoanPayment loanPayment = getLoanPaymentById(paymentId);
        if (loanPayment != null) {
            App.printTableHeader("Payment ID", "Loan ID", "EMI Amount", "Payment Date", "Remaining Amount");
            App.printTableRow(loanPayment.getPaymentId(), loanPayment.getLoanId(), loanPayment.getEmiAmount(), loanPayment.getPaymentDate(), loanPayment.getRemainingAmt());
            App.printTableFooter();
        } else {
            System.out.println("Loan Payment not found!");
        }
    }

    public void viewAllLoanPayments() {
        List<LoanPayment> loanPayments = getAllLoanPayments();
        if (loanPayments.isEmpty()) {
            System.out.println("No loan payments found!");
            return;
        }
        App.printTableHeader("Payment ID", "Loan ID", "EMI Amount", "Payment Date", "Remaining Amount");
        for (LoanPayment lp : loanPayments) {
            App.printTableRow(lp.getPaymentId(), lp.getLoanId(), lp.getEmiAmount(), lp.getPaymentDate(), lp.getRemainingAmt());
        }
        App.printTableFooter();
    }

    public void updateLoanPayment() {
        System.out.print("Enter payment ID to update: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine();
        LoanPayment existing = getLoanPaymentById(paymentId);
        if (existing == null) {
            System.out.println("Loan Payment not found!");
            return;
        }
        System.out.print("Enter new EMI amount: ");
        double emiAmount = scanner.nextDouble();
        System.out.print("Enter new remaining amount: ");
        double remainingAmt = scanner.nextDouble();
        scanner.nextLine();
        existing.setEmiAmount(emiAmount);
        existing.setRemainingAmt(remainingAmt);
        updateLoanPayment(existing);
        System.out.println("Loan Payment updated successfully!");
    }

    public void deleteLoanPayment() {
        System.out.print("Enter payment ID to delete: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine();
        deleteLoanPayment(paymentId);
        System.out.println("Loan Payment deleted successfully!");
    }
}