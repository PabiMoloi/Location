package com.example.pmoloi.location.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.repository.LocationRepository;

import java.util.List;

public class LocationViewModel extends AndroidViewModel {

    private LiveData<List<LocationModel>> mAllLocations;
    private LocationRepository locationRepository;

    public LocationViewModel(Application application) {
        super(application);
        locationRepository = new LocationRepository(application);
        mAllLocations = locationRepository.getAllLocations();
    }

    public LiveData<List<LocationModel>> getAllLocations() {
        return mAllLocations;
    }

    public LiveData<LocationModel> findLocationById(int id) {
        return locationRepository.findLocationById(id);
    }

    public void insertLocation(LocationModel location) {
        locationRepository.insertLocation(location);
    }

}
