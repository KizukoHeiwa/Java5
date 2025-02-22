package org.java5.service;

import org.java5.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountService extends JpaRepository<Account, String> {
    public Account findById(String username);
}
