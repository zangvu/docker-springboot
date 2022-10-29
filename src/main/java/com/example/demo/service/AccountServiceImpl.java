package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Role;
import com.example.demo.repo.AccountRepo;
import com.example.demo.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;

    @Override
    public Account saveAccount(Account account) {
        log.info("Saving new user {} to the database", account.getName());
        return accountRepo.save(account);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToAccount(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        Account account = accountRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        account.getRoles().add(role);
    }

    @Override
    public Account getAccount(String username) {
        log.info("Fetching user {}", username);
        return accountRepo.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        log.info("Fetching all users");
        return accountRepo.findAll();
    }
}
