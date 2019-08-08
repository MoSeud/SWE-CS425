package com.practice.test.bootendtoend.service.serviceImpl;

import com.practice.test.bootendtoend.domain.Account;
import com.practice.test.bootendtoend.repository.AccountRepositry;
import com.practice.test.bootendtoend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepositry accountRepositry;

    @Autowired
    public AccountServiceImpl(AccountRepositry accountRepositry) {
        this.accountRepositry = accountRepositry;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepositry.findAll(Sort.by("accountNumber").ascending());
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepositry.save(account);
    }

    @Override
    public Account getAccountById(Long AccId) {
        return accountRepositry.findById(AccId).orElse(null);
    }

    @Override
    public void deleteAccountById(Long AccId) {
        accountRepositry.deleteById(AccId);

    }

    @Override
    public List<Account> searchAccount(String searchString, Long AccId) {
        return null;
    }
}
