package com.example.pmoloi.location.repository;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.pmoloi.location.dao.LocationDao;
import com.example.pmoloi.location.database.LocationDatabase;
import com.example.pmoloi.location.model.LocationModel;

import java.util.List;

public class LocationRepository {

    private LocationDao locationDao;
    private LiveData<List<LocationModel>> mAllLocations;

    public LocationRepository(Application application) {
        LocationDatabase db = LocationDatabase.getDatabase(application);
        locationDao = db.locationDao();
        mAllLocations = locationDao.getAllLocations();
    }

    public LiveData<List<LocationModel>> getAllLocations() {
        return mAllLocations;
    }

    public LiveData<LocationModel> findLocationById(int id) {
        return locationDao.findLocationById(id);
    }

    public void insertLocation(LocationModel locationModel) {
        new InsertAsyncTask(locationDao).execute(locationModel);
    }

    private static class InsertAsyncTask extends AsyncTask<LocationModel, Void, Void> {
        private LocationDao asyncLocationDao;

        InsertAsyncTask(LocationDao locationDao) {
            asyncLocationDao = locationDao;
        }

        @Override
        protected Void doInBackground(final LocationModel... params) {
            asyncLocationDao.insertLocation(params[0]);
            return null;
        }
    }

}
