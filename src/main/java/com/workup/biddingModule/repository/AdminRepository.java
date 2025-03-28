package com.workup.biddingModule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workup.biddingModule.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
    Admin findByEmail(String email);
}
