package com.jdbcconnectivity.bankmanagement.service;

import com.jdbcconnectivity.bankmanagement.model.Account;
import java.util.List;

public interface AccountService {
    void addAccount(Account account);
    Account getAccountByNo(String accountNo);
    List<Account> getAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(String accountNo);
}