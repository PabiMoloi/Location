package com.example.pmoloi.location.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pmoloi.location.data.model.LocationModel;

import java.util.List;

@Dao
public interface LocationDao {

    @Insert
    void insertLocation(LocationModel location);

    @Query("SELECT * FROM LocationModel")
    LiveData<List<LocationModel>> getAllLocations();

    @Query("SELECT * FROM LocationModel WHERE locationId = :id")
    LiveData<LocationModel> findLocationById(int id);
}