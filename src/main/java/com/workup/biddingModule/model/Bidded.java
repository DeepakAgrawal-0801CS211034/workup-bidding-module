package com.workup.biddingModule.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Bidded")
@Getter
@Setter
public class Bidded {
    @Id
    private String id;
    private String bidId;          // Reference to the Bid being bidded on
    private String customerId;    // ID of the customer placing the bid
    private double price;         // The bid amount offered by the customer
    private String description;   // Optional description/notes from the customer
    private LocalDateTime bidTime; // When the bid was placed
    private String status;        // e.g., "ACTIVE", "WON", "LOST", "WITHDRAWN", "CONFIRMED"

    public Bidded() {
        this.bidTime = LocalDateTime.now();
        this.status = "ACTIVE";
    }

    public Bidded(String bidId, String customerId, double price, String description) {
        this();
        this.bidId = bidId;
        this.customerId = customerId;
        this.price = price;
        this.description = description;
    }
}