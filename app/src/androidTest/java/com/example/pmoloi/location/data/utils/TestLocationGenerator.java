package com.example.pmoloi.location.data.utils;


import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.pmoloi.location.data.model.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class TestLocationGenerator {
    @NonNull
    private static LocationModel getGeneratedInitialized() {
        // LocationModel location = new LocationModel("RANDOM", 26.1215, 28.0313, "Android Development", "Work", 40);
        return new LocationModel("RANDOM", 26.1215, 28.0313, "Android Development", "Work", 40);
    }

    public static LocationModel getGeneratedLocation() {
        //LocationModel locationModel = getGeneratedInitialized();
        return getGeneratedInitialized();
    }

    @NonNull
    public static MutableLiveData<List<LocationModel>> getGoalListMutableData() {
        List<LocationModel> locationList = new ArrayList<>();
        LocationModel locationModel = getGeneratedInitialized();
        locationList.add(locationModel);
        MutableLiveData<List<LocationModel>> generatedLocations = new MutableLiveData<>();
        generatedLocations.setValue(locationList);
        return generatedLocations;
    }
}
