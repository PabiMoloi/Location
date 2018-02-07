package com.example.pmoloi.location.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmoloi.location.repository.LocationRepository;
import com.example.pmoloi.location.model.LocationModel;

import java.util.List;

public class LocationViewModel extends AndroidViewModel{


    private LiveData<List<LocationModel>> mAllLocations;
    private LocationRepository locationRepository;

    public LocationViewModel(Application application)
    {
        super(application);
        locationRepository = new LocationRepository(application);
        mAllLocations = locationRepository.getAllLocations();
    }
    public LiveData<List<LocationModel>> getAllLocations(){return mAllLocations;}
    public void insertLocation (LocationModel location) {locationRepository.insertLocation(location);}
}
