package com.workup.biddingModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageData {
    private String imageName;
    private String imageType;
    private String imageData; // Base64 encoded image
}
