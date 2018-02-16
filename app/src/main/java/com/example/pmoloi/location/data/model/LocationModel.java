package com.example.pmoloi.location.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class LocationModel implements Parcelable {

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

    public LocationModel(Parcel in) {
        this.locationId = in.readInt();
        this.locationLatitude = in.readDouble();
        this.locationLongitude = in.readDouble();
        this.locationBestFeature = in.readString();
        this.locationType = in.readString();
        this.locationNumberOfVisits = in.readInt();
    }


    public static final Parcelable.Creator<LocationModel> CREATOR = new Parcelable.Creator<LocationModel>() {

        public LocationModel createFromParcel(Parcel in) {
            return new LocationModel(in);
        }

        public LocationModel[] newArray(int size) {
            return new LocationModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getLocationId());
        dest.writeDouble(getLocationLatitude());
        dest.writeDouble(getLocationLongitude());
        dest.writeString(getLocationName());
        dest.writeString(getLocationType());
        dest.writeString(getLocationBestFeature());
        dest.writeInt(getLocationNumberOfVisits());
    }
}
