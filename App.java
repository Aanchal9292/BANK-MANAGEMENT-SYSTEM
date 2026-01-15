package com.jdbcconnectivity.bankmanagement;

import com.jdbcconnectivity.bankmanagement.controller.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        AccountController accountController = new AccountController();
        TransactionController transactionController = new TransactionController();
        LoanController loanController = new LoanController();
        LoanPaymentController loanPaymentController = new LoanPaymentController();
        EmployeeController employeeController = new EmployeeController();
        LoginController loginController = new LoginController();

        System.out.println("Welcome to Bank Management System");
        System.out.print("Login required. Enter login ID: ");
        int loginId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (loginController.authenticate(loginId, password) != null) {
            System.out.println("Authentication failed!");
            scanner.close();
            return;
        }
        else
        {
        	System.out.println("Authentication successful!");
        
        }

        while (true) {
        	System.out.println("---------------------------------------");
            System.out.println("\nMenu:");
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Accounts");
            System.out.println("3. Manage Transactions");
            System.out.println("4. Manage Loans");
            System.out.println("5. Manage Loan Payments");
            System.out.println("6. Manage Employees");
            System.out.println("7. Manage Login");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Customer\n2. View Customer\n3. View All Customers\n4. Update Customer\n5. Delete Customer\n");
                    System.out.print("Choose: ");
                    int custChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (custChoice == 1) customerController.addCustomer();
                    else if (custChoice == 2) customerController.viewCustomer();
                    else if (custChoice == 3) customerController.viewAllCustomers();
                    else if (custChoice == 4) customerController.updateCustomer();
                    else if (custChoice == 5) customerController.deleteCustomer();
                    else System.out.println("Invalid choice!");
                    break;
                case 2:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Account\n2. View Account\n3. View Accounts by Customer\n4. Deposit\n5. Withdraw\n6. Delete Account");
                    System.out.print("Choose: ");
                    int accChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (accChoice == 1) accountController.addAccount();
                    else if (accChoice == 2) accountController.viewAccount();
                    else if (accChoice == 3) accountController.viewAccountsByCustomer();
                    else if (accChoice == 4) accountController.deposit();
                    else if (accChoice == 5) accountController.withdraw();
                    else if (accChoice == 6) accountController.deleteAccount();
                    else System.out.println("Invalid choice!");
                    break;
                case 3:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Transaction\n2. View Transaction\n3. View Transactions by Account\n4. Delete Transaction");
                    System.out.print("Choose: ");
                    int transChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (transChoice == 1) transactionController.addTransaction();
                    else if (transChoice == 2) transactionController.viewTransaction();
                    else if (transChoice == 3) transactionController.viewTransactionsByAccount();
                    else if (transChoice == 4) transactionController.deleteTransaction();
                    else System.out.println("Invalid choice!");
                    break;
                case 4:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Loan \n2. View Loan \n3. View All Loans\n4. Update Loan\n5. Delete Loan");
                    System.out.print("Choose: ");
                    int loanChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (loanChoice == 1) loanController.addLoan();
                    else if (loanChoice == 2) loanController.viewLoan();
                    else if (loanChoice == 3) loanController.viewAllLoans();
                    else if (loanChoice == 4) loanController.updateLoan();
                    else if (loanChoice == 5) loanController.deleteLoan();
                    else System.out.println("Invalid choice!");
                    break;
                case 5:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Loan Payment\n2. View Loan Payment\n3. View All Loan Payments\n4. Update Loan Payment\n5. Delete Loan Payment");
                    System.out.print("Choose: ");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (paymentChoice == 1) loanPaymentController.addLoanPayment();
                    else if (paymentChoice == 2) loanPaymentController.viewLoanPayment();
                    else if (paymentChoice == 3) loanPaymentController.viewAllLoanPayments();
                    else if (paymentChoice == 4) loanPaymentController.updateLoanPayment();
                    else if (paymentChoice == 5) loanPaymentController.deleteLoanPayment();
                    else System.out.println("Invalid choice!");
                    break;
                case 6:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Employee\n 2. View Employee\n  3. View All Employees\n  4. Update Employee\n  5. Delete Employee\n");
                    System.out.print("Choose: ");
                    int empChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (empChoice == 1) employeeController.addEmployee();
                    else if (empChoice == 2) employeeController.viewEmployee();
                    else if (empChoice == 3) employeeController.viewAllEmployees();
                    else if (empChoice == 4) employeeController.updateEmployee();
                    else if (empChoice == 5) employeeController.deleteEmployee();
                    else System.out.println("Invalid choice!");
                    break;
                case 7:
                	System.out.println("-------------------------------------");
                    System.out.println("1. Add Login\n2. View Login\n3. View All Logins\n4. Update Login\n5. Delete Login");
                    System.out.print("Choose: ");
                    int loginChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (loginChoice == 1) loginController.addLogin();
                    else if (loginChoice == 2) loginController.viewLogin();
                    else if (loginChoice == 3) loginController.viewAllLogins();
                    else if (loginChoice == 4) loginController.updateLogin();
                    else if (loginChoice == 5) loginController.deleteLogin();
                    else System.out.println("Invalid choice!");
                    break;
                case 8:
                	System.out.println("-------------------------------------");
                    System.out.println("Exiting..............");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Helper methods for table formatting
    public static void printTableHeader(String... headers) {
        System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
        for (String header : headers) {
            System.out.printf("| %-30s ", header);
        }
        System.out.println("|");
        System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
    }

    public static void printTableRow(Object... values) {
        for (Object value : values) {
            System.out.printf("| %-30s ", value.toString());
        }
        System.out.println("|");
    }

    public static void printTableFooter() {
        System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
    }
}