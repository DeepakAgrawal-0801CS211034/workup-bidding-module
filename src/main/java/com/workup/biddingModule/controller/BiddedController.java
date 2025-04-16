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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workup.biddingModule.model.Bidded;
import com.workup.biddingModule.service.BiddedService;

@RestController
@RequestMapping("/bidded")
public class BiddedController {

    @Autowired
    private BiddedService biddedService;

    // 1. Create a new bid
    @PostMapping
    public ResponseEntity<Bidded> createBid(@RequestBody Bidded bid) {
        Bidded createdBid = biddedService.createBid(bid);
        return ResponseEntity.ok(createdBid);
    }

    // 2. Get all bids
    @GetMapping
    public ResponseEntity<List<Bidded>> getAllBids() {
        List<Bidded> bids = biddedService.getAllBids();
        return ResponseEntity.ok(bids);
    }

    // 5. Get all bids by customerId
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Bidded>> getBidsByCustomerId(@PathVariable String customerId) {
        List<Bidded> bids = biddedService.getBidsByCustomerId(customerId);
        if (bids.isEmpty()) {
            return ResponseEntity.noContent().build();  // No bids for this customer
        }
        return ResponseEntity.ok(bids);
    }

    // 3. Get a specific bid by ID
    @GetMapping("/{biddedId}")
    public ResponseEntity<Bidded> getBidById(@PathVariable String biddedId) {
        return biddedService.getBidById(biddedId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Confirm a bid
    @PostMapping("/confirm")
    public ResponseEntity<Bidded> confirmBid(@RequestParam String biddedId) {
        return biddedService.confirmBid(biddedId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Additional endpoints from original implementation
    @PutMapping("/{id}")
    public ResponseEntity<Bidded> updateBid(@PathVariable String id, @RequestBody Bidded bid) {
        bid.setId(id);
        Bidded updatedBid = biddedService.updateBid(bid);
        return updatedBid != null ? ResponseEntity.ok(updatedBid) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> withdrawBid(@PathVariable String id) {
        biddedService.deleteBid(id);
        return ResponseEntity.noContent().build();
    }
}
