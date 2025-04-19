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

    public ServiceProvider() {
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImgPublicId() {
        return imgPublicId;
    }

    public void setImgPublicId(String imgPublicId) {
        this.imgPublicId = imgPublicId;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Boolean getNewSProvider() {
        return newSProvider;
    }

    public void setNewSProvider(Boolean newSProvider) {
        this.newSProvider = newSProvider;
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

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
