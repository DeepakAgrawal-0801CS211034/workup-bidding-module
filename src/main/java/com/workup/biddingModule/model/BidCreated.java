package com.workup.biddingModule.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BidCreated")
public class BidCreated {
    
    @Id
    private String id;
    private LocalDateTime startBidTime;
    private LocalDateTime endBidTime;
    private LocalDateTime serviceTime;
    private String category;
    private String description;
    private double maxAmount;
    private String address;
    private String additionalNotes;

    // Constructors
    public BidCreated() {}

    public BidCreated(LocalDateTime startBidTime, LocalDateTime endBidTime, LocalDateTime serviceTime,
                      String category, String description, double maxAmount, String address, String additionalNotes) {
        this.startBidTime = startBidTime;
        this.endBidTime = endBidTime;
        this.serviceTime = serviceTime;
        this.category = category;
        this.description = description;
        this.maxAmount = maxAmount;
        this.address = address;
        this.additionalNotes = additionalNotes;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getStartBidTime() { return startBidTime; }
    public void setStartBidTime(LocalDateTime startBidTime) { this.startBidTime = startBidTime; }

    public LocalDateTime getEndBidTime() { return endBidTime; }
    public void setEndBidTime(LocalDateTime endBidTime) { this.endBidTime = endBidTime; }

    public LocalDateTime getServiceTime() { return serviceTime; }
    public void setServiceTime(LocalDateTime serviceTime) { this.serviceTime = serviceTime; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getMaxAmount() { return maxAmount; }
    public void setMaxAmount(double maxAmount) { this.maxAmount = maxAmount; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
}
