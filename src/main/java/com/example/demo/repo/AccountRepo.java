package com.example.demo.repo;

import com.example.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
