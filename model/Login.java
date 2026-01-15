package com.jdbcconnectivity.bankmanagement.model;

public class Login {
	//to store login id
    private int loginId;
  //to store role
    private String role;
  //to store password
    private String password;
    /*---------------------------------------*/
	/*--------- Default constructor----------*/

    public Login() {
    	super();
    }
    /*-----------------------------------------------------*/
	//----- parameterised constructor ------
    public Login(int loginId, String role, String password) {
        super();
    	this.loginId = loginId;
        this.role = role;
        this.password = password;
    }

    // Getters and Setters
    public int getLoginId() { 
    	return loginId; 
    }
    public void setLoginId(int loginId) {
    	this.loginId = loginId; 
    }
    public String getRole() { 
    	return role;
    }
    public void setRole(String role) {
    	this.role = role;
    }
    public String getPassword() {
    	return password; 
    }
    public void setPassword(String password) { 
    	this.password = password;
    }
	@Override
	public String toString() {
		return "Login ID : " + loginId
				+ "\n Role=" + role 
				+ "\n Password : " + password
				+ "\n----------------------------\n";
	}
	
    
}