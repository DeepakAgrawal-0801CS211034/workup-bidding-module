package com.workup.biddingModule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "service_providers")
@Getter
@Setter
public class ServiceProvider {

    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String dateOfBirth;
    private String imgURL;
    private String imgPublicId;
    private Double rating;
    private Integer reviewCount;
    private Boolean newSProvider;
    private Integer startingPrice;
    private String category;
    private List<String> subcategories;
    private List<String> languages;
    private LocalDateTime joiningDate;
    private String verificationStatus;
    private String activityStatus;
    private String uuid;
    private List<String> reviews;
    private String info;

    // Getters and Setters
}
