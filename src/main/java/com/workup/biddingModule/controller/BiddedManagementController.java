package com.workup.biddingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workup.biddingModule.model.Bidded;
import com.workup.biddingModule.service.BiddedService;

@RestController
@RequestMapping("/bids/management")
public class BiddedManagementController {

    @Autowired
    private BiddedService biddedService;

    // Get all bids in the system (with pagination)
    @GetMapping
    public ResponseEntity<List<Bidded>> getAllBids(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Bidded> bids = biddedService.getAllBids(); // In practice, implement pagination
        return ResponseEntity.ok(bids);
    }

    // Get all bids for a specific auction/bidId
    @GetMapping("/bid/{bidId}")
    public ResponseEntity<List<Bidded>> getBidsForAuction(@PathVariable String bidId) {
        List<Bidded> bids = biddedService.getBidsByBidId(bidId);
        return ResponseEntity.ok(bids);
    }

    // Get the current winning bid for an auction
    @GetMapping("/bid/{bidId}/winning")
    public ResponseEntity<Bidded> getWinningBid(@PathVariable String bidId) {
        return biddedService.getHighestBidForBidId(bidId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get bid count for an auction
    @GetMapping("/bid/{bidId}/count")
    public ResponseEntity<Long> getBidCount(@PathVariable String bidId) {
        long count = biddedService.getBidCountForBidId(bidId);
        return ResponseEntity.ok(count);
    }
}