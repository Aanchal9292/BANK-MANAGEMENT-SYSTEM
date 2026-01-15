package com.jdbcconnectivity.bankmanagement.controller;
import com.jdbcconnectivity.bankmanagement.*;
import com.jdbcconnectivity.bankmanagement.model.Login;
import com.jdbcconnectivity.bankmanagement.service.LoginService;
import com.jdbcconnectivity.bankmanagement.service.impl.LoginServiceImpl;
import java.util.List;
import java.util.Scanner;

public class LoginController {
    private LoginService loginService = new LoginServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    // Original CRUD methods (unchanged)
    public void addLogin(Login login) { loginService.addLogin(login); }
    public Login getLoginById(int loginId) { return loginService.getLoginById(loginId); }
    public List<Login> getAllLogins() { return loginService.getAllLogins(); }
    public void updateLogin(Login login) { loginService.updateLogin(login); }
    public void deleteLogin(int loginId) { loginService.deleteLogin(loginId); }
    public Login authenticate(int loginId, String password) { return loginService.authenticate(loginId, password); }

    // New interactive methods with table display
    public void addLogin() {
        System.out.print("Enter login ID (employee ID): ");
        int loginId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter role (e.g., admin, employee): ");
        String role = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Login login = new Login(loginId, role, password);
        try {
            addLogin(login);
            System.out.println("Login added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewLogin() {
        System.out.print("Enter login ID: ");
        int loginId = scanner.nextInt();
        scanner.nextLine();
        Login login = getLoginById(loginId);
        if (login != null) {
            App.printTableHeader("Login ID", "Role", "Password");
            App.printTableRow(login.getLoginId(), login.getRole(), login.getPassword());  // Note: Password shown for demo; hide in production
            App.printTableFooter();
        } else {
            System.out.println("Login not found!");
        }
    }

    public void viewAllLogins() {
        List<Login> logins = getAllLogins();
        if (logins.isEmpty()) {
            System.out.println("No logins found!");
            return;
        }
        App.printTableHeader("Login ID", "Role", "Password");
        for (Login l : logins) {
            App.printTableRow(l.getLoginId(), l.getRole(), l.getPassword());  // Note: Password shown for demo; hide in production
        }
        App.printTableFooter();
    }

    public void updateLogin() {
        System.out.print("Enter login ID to update: ");
        int loginId = scanner.nextInt();
        scanner.nextLine();
        Login existing = getLoginById(loginId);
        if (existing == null) {
            System.out.println("Login not found!");
            return;
        }
        System.out.print("Enter new role: ");
        String role = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        existing.setRole(role);
        existing.setPassword(password);
        updateLogin(existing);
        System.out.println("Login updated successfully!");
    }

    public void deleteLogin() {
        System.out.print("Enter login ID to delete: ");
        int loginId = scanner.nextInt();
        scanner.nextLine();
        deleteLogin(loginId);
        System.out.println("Login deleted successfully!");
    }
}