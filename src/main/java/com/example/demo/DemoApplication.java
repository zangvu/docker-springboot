package com.example.demo;

import com.example.demo.domain.Account;
import com.example.demo.domain.Role;
import com.example.demo.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AccountService accountService) {
        return args -> {
            accountService.saveRole(new Role(null, "ROLE_USER"));
            accountService.saveRole(new Role(null, "ROLE_MANAGER"));
            accountService.saveRole(new Role(null, "ROLE_ADMIN"));
            accountService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            accountService.saveAccount(new Account(null, "giang", "123132", "Giang", new ArrayList<>()));
            accountService.saveAccount(new Account(null, "thong", "123132", "Thong", new ArrayList<>()));
            accountService.saveAccount(new Account(null, "phuong", "123132", "Phuong", new ArrayList<>()));
            accountService.saveAccount(new Account(null, "trinh", "123132", "Trinh", new ArrayList<>()));

            accountService.addRoleToAccount("giang", "ROLE_USER");
            accountService.addRoleToAccount("giang", "ROLE_SUPER_ADMIN");
            accountService.addRoleToAccount("thong", "ROLE_ADMIN");
            accountService.addRoleToAccount("phuong", "ROLE_MANAGER");
            accountService.addRoleToAccount("trinh", "ROLE_USER");
        };
    }

}