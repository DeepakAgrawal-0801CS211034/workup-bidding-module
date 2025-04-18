package com.workup.biddingModule.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceProviderRegistrationDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String imgURL;
    private String imgPublicId;
    private Integer startingPrice;
    private String category;
    private List<String> subcategories;
    private List<String> languages;
    private String info;

    // Getters and Setters
}

