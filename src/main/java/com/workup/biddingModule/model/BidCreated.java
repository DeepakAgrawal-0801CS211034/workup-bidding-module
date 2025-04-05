package com.workup.biddingModule.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BidCreated")
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

    // Default constructor
    public BidCreated() {
        this.image = new HashMap<>();
    }

    // Full constructor
    public BidCreated(String bidId, String customerId, String serviceProviderId, LocalDateTime startBidTime,
                     LocalDateTime endBidTime, LocalDateTime serviceTime, String category, String description,
                     double maxAmount, String address, String state, String country, String additionalNotes,
                     Map<String, ImageData> image, String bidStatus, String conformCustomerId) {
        this.bidId = bidId;
        this.customerId = customerId;
        this.serviceProviderId = serviceProviderId;
        this.startBidTime = startBidTime;
        this.endBidTime = endBidTime;
        this.serviceTime = serviceTime;
        this.category = category;
        this.description = description;
        this.maxAmount = maxAmount;
        this.address = address;
        this.state = state;
        this.country = country;
        this.additionalNotes = additionalNotes;
        this.image = image != null ? image : new HashMap<>();
        this.bidStatus = bidStatus;
        this.conformCustomerId = conformCustomerId;
    }

    // Getters and Setters
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

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public LocalDateTime getStartBidTime() {
        return startBidTime;
    }

    public void setStartBidTime(LocalDateTime startBidTime) {
        this.startBidTime = startBidTime;
    }

    public LocalDateTime getEndBidTime() {
        return endBidTime;
    }

    public void setEndBidTime(LocalDateTime endBidTime) {
        this.endBidTime = endBidTime;
    }

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public Map<String, ImageData> getImage() {
        return image;
    }

    public void setImage(Map<String, ImageData> image) {
        this.image = image != null ? image : new HashMap<>();
    }

    public String getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(String bidStatus) {
        this.bidStatus = bidStatus;
    }

    public String getConformCustomerId() {
        return conformCustomerId;
    }

    public void setConformCustomerId(String conformCustomerId) {
        this.conformCustomerId = conformCustomerId;
    }

    // toString method for debugging/logging
    @Override
    public String toString() {
        return "BidCreated{" +
                "bidId='" + bidId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", serviceProviderId='" + serviceProviderId + '\'' +
                ", startBidTime=" + startBidTime +
                ", endBidTime=" + endBidTime +
                ", serviceTime=" + serviceTime +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", maxAmount=" + maxAmount +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", image=" + image +
                ", bidStatus='" + bidStatus + '\'' +
                ", conformCustomerId='" + conformCustomerId + '\'' +
                '}';
    }
}

// package com.workup.biddingModule.model;

// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;

// @Document(collection = "BidCreated")
// public class BidCreated {
//     @Id
//     private String bidId;
//     private String serviceProviderid;
//     private LocalDateTime startBidTime;
//     private LocalDateTime endBidTime;
//     private LocalDateTime serviceTime;
//     private String category;
//     private String description;
//     private double maxAmount;
//     private String address;
//     private String additionalNotes;
//     private Map<String, ImageData> image;
//     private String status;

//     // Constructors
//     public BidCreated() {}

//     public BidCreated(String serviceProviderid, LocalDateTime startBidTime, LocalDateTime endBidTime, LocalDateTime serviceTime,
//                       String category, String description, double maxAmount, String address, String additionalNotes, Map<String, ImageData> image) {
//         this.serviceProviderid = serviceProviderid;
//                         this.startBidTime = startBidTime;
//         this.endBidTime = endBidTime;
//         this.serviceTime = serviceTime;
//         this.category = category;
//         this.description = description;
//         this.maxAmount = maxAmount;
//         this.address = address;
//         this.additionalNotes = additionalNotes;

//         this.image = image != null ? image : new HashMap<>();
//     }

//     // Getters and Setters
//     public String getId() { return bidId; }
//     public void setId(String id) { this.bidId = bidId; }

//     public String getServiceProviderId() { return serviceProviderid; }
//     public void setServiceProviderId(String id) { this.serviceProviderid = serviceProviderid; }

//     public LocalDateTime getStartBidTime() { return startBidTime; }
//     public void setStartBidTime(LocalDateTime startBidTime) { this.startBidTime = startBidTime; }

//     public LocalDateTime getEndBidTime() { return endBidTime; }
//     public void setEndBidTime(LocalDateTime endBidTime) { this.endBidTime = endBidTime; }

//     public LocalDateTime getServiceTime() { return serviceTime; }
//     public void setServiceTime(LocalDateTime serviceTime) { this.serviceTime = serviceTime; }

//     public String getCategory() { return category; }
//     public void setCategory(String category) { this.category = category; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public double getMaxAmount() { return maxAmount; }
//     public void setMaxAmount(double maxAmount) { this.maxAmount = maxAmount; }

//     public String getAddress() { return address; }
//     public void setAddress(String address) { this.address = address; }

//     public String getAdditionalNotes() { return additionalNotes; }
//     public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }

//     public Map<String, ImageData> getImage() { return image; }
//     public void setImage(Map<String, ImageData> image) { this.image = image; }

// }
