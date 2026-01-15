package com.jdbcconnectivity.bankmanagement.util;
import java.sql.*;

public class DatabaseUtil {
    private static final String url = "jdbc:mysql://localhost:3306/bankmanagement?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";  // Replace with your MySQL username
    private static final String password = "Aanchal@18";  // Replace with your MySQL password
  //to store Connection data
  		private static Connection con = null;
    
    public static Connection getConnection() throws SQLException {
        try {
        	con = DriverManager.getConnection(url,username,password);
			//calling method to create a table
			createTables();
        } 
        catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		return con;
    }
    public static void closeConnection()
	{
		try {
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
	}
	
  //method to create tables if not exists
	
  		public static void createTables()
  		{
  			try
  			{
  				if(con != null)
  				{
  			 // Creating statement reference
            Statement stmt = con.createStatement();

            // Query for creation of customers table
            String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers ("
                    + "customer_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(100) NOT NULL,"
                    + "email VARCHAR(100) UNIQUE NOT NULL,"
                    + "phone VARCHAR(15),"
                    + "address VARCHAR(200),"
                    + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

            // Query for creation of accounts table
            String createAccountsTable = "CREATE TABLE IF NOT EXISTS accounts ("
                    + "account_no VARCHAR(20) PRIMARY KEY,"
                    + "customer_id INT,"
                    + "account_type VARCHAR(50),"
                    + "balance DOUBLE DEFAULT 0.0,"
                    + "status VARCHAR(20) DEFAULT 'active',"
                    + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE)";

            // Query for creation of transactions table
            String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions ("
                    + "trans_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "account_no VARCHAR(20),"
                    + "type VARCHAR(50),"
                    + "amount DOUBLE,"
                    + "trans_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "description VARCHAR(255),"
                    + "FOREIGN KEY (account_no) REFERENCES accounts(account_no) ON DELETE CASCADE)";

            // Query for creation of loans table
            String createLoansTable = "CREATE TABLE IF NOT EXISTS loans ("
                    + "loan_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "customer_id INT,"
                    + "loan_type VARCHAR(50),"
                    + "amount DOUBLE,"
                    + "interest_rate DOUBLE,"
                    + "tenure_months INT,"
                    + "status VARCHAR(20) DEFAULT 'active',"
                    + "FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE)";

            // Query for creation of loan_payments table
            String createLoanPaymentsTable = "CREATE TABLE IF NOT EXISTS loan_payments ("
                    + "payment_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "loan_id INT,"
                    + "emi_amount DOUBLE,"
                    + "payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "remaining_amt DOUBLE,"
                    + "FOREIGN KEY (loan_id) REFERENCES loans(loan_id) ON DELETE CASCADE)";

            // Query for creation of employees table
            String createEmployeesTable = "CREATE TABLE IF NOT EXISTS employees ("
                    + "emp_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(100) NOT NULL,"
                    + "designation VARCHAR(100),"
                    + "salary DOUBLE,"
                    + "join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

            // Query for creation of login table
            String createLoginTable = "CREATE TABLE IF NOT EXISTS login ("
                    + "login_id INT PRIMARY KEY,"
                    + "role VARCHAR(50),"
                    + "password VARCHAR(200),"
                    + "FOREIGN KEY (login_id) REFERENCES employees(emp_id) ON DELETE CASCADE)";

            // Adding queries into batches
            stmt.addBatch(createCustomersTable);
            stmt.addBatch(createAccountsTable);
            stmt.addBatch(createTransactionsTable);
            stmt.addBatch(createLoansTable);
            stmt.addBatch(createLoanPaymentsTable);
            stmt.addBatch(createEmployeesTable);
            stmt.addBatch(createLoginTable);

            // Executing batch
            stmt.executeBatch();
            System.out.println("Verified successfully.");
        }
    } catch (SQLException sqe) {
        System.out.println("Table Creation Error: " + sqe.getMessage());
    }
  	}
   
  }