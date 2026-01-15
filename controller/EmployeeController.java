package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;
import com.jdbcconnectivity.bankmanagement.model.Employee;
import com.jdbcconnectivity.bankmanagement.service.EmployeeService;
import com.jdbcconnectivity.bankmanagement.service.impl.EmployeeServiceImpl;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addEmployee(Employee employee) { employeeService.addEmployee(employee); }
    public Employee getEmployeeById(int empId) { return employeeService.getEmployeeById(empId); }
    public List<Employee> getAllEmployees() { return employeeService.getAllEmployees(); }
    public void updateEmployee(Employee employee) { employeeService.updateEmployee(employee); }
    public void deleteEmployee(int empId) { employeeService.deleteEmployee(empId); }

    // New interactive methods with table display
    public void addEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee employee = new Employee(0, name, designation, salary, new Timestamp(System.currentTimeMillis()));
        try {
            addEmployee(employee);
            System.out.println("Employee added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewEmployee() {
        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        Employee employee = getEmployeeById(empId);
        if (employee != null) {
            App.printTableHeader("Emp ID", "Name", "Designation", "Salary", "Join Date");
            App.printTableRow(employee.getEmpId(), employee.getName(), employee.getDesignation(), employee.getSalary(), employee.getJoinDate());
            App.printTableFooter();
        } else {
            System.out.println("Employee not found!");
        }
    }

    public void viewAllEmployees() {
        List<Employee> employees = getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        App.printTableHeader("Emp ID", "Name", "Designation", "Salary", "Join Date");
        for (Employee e : employees) {
            App.printTableRow(e.getEmpId(), e.getName(), e.getDesignation(), e.getSalary(), e.getJoinDate());
        }
        App.printTableFooter();
    }

    public void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        Employee existing = getEmployeeById(empId);
        if (existing == null) {
            System.out.println("Employee not found!");
            return;
        }
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        existing.setName(name);
        existing.setDesignation(designation);
        existing.setSalary(salary);
        updateEmployee(existing);
        System.out.println("Employee updated successfully!");
    }

    public void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        deleteEmployee(empId);
        System.out.println("Employee deleted successfully!");
    }
}