package com.jdbcconnectivity.bankmanagement.model;


import java.sql.Timestamp;

public class Customer {
  //to store customer id
    private int customerId;
  //to store name
    private String name;
  //to store email
    private String email;
  //to store phone
    private String phone;
  //to store address
    private String address;
  //to store date of account created
    private Timestamp createdAt;
    /*---------------------------------------*/
	/*--------- Default constructor -------*/
    public Customer() {
    	super();
    }
    /*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public Customer(int customerId, String name, String email, String phone, String address, Timestamp createdAt) {
    	super();
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
    }
    /*--------------------------------------------------------------------*/
	/*----- Getter and setters --------*/
    public int getCustomerId() { 
    	return customerId;
    	
    }
    public void setCustomerId(int customerId) { 
    	this.customerId = customerId;
    }
    public String getName() { 
    	return name;
    }
    public void setName(String name) { 
    	this.name = name;
    }
    public String getEmail() { 
    	return email;
    }
    public void setEmail(String email) { 
    	this.email = email;
    }
    public String getPhone() { 
    	return phone;
    }
    public void setPhone(String phone) { 
    	this.phone = phone; 
    }
    public String getAddress() { 
    	return address; 
    }
    public void setAddress(String address) { 
    	this.address = address;
    }
    public Timestamp getCreatedAt() { 
    	return createdAt; 
    }
    public void setCreatedAt(Timestamp createdAt) { 
    	this.createdAt = createdAt; 
    }

	@Override
	public String toString() {
		return "Customer ID : " + customerId
				+ "\n Name : " + name 
				+ "\n Email ID : " + email
				+ "\n Phone Number : " + phone
				+ "\n Address : " + address 
				+ "\n CreatedAt : " + createdAt 
				+ "\n-----------------------------------\n";
	}
}