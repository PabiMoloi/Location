package com.example.pmoloi.location.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.repository.LocationRepositoryImpl;

import java.util.List;

public class LocationViewModel extends AndroidViewModel {

    private LiveData<List<LocationModel>> mAllLocations;
    private LocationRepositoryImpl locationRepositoryImpl;

    public LocationViewModel(Application application) {
        super(application);
        locationRepositoryImpl = new LocationRepositoryImpl(application);
        mAllLocations = locationRepositoryImpl.getAllLocations();
    }

    public LiveData<List<LocationModel>> getAllLocations() {
        return mAllLocations;
    }

    public LiveData<LocationModel> findLocationById(int id) {
        return locationRepositoryImpl.findLocationById(id);
    }

    public void insertLocation(LocationModel location) {
        locationRepositoryImpl.insertLocation(location);
    }

}
