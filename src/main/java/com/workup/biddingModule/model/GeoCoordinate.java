package com.workup.biddingModule.model;

public class GeoCoordinate {
    private Double x;
    private Double y;

    public GeoCoordinate() {}

    public GeoCoordinate(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
