package com.workup.biddingModule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

import com.workup.biddingModule.model.ServiceProvider;

public interface ServiceProviderRepository extends MongoRepository<ServiceProvider, String> {
    Optional<ServiceProvider> findByEmail(String email);
}
