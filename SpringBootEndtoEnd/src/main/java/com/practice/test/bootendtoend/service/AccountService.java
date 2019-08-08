package com.practice.test.bootendtoend.service;

import com.practice.test.bootendtoend.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public abstract List<Account> getAllAccounts();
    public abstract Account saveAccount(Account account);
    public abstract Account getAccountById(Long AccId);
    public abstract void deleteAccountById(Long AccId);
    public abstract List<Account> searchAccount(String searchString, Long AccId);
}
