package com.workup.biddingModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workup.biddingModule.model.Admin;
import com.workup.biddingModule.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin authenticateAdmin(String userName, String password) {
        Admin admin = adminRepository.findByUserName(userName);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}