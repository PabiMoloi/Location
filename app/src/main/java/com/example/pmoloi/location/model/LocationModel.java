package com.example.pmoloi.location.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class LocationModel {
    @NonNull
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull int locationId) {
        this.locationId = locationId;
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
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


    public LocationModel(String locationName, double locationLatitude, double locationLongitude, String locationBestFeature, int locationNumberOfVisits)
    {
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationBestFeature = locationBestFeature;
        this.locationNumberOfVisits = locationNumberOfVisits;
    }
}
