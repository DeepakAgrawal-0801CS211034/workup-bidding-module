package com.workup.biddingModule.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workup.biddingModule.model.BidCreated;
import com.workup.biddingModule.repository.BidCreatedRepository;

@Service
public class BidCreatedService {

    @Autowired
    private BidCreatedRepository bidCreatedRepository;

    public BidCreated createBid(BidCreated bid, Map<String, Object> imageMap) {
        // Handle image data if needed
        return bidCreatedRepository.save(bid);
    }

    public List<BidCreated> getAllBids() {
        return bidCreatedRepository.findAll();
    }

    public Optional<BidCreated> getBidById(String id) {
        return bidCreatedRepository.findById(id);
    }

    public List<BidCreated> getBidsByCustomerId(String customerId) {
        return bidCreatedRepository.findByCustomerId(customerId);
    }

    public boolean deleteBidById(String id) {
        if (bidCreatedRepository.existsById(id)) {
            bidCreatedRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public BidCreated updateBid(BidCreated bid) {
        if (bidCreatedRepository.existsById(bid.getBidId())) {
            return bidCreatedRepository.save(bid);
        }
        return null;
    }
}

// package com.workup.biddingModule.service;

// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.workup.biddingModule.model.BidCreated;
// import com.workup.biddingModule.repository.BidCreatedRepository;

// @Service
// public class BidCreatedService {
    
//     @Autowired
//     private BidCreatedRepository bidCreatedRepository;

//     // Save bid with images
//     public BidCreated createBid(BidCreated bid, Map<String, Object> imageMap) {
//         bid.setImage((Map<String, com.workup.biddingModule.model.ImageData>) (Object) imageMap); // Casting required
//         return bidCreatedRepository.save(bid);
//     }

//     // Get all bids
//     public List<BidCreated> getAllBids() {
//         return bidCreatedRepository.findAll();
//     }

//     // Get bid by ID
//     public java.util.Optional<BidCreated> getBidById(String id) {
//         return bidCreatedRepository.findById(id);
//     }
// }
