package com.jdbcconnectivity.bankmanagement.service.impl;

import com.jdbcconnectivity.bankmanagement.dao.AccountDAO;
import com.jdbcconnectivity.bankmanagement.dao.impl.AccountDAOImpl;
import com.jdbcconnectivity.bankmanagement.model.Account;
import com.jdbcconnectivity.bankmanagement.service.AccountService;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public void addAccount(Account account) {
        if (account.getAccountNo() == null || account.getCustomerId() <= 0) {
            throw new IllegalArgumentException("Account number and valid Customer ID are required");
        }
        accountDAO.addAccount(account);
    }

    @Override
    public Account getAccountByNo(String accountNo) {
        return accountDAO.getAccountByNo(accountNo);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    @Override
    public void deleteAccount(String accountNo) {
        accountDAO.deleteAccount(accountNo);
    }
}