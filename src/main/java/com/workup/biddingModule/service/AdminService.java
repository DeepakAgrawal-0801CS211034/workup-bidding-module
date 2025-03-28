package com.workup.biddingModule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.workup.biddingModule.model.Admin;
import com.workup.biddingModule.repository.AdminRepository;

public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    // Create
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    
    // Read
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    
    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id);
    }
    
    // Update
    // public Admin updateAdmin(String id, Admin adminDetails) {
    //     Admin admin = adminRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        
    //     admin.setUsername(adminDetails.getUsername());
    //     admin.setEmail(adminDetails.getEmail());
    //     admin.setPassword(adminDetails.getPassword());
    //     admin.setRole(adminDetails.getRole());
        
    //     return adminRepository.save(admin);
    // }
    
    // Delete
    public void deleteAdmin(String id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        
        adminRepository.delete(admin);
    }
    
    // Additional methods
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
    
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
