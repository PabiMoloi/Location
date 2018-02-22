package com.example.pmoloi.location.presentation.add;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.database.LocationDatabase;
import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.presentation.list.MainActivity;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AddLocationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class, true, true);
    private LocationDatabase locationDatabase;
    private LocationDao locationDao;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getTargetContext();
        locationDatabase = Room.inMemoryDatabaseBuilder(context, LocationDatabase.class).build();
        locationDao = locationDatabase.locationDao();
    }

    @After
    public void tearDown() {
        locationDatabase.close();
    }


    @Test
    public void databaseInsertandFetchFunctionalityTest() {

        final LocationModel location = new LocationModel("RANDOM", 26.1215, 28.0313, "Android Development", "Work", 40);
        locationDao.insertLocation(location);
        Assert.assertNotNull(location.getLocationId());
        Assert.assertNotNull(locationDao.getAllLocations());

    }


}
