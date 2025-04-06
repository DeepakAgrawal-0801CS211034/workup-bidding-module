package com.workup.biddingModule.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BidCreated")
@Getter
@Setter
public class BidCreated {
    @Id
    private String bidId;
    private String customerId;
    private String serviceProviderId;
    private LocalDateTime startBidTime;
    private LocalDateTime endBidTime;
    private LocalDateTime serviceTime;
    private String category;
    private String description;
    private double maxAmount;
    private String address;
    private String state;
    private String country;
    private String additionalNotes;
    private Map<String, ImageData> image;
    private String bidStatus;
    private String conformCustomerId;

    // Constructors, Getters and Setters
    public BidCreated() {
    }

}