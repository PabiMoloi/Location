package com.example.pmoloi.location.data.dao;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.pmoloi.location.data.database.LocationDatabase;
import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.utils.LiveDataTestUtil;
import com.example.pmoloi.location.data.utils.TestLocationGenerator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class LocationDaoTest {

    private LocationDao locationDao;
    private LocationDatabase locationDatabase;

    @Before
    public void setUp() {
        locationDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), LocationDatabase.class).build();
        locationDao = locationDatabase.locationDao();
    }

    @After
    public void closeDb() throws Exception {
        locationDatabase.close();
    }

    @Test
    public void addLocation_TestLocationInsertion() throws InterruptedException {
        LocationModel locationModel = TestLocationGenerator.getGeneratedLocation();
        locationDao.insertLocation(locationModel);
        List<LocationModel> locationList = LiveDataTestUtil.getValue(locationDao.getAllLocations());
        Assert.assertEquals(locationModel.getLocationName(), locationList.get(0).getLocationName());
    }
}
