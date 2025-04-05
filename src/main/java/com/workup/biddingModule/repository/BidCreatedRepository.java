package com.workup.biddingModule.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workup.biddingModule.model.BidCreated;

public interface BidCreatedRepository extends MongoRepository<BidCreated, String> {
    List<BidCreated> findByCustomerId(String customerId);
}

// package com.workup.biddingModule.repository;

// import org.springframework.data.mongodb.repository.MongoRepository;

// import com.workup.biddingModule.model.BidCreated;

// public interface BidCreatedRepository extends MongoRepository<BidCreated, String>{

     
// }
