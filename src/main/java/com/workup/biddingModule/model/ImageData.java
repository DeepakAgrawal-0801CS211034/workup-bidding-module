package com.workup.biddingModule.model;

public class ImageData {
    private String imageName;
    private String imageType;
    private String imageData; // Base64 encoded image

    // Getters and Setters
    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public String getImageType() { return imageType; }
    public void setImageType(String imageType) { this.imageType = imageType; }

    public String getImageData() { return imageData; }
    public void setImageData(String imageData) { this.imageData = imageData; }
}
