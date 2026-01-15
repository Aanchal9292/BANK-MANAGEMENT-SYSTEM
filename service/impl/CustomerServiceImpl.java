package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.CustomerDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.CustomerDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.Customer;
import com.jdbcconnectivity.bankmanagement.service.CustomerService;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void addCustomer(Customer customer) {
        if (customer.getName() == null || customer.getEmail() == null) {
            throw new IllegalArgumentException("Name and Email are required");
        }
        customerDAO.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}