package com.example.pmoloi.location.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.repository.ILocationRepository;
import com.example.pmoloi.location.data.utils.InjectorUtil;

import java.util.List;

public class LocationViewModel extends AndroidViewModel {

    private LiveData<List<LocationModel>> mAllLocations;
    private ILocationRepository iLocationRepository;

    public LocationViewModel(Application application) {
        super(application);
        iLocationRepository = InjectorUtil.getInstance(application);
        mAllLocations = iLocationRepository.getAllLocations();
    }

    public LiveData<List<LocationModel>> getAllLocations() {
        return mAllLocations;
    }

    public LiveData<LocationModel> findLocationById(int id) {
        return iLocationRepository.findLocationById(id);
    }

    public void insertLocation(LocationModel location) {
        iLocationRepository.insertLocation(location);
    }
}
