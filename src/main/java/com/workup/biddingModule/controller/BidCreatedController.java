package com.workup.biddingModule.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BidCreated> createBid(@RequestBody Map<String, Object> bidRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        BidCreated bid = new BidCreated();
        bid.setStartBidTime(LocalDateTime.parse((String) bidRequest.get("startBidTime"), formatter));
        bid.setEndBidTime(LocalDateTime.parse((String) bidRequest.get("endBidTime"), formatter));
        bid.setServiceTime(LocalDateTime.parse((String) bidRequest.get("serviceTime"), formatter));
        bid.setCategory((String) bidRequest.get("category"));
        bid.setDescription((String) bidRequest.get("description"));
        bid.setMaxAmount(Double.parseDouble(bidRequest.get("maxAmount").toString()));
        bid.setAddress((String) bidRequest.get("address"));
        bid.setAdditionalNotes((String) bidRequest.get("additionalNotes"));

        // Handle images
        Map<String, Object> imageMap = (Map<String, Object>) bidRequest.get("image");

        BidCreated savedBid = bidCreatedService.createBid(bid, imageMap);
        return ResponseEntity.ok(savedBid);
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
