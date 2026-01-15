package com.jdbcconnectivity.bankmanagement.dao;

import com.jdbcconnectivity.bankmanagement.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int empId);
}
