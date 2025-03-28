package com.workup.biddingModule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workup.biddingModule.model.BidCreated;
import com.workup.biddingModule.service.BidCreatedService;

@RestController
@RequestMapping("/bids")
public class BidCreatedController {
    @Autowired
    private BidCreatedService bidCreatedService;

    // Add a new bid
    @PostMapping
    public BidCreated createBid(@RequestBody BidCreated bid) {
        return bidCreatedService.createBid(bid);
    }

    // Get all bids
    @GetMapping
    public List<BidCreated> getAllBids() {
        return bidCreatedService.getAllBids();
    }

    // Get bid by ID
    @GetMapping("/{id}")
    public Optional<BidCreated> getBidById(@PathVariable String id) {
        return bidCreatedService.getBidById(id);
    }

}
