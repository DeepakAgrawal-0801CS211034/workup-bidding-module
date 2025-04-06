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

// package com.workup.biddingModule.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.workup.biddingModule.model.Bidded;
// import com.workup.biddingModule.service.BiddedService;

// @RestController
// @RequestMapping("/bids/customer")
// public class BiddedController {

//     @Autowired
//     private BiddedService biddedService;

//     // Place a new bid
//     @PostMapping
//     public ResponseEntity<Bidded> placeBid(@RequestBody Bidded bid) {
//         Bidded createdBid = biddedService.createBid(bid);
//         return ResponseEntity.ok(createdBid);
//     }

//     // Get a specific bid by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Bidded> getBidById(@PathVariable String id) {
//         return biddedService.getBidById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     // Update a bid (only allowed before certain conditions)
//     @PutMapping("/{id}")
//     public ResponseEntity<Bidded> updateBid(@PathVariable String id, @RequestBody Bidded bid) {
//         bid.setId(id);
//         Bidded updatedBid = biddedService.updateBid(bid);
//         return updatedBid != null ? ResponseEntity.ok(updatedBid) : ResponseEntity.notFound().build();
//     }

//     // Withdraw a bid
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> withdrawBid(@PathVariable String id) {
//         biddedService.deleteBid(id);
//         return ResponseEntity.noContent().build();
//     }
// }