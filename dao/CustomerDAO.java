package com.jdbcconnectivity.bankmanagement.dao;

import com.jdbcconnectivity.bankmanagement.model.Customer;
import java.util.List;

public interface CustomerDAO 
{
    void addCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}