package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.EmployeeDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.EmployeeDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.Employee;
import com.jdbcconnectivity.bankmanagement.service.EmployeeService;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void addEmployee(Employee employee) {
        if (employee.getName() == null || employee.getDesignation() == null) {
            throw new IllegalArgumentException("Name and Designation are required");
        }
        employeeDAO.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeDAO.getEmployeeById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeDAO.deleteEmployee(empId);
    }
}
