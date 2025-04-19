package com.workup.biddingModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageData {
    private String imageName;
    private String imageType;
    private String imageData; // Base64 encoded image


    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
