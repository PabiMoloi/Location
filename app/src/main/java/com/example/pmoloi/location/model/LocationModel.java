package com.example.pmoloi.location.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class LocationModel {

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @PrimaryKey(autoGenerate = true)
    private int locationId;

    public String getLocationName() {
        return locationName;
    }

    private String locationName;

    public double getLocationLatitude() {
        return locationLatitude;
    }

    private double locationLatitude;

    public double getLocationLongitude() {
        return locationLongitude;
    }

    private double locationLongitude;

    public String getLocationBestFeature() {
        return locationBestFeature;
    }

    private String locationBestFeature;

    public int getLocationNumberOfVisits() {
        return locationNumberOfVisits;
    }

    private int locationNumberOfVisits;

    public String getLocationType() {
        return locationType;
    }

    private String locationType;

    public LocationModel(String locationName, double locationLatitude, double locationLongitude, String locationBestFeature, String locationType, int locationNumberOfVisits) {
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationBestFeature = locationBestFeature;
        this.locationType = locationType;
        this.locationNumberOfVisits = locationNumberOfVisits;
    }
}
