package com.jdbcconnectivity.bankmanagement.model;

import java.sql.Timestamp;

public class LoanPayment {
	//to store payment id
    private int paymentId;
    //to store loan id
    private int loanId;
    //to store emi amount
    private double emiAmount;
    //to store payment date
    private Timestamp paymentDate;
    //to store remaining amount
    private double remainingAmt;

    public LoanPayment() {
    	super();
    }
    /*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public LoanPayment(int paymentId, int loanId, double emiAmount, Timestamp paymentDate, double remainingAmt) {
        super();
    	this.paymentId = paymentId;
        this.loanId = loanId;
        this.emiAmount = emiAmount;
        this.paymentDate = paymentDate;
        this.remainingAmt = remainingAmt;
    }

    /*--------------------------------------------------------------------*/
	/*----- Getter and setters --------*/
    public int getPaymentId() { 
    	return paymentId; 
    }
    public void setPaymentId(int paymentId) { 
    	this.paymentId = paymentId;
    }
    public int getLoanId() { 
    	return loanId;
    }
    public void setLoanId(int loanId) {
    	this.loanId = loanId;
    }
    public double getEmiAmount() { 
    	return emiAmount;
    }
    public void setEmiAmount(double emiAmount) { 
    	this.emiAmount = emiAmount;
    }
    public Timestamp getPaymentDate() { 
    	return paymentDate; 
    }
    public void setPaymentDate(Timestamp paymentDate) { 
    	this.paymentDate = paymentDate;
    }
    public double getRemainingAmt() {
    	return remainingAmt; 
    }
    public void setRemainingAmt(double remainingAmt) {
    	this.remainingAmt = remainingAmt;
    }
	@Override
	public String toString() {
		return "Payment ID : " + paymentId
				+ "\n Loan ID : " + loanId 
				+ "\n EMI Amount : " + emiAmount
				+ "\n Date of Payment : " + paymentDate 
				+ "\n Remaining Amount : " + remainingAmt 
				+ "\n---------------------------------------\n";
	}
    
}