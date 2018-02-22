package repository;


import android.arch.lifecycle.LiveData;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.repository.ILocationRepository;

import java.util.List;

public class MockLocationRepositoryImpl implements ILocationRepository {

    private LocationDao locationDao;

    public MockLocationRepositoryImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public LiveData<List<LocationModel>> getAllLocations() {
        return locationDao.getAllLocations();
    }

    public LiveData<LocationModel> findLocationById(int id) {
        return locationDao.findLocationById(id);
    }

    public void insertLocation(LocationModel locationModel) {
        locationDao.insertLocation(locationModel);
    }

}
