package com.workup.biddingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workup.biddingModule.model.Bidded;
import com.workup.biddingModule.service.BiddedService;

@RestController
@RequestMapping("/bids/customer")
public class BiddedController {

    @Autowired
    private BiddedService biddedService;

    // Place a new bid
    @PostMapping
    public ResponseEntity<Bidded> placeBid(@RequestBody Bidded bid) {
        Bidded createdBid = biddedService.createBid(bid);
        return ResponseEntity.ok(createdBid);
    }

    // Get all bids by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Bidded>> getBidsByCustomer(@PathVariable String customerId) {
        List<Bidded> bids = biddedService.getBidsByCustomerId(customerId);
        return ResponseEntity.ok(bids);
    }

    // Get a specific bid by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bidded> getBidById(@PathVariable String id) {
        return biddedService.getBidById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a bid (only allowed before certain conditions)
    @PutMapping("/{id}")
    public ResponseEntity<Bidded> updateBid(@PathVariable String id, @RequestBody Bidded bid) {
        bid.setId(id);
        Bidded updatedBid = biddedService.updateBid(bid);
        return updatedBid != null ? ResponseEntity.ok(updatedBid) : ResponseEntity.notFound().build();
    }

    // Withdraw a bid
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> withdrawBid(@PathVariable String id) {
        biddedService.deleteBid(id);
        return ResponseEntity.noContent().build();
    }
}