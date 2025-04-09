package com.workup.biddingModule.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.workup.biddingModule.model.Admin;
import com.workup.biddingModule.repository.AdminRepository;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner adminDataInitializer(AdminRepository adminRepository) {
        return args -> {
            // Only add if no admin exists
            if (adminRepository.findByUserName("admin") == null) {
                Admin admin = new Admin();
                admin.setUserName("admin");
                admin.setPassword("admin123");
                admin.setEmail("admin@example.com");
                admin.setRole("ADMIN");
                adminRepository.save(admin);
            }
        };
    }
}