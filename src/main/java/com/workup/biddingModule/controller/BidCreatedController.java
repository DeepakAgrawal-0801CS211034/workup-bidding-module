package com.workup.biddingModule.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workup.biddingModule.model.BidCreated;
import com.workup.biddingModule.model.ImageData;
import com.workup.biddingModule.service.BidCreatedService;

@RestController
@RequestMapping("/bids")
public class BidCreatedController {

    @Autowired
    private BidCreatedService bidCreatedService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BidCreated> createBid(@RequestBody Map<String, Object> bidRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        ObjectMapper mapper = new ObjectMapper();

        BidCreated bid = new BidCreated();

        // Set simple fields
        bid.setCustomerId((String) bidRequest.get("customerId"));
        bid.setServiceProviderId((String) bidRequest.get("serviceProviderId"));
        bid.setCategory((String) bidRequest.get("category"));
        bid.setDescription((String) bidRequest.get("description"));
        bid.setAddress((String) bidRequest.get("address"));
        bid.setState((String) bidRequest.get("state"));
        bid.setCountry((String) bidRequest.get("country"));
        bid.setAdditionalNotes((String) bidRequest.get("additionalNotes"));
        bid.setBidStatus((String) bidRequest.get("bidStatus"));
        bid.setConformCustomerId((String) bidRequest.get("conformCustomerId"));

        bid.setMaxAmount(Double.parseDouble(bidRequest.get("maxAmount").toString()));
        bid.setStartBidTime(LocalDateTime.parse((String) bidRequest.get("startBidTime"), formatter));
        bid.setEndBidTime(LocalDateTime.parse((String) bidRequest.get("endBidTime"), formatter));
        bid.setServiceTime(LocalDateTime.parse((String) bidRequest.get("serviceTime"), formatter));

        // Parse image map
        Map<String, Object> imageMapRaw = (Map<String, Object>) bidRequest.get("images");
        Map<String, ImageData> imageDataMap = new HashMap<>();

        if (imageMapRaw != null) {
            for (Map.Entry<String, Object> entry : imageMapRaw.entrySet()) {
                ImageData imageData = mapper.convertValue(entry.getValue(), ImageData.class);
                imageDataMap.put(entry.getKey(), imageData);
            }
        }

        bid.setImage(imageDataMap);

        BidCreated savedBid = bidCreatedService.createBid(bid, imageMapRaw); // or just pass `bid` if you don’t need raw
                                                                             // imageMap

        return ResponseEntity.ok(savedBid);
    }

    // 2. Get all bids
    @GetMapping
    public ResponseEntity<List<BidCreated>> getAllBids() {
        List<BidCreated> bids = bidCreatedService.getAllBids();
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }


    @GetMapping("/filter")
    public List<BidCreated> getFilteredBids(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city) {
        return bidCreatedService.getBidsByCountryStateCity(country, state, city);
    }

    
    // 3. Get bid by ID
    @GetMapping("/bid/{bidId}")
    public ResponseEntity<BidCreated> getBidById(@PathVariable String bidId) {
        Optional<BidCreated> bid = bidCreatedService.getBidById(bidId);
        return bid.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Get bids by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<BidCreated>> getBidsByCustomerId(@PathVariable String customerId) {
        List<BidCreated> bids = bidCreatedService.getBidsByCustomerId(customerId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    // 5. Delete bid by ID
    @DeleteMapping("/bid/{bidId}")
    public ResponseEntity<Void> deleteBidById(@PathVariable String bidId) {
        boolean deleted = bidCreatedService.deleteBidById(bidId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. Update bid
    @PutMapping("/update")
    public ResponseEntity<BidCreated> updateBid(@RequestBody BidCreated bid) {
        BidCreated updatedBid = bidCreatedService.updateBid(bid);
        if (updatedBid != null) {
            return ResponseEntity.ok(updatedBid);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}