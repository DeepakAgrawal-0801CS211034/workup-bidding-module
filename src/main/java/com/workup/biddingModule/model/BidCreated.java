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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEndBidTime() {
        return endBidTime;
    }

    public void setEndBidTime(LocalDateTime endBidTime) {
        this.endBidTime = endBidTime;
    }

    public LocalDateTime getStartBidTime() {
        return startBidTime;
    }

    public void setStartBidTime(LocalDateTime startBidTime) {
        this.startBidTime = startBidTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Map<String, ImageData> getImage() {
        return image;
    }

    public void setImage(Map<String, ImageData> image) {
        this.image = image;
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

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}