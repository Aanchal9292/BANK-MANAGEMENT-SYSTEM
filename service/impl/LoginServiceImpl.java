package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.LoginDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.LoginDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.Login;
import com.jdbcconnectivity.bankmanagement.service.LoginService;
import java.util.List;

public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();

    @Override
    public void addLogin(Login login) {
        if (login.getLoginId() <= 0 || login.getRole() == null) {
            throw new IllegalArgumentException("Valid Login ID and Role are required");
        }
        loginDAO.addLogin(login);
    }

    @Override
    public Login getLoginById(int loginId) {
        return loginDAO.getLoginById(loginId);
    }

    @Override
    public List<Login> getAllLogins() {
        return loginDAO.getAllLogins();
    }

    @Override
    public void updateLogin(Login login) {
        loginDAO.updateLogin(login);
    }

    @Override
    public void deleteLogin(int loginId) {
        loginDAO.deleteLogin(loginId);
    }

    @Override
    public Login authenticate(int loginId, String password) {
        return loginDAO.authenticate(loginId, password);
    }
}