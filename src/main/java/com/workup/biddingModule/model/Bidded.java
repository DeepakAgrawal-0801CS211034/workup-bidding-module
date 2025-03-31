package com.workup.biddingModule.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bidded")
public class Bidded {
    @Id
    private String id;
    private String bidId;          // Reference to the Bid being bidded on
    private String customerId;    // ID of the customer placing the bid
    private double price;         // The bid amount offered by the customer
    private String description;   // Optional description/notes from the customer
    private LocalDateTime bidTime; // When the bid was placed
    private String status;        // e.g., "ACTIVE", "WON", "LOST", "WITHDRAWN"

    // Constructors
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

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bidded{" +
                "id='" + id + '\'' +
                ", bidId='" + bidId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", bidTime=" + bidTime +
                ", status='" + status + '\'' +
                '}';
    }
}