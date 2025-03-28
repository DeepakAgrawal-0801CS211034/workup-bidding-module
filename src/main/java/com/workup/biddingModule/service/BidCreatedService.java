package com.workup.biddingModule.service;

import java.util.HashMap;
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

    @Autowired
    private ImageService imageService;

    // Save a new bid
    public BidCreated createBid(BidCreated bid, Map<String, Map<String, String>> imageMap) {
        // return bidCreatedRepository.save(bid);
        if (imageMap != null && !imageMap.isEmpty()) {
            Map<String, String> storedImageIds = new HashMap<>();

            for (Map.Entry<String, Map<String, String>> entry : imageMap.entrySet()) {
                String key = entry.getKey();
                Map<String, String> imageDetails = entry.getValue();
                String imageName = imageDetails.get("imageName");
                String imageData = imageDetails.get("imageData");

                String imageId = imageService.uploadImage(imageData, imageName);
                storedImageIds.put(key, imageId);
            }
            bid.setImageIds(storedImageIds);
        }
        return bidCreatedRepository.save(bid);
    }

    // Get all bids
    public List<BidCreated> getAllBids() {
        return bidCreatedRepository.findAll();
    }

    // Get a bid by ID
    public Optional<BidCreated> getBidById(String id) {
        return bidCreatedRepository.findById(id);
    }
}
