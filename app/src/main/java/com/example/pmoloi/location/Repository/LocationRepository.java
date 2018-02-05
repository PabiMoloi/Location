package com.example.pmoloi.location.Repository;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.location.Location;
import android.os.AsyncTask;

import com.example.pmoloi.location.dao.LocationDao;
import com.example.pmoloi.location.database.LocationDatabase;
import com.example.pmoloi.location.model.LocationModel;

import java.util.List;

public class LocationRepository {

    private LocationDao locationDao;
    private LiveData<List<LocationModel>> mAllLocations;

   public LocationRepository(Application application)
    {
        LocationDatabase db = LocationDatabase.getDatabase(application);
        locationDao = db.locationDao();
        mAllLocations = locationDao.getAllLocations();
    }

    public LiveData<List<LocationModel>> getAllLocations(){return mAllLocations;}

    private static class insertAsyncTask extends AsyncTask<LocationModel, Void, Void>
    {
        private LocationDao asyncLocationDao;
        insertAsyncTask(LocationDao locationDao){asyncLocationDao = locationDao;}

        @Override
        protected Void doInBackground(final LocationModel... params)
        {
            asyncLocationDao.insertLocation(params[0]);
            return null;
        }
    }
}
