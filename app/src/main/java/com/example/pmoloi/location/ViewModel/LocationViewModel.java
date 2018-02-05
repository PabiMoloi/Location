package com.example.pmoloi.location.ViewModel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.location.Location;

import com.example.pmoloi.location.Repository.LocationRepository;
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
    public void insertLocation (LocationModel location) {};
}
