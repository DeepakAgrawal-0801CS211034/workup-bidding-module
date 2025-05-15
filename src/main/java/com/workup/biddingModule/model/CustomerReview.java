package com.workup.biddingModule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "CustomerReview")
@Getter
@Setter
public class CustomerReview {
    @Id
    private String id;
    private String orderId;
    private String spId;
    private String cId;
    private int stars;
    private String description;    
}