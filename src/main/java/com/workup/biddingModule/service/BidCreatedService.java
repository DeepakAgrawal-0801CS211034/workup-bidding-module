package com.workup.biddingModule.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.workup.biddingModule.model.BidCreated;
import com.workup.biddingModule.model.ImageData;
import com.workup.biddingModule.repository.BidCreatedRepository;

@Service
public class BidCreatedService {

    @Autowired
    private BidCreatedRepository bidCreatedRepository;

    public BidCreated createBid(BidCreated bid, Map<String, Object> imageMap) {
        if (imageMap != null) {
            Map<String, ImageData> imageDataMap = new HashMap<>();

            // Convert each entry in the imageMap to ImageData objects
            for (Map.Entry<String, Object> entry : imageMap.entrySet()) {
                Map<String, Object> imgDetails = (Map<String, Object>) entry.getValue();
                ImageData imageData = new ImageData();
                imageData.setImageName((String) imgDetails.get("imageName"));
                imageData.setImageType((String) imgDetails.get("imageType"));
                imageData.setImageData((String) imgDetails.get("imageData"));

                imageDataMap.put(entry.getKey(), imageData);
            }
            bid.setImage(imageDataMap);
        }
        return bidCreatedRepository.save(bid);
    }


    @Autowired
    private MongoTemplate mongoTemplate;

    public List<BidCreated> getBidsByCountryStateCity(String country, String state, String city) {
        List<AggregationOperation> operations = new ArrayList<>();

        if (country != null) {
            operations.add(Aggregation.match(Criteria.where("country").is(country)));
        }

        if (state != null) {
            operations.add(Aggregation.match(Criteria.where("state").is(state)));
        }

        if (city != null) {
            operations.add(Aggregation.match(Criteria.where("city").is(city)));
        }

        Aggregation aggregation = Aggregation.newAggregation(operations);

        // Aggregation aggregation = Aggregation.newAggregation(
        //     Aggregation.match(Criteria.where("country").is(country)),
        //     Aggregation.match(Criteria.where("state").is(state)),
        //     Aggregation.match(Criteria.where("city").is(city))
        // );
        AggregationResults<BidCreated> results = mongoTemplate.aggregate(
                aggregation, "BidCreated", BidCreated.class
        );

        return results.getMappedResults();
    }

    public List<BidCreated> getAllBids() {
        return bidCreatedRepository.findAll();
    }

    public Optional<BidCreated> getBidById(String bidId) {
        return bidCreatedRepository.findById(bidId);
    }

    public List<BidCreated> getBidsByCustomerId(String customerId) {
        return bidCreatedRepository.findByCustomerId(customerId);
    }

    public boolean deleteBidById(String bidId) {
        if (bidCreatedRepository.existsById(bidId)) {
            bidCreatedRepository.deleteById(bidId);
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