package com.jdbcconnectivity.bankmanagement.service;

import com.jdbcconnectivity.bankmanagement.model.Login;
import java.util.List;

public interface LoginService {
    void addLogin(Login login);
    Login getLoginById(int loginId);
    List<Login> getAllLogins();
    void updateLogin(Login login);
    void deleteLogin(int loginId);
    Login authenticate(int loginId, String password);  // For authentication
}

