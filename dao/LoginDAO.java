package com.jdbcconnectivity.bankmanagement.dao;

import com.jdbcconnectivity.bankmanagement.model.Login;
import java.util.List;

public interface LoginDAO {
    void addLogin(Login login);
    Login getLoginById(int loginId);
    List<Login> getAllLogins();
    void updateLogin(Login login);
    void deleteLogin(int loginId);
    Login authenticate(int loginId, String password);  // For authentication
}