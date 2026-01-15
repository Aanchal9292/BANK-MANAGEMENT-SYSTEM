package com.jdbcconnectivity.bankmanagement.model;
import java.sql.Timestamp;

public class Account {
	//to store account number
    private String accountNo;
  //to store customer id
    private int customerId;
  //to store account type
    private String accountType;
  //to store balance
    private double balance;
  //to store status
    private String status;
  //to store account created date
    private Timestamp createdAt;
    /*---------------------------------------*/
	/*--------- Default constructor -------*/
    public Account() {
    	super();
    }
    /*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public Account(String accountNo, int customerId, String accountType, double balance, String status, Timestamp createdAt) {
        super();
    	this.accountNo = accountNo;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getAccountNo() { 
    	return accountNo;
    }
    public void setAccountNo(String accountNo) { 
    	this.accountNo = accountNo;
    }
    public int getCustomerId() { 
    	return customerId; 
    }
    public void setCustomerId(int customerId) { 
    	this.customerId = customerId;
    }
    public String getAccountType() {
    	return accountType;
    }
    public void setAccountType(String accountType) { 
    	this.accountType = accountType; 
    }
    public double getBalance() { 
    	return balance; 
    }
    public void setBalance(double balance) { 
    	this.balance = balance; 
    }
    public String getStatus() { 
    	return status; 
    }
    public void setStatus(String status) { 
    	this.status = status; 
    }
    public Timestamp getCreatedAt() { 
    	return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
    	this.createdAt = createdAt; 
    }
    public String toString() {
		return "Acconut Number : " + accountNo
				+ "\n Customer ID : " + customerId 
				+ "\n Account Type : " + accountType
				+ "\n Balance : " + balance 
				+ "\n Status of Account : " + status
				+ "\n Created At : " + createdAt
				+ "\n------------------------------------\n";
	}
}