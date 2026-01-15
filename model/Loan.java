package com.jdbcconnectivity.bankmanagement.model;

public class Loan {
	//to store loan id
    private int loanId;
    //to store customer id
    private int customerId;
    //to store loan  type
    private String loanType;
    //to store amount
    private double amount;
    //to store interest rate
    private double interestRate;
    //to store tenure  in months
    private int tenureMonths;
    //to store status
    private String status;
    /*---------------------------------------*/
	/*--------- Default constructor -------*/
    public Loan() {
    	super();
    }
	/*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public Loan(int loanId, int customerId, String loanType, double amount, double interestRate, int tenureMonths, String status) {
        super();
    	this.loanId = loanId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.status = status;
    }

    // Getters and Setters
    public int getLoanId() { 
    	return loanId;
    }
    public void setLoanId(int loanId) {
    	this.loanId = loanId; 
    }
    public int getCustomerId() { 
    	return customerId; 
    }
    public void setCustomerId(int customerId) { 
    	this.customerId = customerId; 
    }
    public String getLoanType() { 
    	return loanType; 
    }
    public void setLoanType(String loanType) { 
    	this.loanType = loanType;
    }
    public double getAmount() { 
    	return amount; 
    }
    public void setAmount(double amount) { 
    	this.amount = amount;
    }
    public double getInterestRate() {
    	return interestRate;
    }
    public void setInterestRate(double interestRate) { 
    	this.interestRate = interestRate;
    }
    public int getTenureMonths() { 
    	return tenureMonths;
    }
    public void setTenureMonths(int tenureMonths) {
    	this.tenureMonths = tenureMonths;
    }
    public String getStatus() { 
    	return status;
    }
    public void setStatus(String status) { 
    	this.status = status; 
    }
	@Override
	public String toString() {
		return "Loan ID : " + loanId
				+ "\n Customer ID : " + customerId 
				+ "\n Loan Type : " + loanType 
				+ "\n Amount=" + amount
				+ "\n Rate of interest : " + interestRate 
				+ "\n Tenure ( in Months) : " + tenureMonths 
				+ "\n Status : " + status
				+ "\n-------------------------------\n";
	}
    
}