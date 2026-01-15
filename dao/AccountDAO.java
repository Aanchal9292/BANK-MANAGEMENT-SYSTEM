package com.jdbcconnectivity.bankmanagement.dao;

import com.jdbcconnectivity.bankmanagement.model.Account;
import java.util.List;

public interface AccountDAO {
    void addAccount(Account account);
    Account getAccountByNo(String accountNo);
    List<Account> getAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(String accountNo);
}