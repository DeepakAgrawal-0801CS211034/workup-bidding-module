package com.workup.biddingModule.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workup.biddingModule.model.BidCreated;
import com.workup.biddingModule.repository.BidCreatedRepository;

@Service
public class BidCreatedService {
    
    @Autowired
    private BidCreatedRepository bidCreatedRepository;

    // Save bid with images
    public BidCreated createBid(BidCreated bid, Map<String, Object> imageMap) {
        bid.setImage((Map<String, com.workup.biddingModule.model.ImageData>) (Object) imageMap); // Casting required
        return bidCreatedRepository.save(bid);
    }

    // Get all bids
    public List<BidCreated> getAllBids() {
        return bidCreatedRepository.findAll();
    }

    // Get bid by ID
    public java.util.Optional<BidCreated> getBidById(String id) {
        return bidCreatedRepository.findById(id);
    }
}
