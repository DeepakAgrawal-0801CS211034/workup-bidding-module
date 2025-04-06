package com.workup.biddingModule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workup.biddingModule.model.Bidded;

public interface BiddedRepository extends MongoRepository<Bidded, String> {
    List<Bidded> findByCustomerId(String customerId);
    List<Bidded> findByBidId(String bidId);
    Optional<Bidded> findTopByBidIdOrderByPriceDesc(String bidId);
    long countByBidId(String bidId);
}