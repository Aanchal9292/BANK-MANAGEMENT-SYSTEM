package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;
import com.jdbcconnectivity.bankmanagement.model.Loan;
import com.jdbcconnectivity.bankmanagement.service.LoanService;
import com.jdbcconnectivity.bankmanagement.service.impl.LoanServiceImpl;
import java.util.List;
import java.util.Scanner;

public class LoanController {
    private LoanService loanService = new LoanServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addLoan(Loan loan) { loanService.addLoan(loan); }
    public Loan getLoanById(int loanId) { return loanService.getLoanById(loanId); }
    public List<Loan> getAllLoans() { return loanService.getAllLoans(); }
    public void updateLoan(Loan loan) { loanService.updateLoan(loan); }
    public void deleteLoan(int loanId) { loanService.deleteLoan(loanId); }

    // New interactive methods with table display
    public void addLoan() {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter loan type: ");
        String loanType = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter tenure (months): ");
        int tenure = scanner.nextInt();
        scanner.nextLine();
        Loan loan = new Loan(0, customerId, loanType, amount, interestRate, tenure, "active");
        try {
            addLoan(loan);
            System.out.println("Loan added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewLoan() {
        System.out.print("Enter loan ID: ");
        int loanId = scanner.nextInt();
        scanner.nextLine();
        Loan loan = getLoanById(loanId);
        if (loan != null) {
            App.printTableHeader("Loan ID", "Customer ID", "Type", "Amount", "Interest Rate", "Tenure", "Status");
            App.printTableRow(loan.getLoanId(), loan.getCustomerId(), loan.getLoanType(), loan.getAmount(), loan.getInterestRate(), loan.getTenureMonths(), loan.getStatus());
            App.printTableFooter();
        } else {
            System.out.println("Loan not found!");
        }
    }

    public void viewAllLoans() {
        List<Loan> loans = getAllLoans();
        if (loans.isEmpty()) {
            System.out.println("No loans found!");
            return;
        }
        App.printTableHeader("Loan ID", "Customer ID", "Type", "Amount", "Interest Rate", "Tenure", "Status");
        for (Loan l : loans) {
            App.printTableRow(l.getLoanId(), l.getCustomerId(), l.getLoanType(), l.getAmount(), l.getInterestRate(), l.getTenureMonths(), l.getStatus());
        }
        App.printTableFooter();
    }

    public void updateLoan() {
        System.out.print("Enter loan ID to update: ");
        int loanId = scanner.nextInt();
        scanner.nextLine();
        Loan existing = getLoanById(loanId);
        if (existing == null) {
            System.out.println("Loan not found!");
            return;
        }
        System.out.print("Enter new loan type: ");
        String loanType = scanner.nextLine();
        System.out.print("Enter new amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter new interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter new tenure (months): ");
        int tenure = scanner.nextInt();
        scanner.nextLine();
        existing.setLoanType(loanType);
        existing.setAmount(amount);
        existing.setInterestRate(interestRate);
        existing.setTenureMonths(tenure);
        updateLoan(existing);
        System.out.println("Loan updated successfully!");
    }

    public void deleteLoan() {
        System.out.print("Enter loan ID to delete: ");
        int loanId = scanner.nextInt();
        scanner.nextLine();
        deleteLoan(loanId);
        System.out.println("Loan deleted successfully!");
    }
}