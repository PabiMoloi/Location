package com.example.pmoloi.location;

import android.support.test.InstrumentationRegistry;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.database.LocationDatabase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class LocationDatabaseTest {
    LocationDatabase locationDatabase;
    LocationDao locationDao;
    // Context context;


    @Before
    public void databaseSetup() {
        //context = InstrumentationRegistry.getTargetContext();
        //  locationDatabase = Room.inMemoryDatabaseBuilder(context, LocationDatabase.class).build();
        locationDatabase = LocationDatabase.getDatabase(InstrumentationRegistry.getTargetContext());
        locationDao = locationDatabase.locationDao();
    }

    @After
    public void teardown() throws IOException {
        locationDatabase.close();
    }

    @Test
    public void databaseCRUDMethodChecks() {
        Assert.assertEquals(0, locationDao.getAllLocations().getValue().size());
    }
}
