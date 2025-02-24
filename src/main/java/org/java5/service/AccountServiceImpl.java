package org.java5.service;

import org.java5.dao.AccountDAO;
import org.java5.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDAO dao;

    @Override
    public Account findById(String username) {
        Optional<Account> account = dao.findById(username);
        return account.orElse(null);
    }
}
