package com.workup.biddingModule.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // 1. Create Bid
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BidCreated> createBid(@RequestBody Map<String, Object> bidRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        BidCreated bid = new BidCreated();
        bid.setCustomerId((String) bidRequest.get("customerId"));
        bid.setStartBidTime(LocalDateTime.parse((String) bidRequest.get("startBidTime"), formatter));
        bid.setEndBidTime(LocalDateTime.parse((String) bidRequest.get("endBidTime"), formatter));
        bid.setServiceTime(LocalDateTime.parse((String) bidRequest.get("serviceTime"), formatter));
        bid.setCategory((String) bidRequest.get("category"));
        bid.setDescription((String) bidRequest.get("description"));
        bid.setMaxAmount(Double.parseDouble(bidRequest.get("maxAmount").toString()));
        bid.setAddress((String) bidRequest.get("address"));
        bid.setState((String) bidRequest.get("state"));
        bid.setCountry((String) bidRequest.get("country"));
        bid.setAdditionalNotes((String) bidRequest.get("additionalNotes"));
        bid.setBidStatus((String) bidRequest.get("bidStatus"));
        bid.setConformCustomerId((String) bidRequest.get("conformCustomerId"));

        // Handle images
        Map<String, Object> imageMap = (Map<String, Object>) bidRequest.get("image");

        BidCreated savedBid = bidCreatedService.createBid(bid, imageMap);
        return ResponseEntity.ok(savedBid);
    }

    // 2. Get all bids
    @GetMapping
    public List<BidCreated> getAllBids() {
        return bidCreatedService.getAllBids();
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
    public List<BidCreated> getBidsByCustomerId(@PathVariable String customerId) {
        return bidCreatedService.getBidsByCustomerId(customerId);
    }

    // 5. Delete bid by ID
    @DeleteMapping("/bid/{bidId}")
    public ResponseEntity<Void> deleteBidById(@PathVariable String bidId) {
        if (bidCreatedService.deleteBidById(bidId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // 6. Update bid
    @PutMapping("/update")
    public ResponseEntity<BidCreated> updateBid(@RequestBody BidCreated bid) {
        BidCreated updatedBid = bidCreatedService.updateBid(bid);
        if (updatedBid != null) {
            return ResponseEntity.ok(updatedBid);
        }
        return ResponseEntity.notFound().build();
    }
}


// package com.workup.biddingModule.controller;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.workup.biddingModule.model.BidCreated;
// import com.workup.biddingModule.service.BidCreatedService;

// @RestController
// @RequestMapping("/bids")
// public class BidCreatedController {
    
//     @Autowired
//     private BidCreatedService bidCreatedService;

//     @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<BidCreated> createBid(@RequestBody Map<String, Object> bidRequest) {
//         DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

//         BidCreated bid = new BidCreated();
//         bid.setStartBidTime(LocalDateTime.parse((String) bidRequest.get("startBidTime"), formatter));
//         bid.setEndBidTime(LocalDateTime.parse((String) bidRequest.get("endBidTime"), formatter));
//         bid.setServiceTime(LocalDateTime.parse((String) bidRequest.get("serviceTime"), formatter));
//         bid.setCategory((String) bidRequest.get("category"));
//         bid.setDescription((String) bidRequest.get("description"));
//         bid.setMaxAmount(Double.parseDouble(bidRequest.get("maxAmount").toString()));
//         bid.setAddress((String) bidRequest.get("address"));
//         bid.setAdditionalNotes((String) bidRequest.get("additionalNotes"));

//         // Handle images
//         Map<String, Object> imageMap = (Map<String, Object>) bidRequest.get("image");

//         BidCreated savedBid = bidCreatedService.createBid(bid, imageMap);
//         return ResponseEntity.ok(savedBid);
//     }

//     // Get all bids
//     @GetMapping
//     public List<BidCreated> getAllBids() {
//         return bidCreatedService.getAllBids();
//     }

//     // Get bid by ID
//     @GetMapping("/{id}")
//     public Optional<BidCreated> getBidById(@PathVariable String id) {
//         return bidCreatedService.getBidById(id);
//     }

// }
