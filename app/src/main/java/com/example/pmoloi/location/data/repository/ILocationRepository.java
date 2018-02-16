package com.example.pmoloi.location.data.repository;

import android.arch.lifecycle.LiveData;

import com.example.pmoloi.location.data.model.LocationModel;

import java.util.List;

public interface ILocationRepository {
    LiveData<List<LocationModel>> getAllLocations();

    LiveData<LocationModel> findLocationById(int id);

    void insertLocation(LocationModel locationModel);

}
