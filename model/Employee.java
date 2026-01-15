package com.jdbcconnectivity.bankmanagement.model;

import java.sql.Timestamp;

public class Employee {
  //to store emplyee id
    private int empId;
  //to store name
    private String name;
  //to store designation
    private String designation;
  //to store salary
    private double salary;
  //to store join date
    private Timestamp joinDate;
    /*---------------------------------------*/
	/*--------- Default constructor -------*/
    public Employee() {
    	super();
    }
    /*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public Employee(int empId, String name, String designation, double salary, Timestamp joinDate) {
        super();
    	this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    // Getters and Setters
    public int getEmpId() { 
    	return empId; 
    }
    public void setEmpId(int empId) { 
    	this.empId = empId; 
    }
    public String getName() {
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    public String getDesignation() {
    	return designation;
    }
    public void setDesignation(String designation) { 
    	this.designation = designation;
    }
    public double getSalary() { 
    	return salary; 
    }
    public void setSalary(double salary) {
    	this.salary = salary; 
    }
    public Timestamp getJoinDate() { 
    	return joinDate;
    }
    public void setJoinDate(Timestamp joinDate) {
    	this.joinDate = joinDate;
    }
	@Override
	public String toString() {
		return "Employee ID : " + empId 
				+ "\n Name : " + name
				+ "\n Designation : " + designation
				+ "\n Salary : " + salary
				+ "\n Join Date=" + joinDate 
				+ "\n----------------------------\n";
	}
    
}