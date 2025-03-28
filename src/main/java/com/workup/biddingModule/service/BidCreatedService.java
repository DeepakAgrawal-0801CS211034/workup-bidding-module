package com.workup.biddingModule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workup.biddingModule.model.BidCreated;
import com.workup.biddingModule.repository.BidCreatedRepository;

@Service
public class BidCreatedService {
    
    @Autowired
    private BidCreatedRepository bidCreatedRepository;

    // Save a new bid
    public BidCreated createBid(BidCreated bid) {
        return bidCreatedRepository.save(bid);
    }

    // Get all bids
    public List<BidCreated> getAllBids() {
        return bidCreatedRepository.findAll();
    }

    // Get a bid by ID
    public Optional<BidCreated> getBidById(String id) {
        return bidCreatedRepository.findById(id);
    }
}
