package com.workup.biddingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.workup.biddingModule.model.Admin;
import com.workup.biddingModule.service.AdminService;

public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    // Create
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }
    
    // Read
    @GetMapping()
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String id) {
        return adminService.getAdminById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Update
    // @PutMapping("/{id}")
    // public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin adminDetails) {
    //     try {
    //         Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
    //         return ResponseEntity.ok(updatedAdmin);
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    
    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        try {
            adminService.deleteAdmin(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Additional endpoints
    @GetMapping("/username/{username}")
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username) {
        Admin admin = adminService.findByUsername(username);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        Admin admin = adminService.findByEmail(email);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
