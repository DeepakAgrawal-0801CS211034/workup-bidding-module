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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getImgPublicId() {
        return imgPublicId;
    }

    public void setImgPublicId(String imgPublicId) {
        this.imgPublicId = imgPublicId;
    }

    public Integer getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Integer startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<String> subcategories) {
        this.subcategories = subcategories;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

