package com.workup.biddingModule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workup.biddingModule.model.BidCreated;

public interface BidCreatedRepository extends MongoRepository<BidCreated, String>{

     
}
