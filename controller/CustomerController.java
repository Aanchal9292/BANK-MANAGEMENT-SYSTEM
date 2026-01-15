package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;
import com.jdbcconnectivity.bankmanagement.model.Customer;
import com.jdbcconnectivity.bankmanagement.service.CustomerService;
import com.jdbcconnectivity.bankmanagement.service.impl.CustomerServiceImpl;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addCustomer(Customer customer) { customerService.addCustomer(customer); }
    public Customer getCustomerById(int id) { return customerService.getCustomerById(id); }
    public List<Customer> getAllCustomers() { return customerService.getAllCustomers(); }
    public void updateCustomer(Customer customer) { customerService.updateCustomer(customer); }
    public void deleteCustomer(int id) { customerService.deleteCustomer(id); }

    // New interactive methods with table display
    public void addCustomer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(0, name, email, phone, address, new Timestamp(System.currentTimeMillis()));
        try {
            addCustomer(customer);
            System.out.println("Customer added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = getCustomerById(id);
        if (customer != null) {
            App.printTableHeader("Customer ID", "Name", "Email", "Phone", "Address");
            App.printTableRow(customer.getCustomerId(), customer.getName(), customer.getEmail(), customer.getPhone(), customer.getAddress());
            App.printTableFooter();
        } else {
            System.out.println("Customer not found!");
        }
    }

    public void viewAllCustomers() {
        List<Customer> customers = getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }
        App.printTableHeader("Customer ID", "Name", "Email", "Phone", "Address");
        for (Customer c : customers) {
            App.printTableRow(c.getCustomerId(), c.getName(), c.getEmail(), c.getPhone(), c.getAddress());
        }
        App.printTableFooter();
    }

    public void updateCustomer() {
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer existing = getCustomerById(id);
        if (existing == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();
        existing.setName(name);
        existing.setEmail(email);
        existing.setPhone(phone);
        existing.setAddress(address);
        updateCustomer(existing);
        System.out.println("Customer updated successfully!");
    }

    public void deleteCustomer() {
        System.out.print("Enter customer ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        deleteCustomer(id);
        System.out.println("Customer deleted successfully!");
    }
}