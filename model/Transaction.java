package com.jdbcconnectivity.bankmanagement.model;

import java.sql.Timestamp;

public class Transaction {
	//to store transaction id
    private int transId;
  //to store account number
    private String accountNo;
  //to store type
    private String type;
  //to store amount
    private double amount;
  //to store transaction date
    private Timestamp transDate;
  //to store description
    private String description;
    /*---------------------------------------*/
	/*--------- Default constructor -------*/
    public Transaction() {
    	super();
    	
    }
	/*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public Transaction(int transId, String accountNo, String type, double amount, Timestamp transDate, String description) {
        super();
    	this.transId = transId;
        this.accountNo = accountNo;
        this.type = type;
        this.amount = amount;
        this.transDate = transDate;
        this.description = description;
    }

    // Getters and Setters
    public int getTransId() { 
    	return transId;
    }
    public void setTransId(int transId) { 
    	this.transId = transId; 
    }
    public String getAccountNo() { 
    	return accountNo; 
    }
    public void setAccountNo(String accountNo) { 
    	this.accountNo = accountNo;
    }
    public String getType() {
    	return type; 
    }
    public void setType(String type) { 
    	this.type = type; 
    }
    public double getAmount() { 
    	return amount;
    }
    public void setAmount(double amount) { 
    	this.amount = amount;
    }
    public Timestamp getTransDate() { 
    	return transDate; 
    }
    public void setTransDate(Timestamp transDate) { 
    	this.transDate = transDate;
    }
    public String getDescription() { 
    	return description;
    }
    public void setDescription(String description) { 
    	this.description = description; 
    }

	@Override
	public String toString() {
		return "Transaction ID : " + transId +
				"\n Account Number : " + accountNo
				+ "\n Type : " + type 
				+ "\n Amount : " + amount
				+ "\n Transaction Date : " + transDate
				+ "\n Description : " + description 
				+ "\n--------------------------------------\n";
	}
    
}
