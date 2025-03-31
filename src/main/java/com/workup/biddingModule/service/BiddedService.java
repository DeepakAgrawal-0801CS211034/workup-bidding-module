package com.workup.biddingModule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workup.biddingModule.model.Bidded;
import com.workup.biddingModule.repository.BiddedRepository;

@Service
public class BiddedService {
    @Autowired
    private BiddedRepository biddedRepository;

    // Create a new bid
    public Bidded createBid(Bidded bid) {
        return biddedRepository.save(bid);
    }

    // Get all bids
    public List<Bidded> getAllBids() {
        return biddedRepository.findAll();
    }

    // Get bids by customerId
    public List<Bidded> getBidsByCustomerId(String customerId) {
        return biddedRepository.findByCustomerId(customerId);
    }

    // Get bids by bidId (original bid being bidded on)
    public List<Bidded> getBidsByBidId(String bidId) {
        return biddedRepository.findByBidId(bidId);
    }

    // Get a specific bid by its ID
    public Optional<Bidded> getBidById(String id) {
        return biddedRepository.findById(id);
    }

    // Update a bid
    public Bidded updateBid(Bidded bid) {
        if (biddedRepository.existsById(bid.getId())) {
            return biddedRepository.save(bid);
        }
        return null; // or throw an exception
    }

    // Delete a bid
    public void deleteBid(String id) {
        biddedRepository.deleteById(id);
    }

    // Get the highest bid for a particular bidId
    public Optional<Bidded> getHighestBidForBidId(String bidId) {
        return biddedRepository.findTopByBidIdOrderByPriceDesc(bidId);
    }

    // Get count of bids for a particular bidId
    public long getBidCountForBidId(String bidId) {
        return biddedRepository.countByBidId(bidId);
    }
}
