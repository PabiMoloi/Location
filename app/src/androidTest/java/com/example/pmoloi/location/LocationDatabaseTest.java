package com.example.pmoloi.location;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.database.LocationDatabase;
import com.example.pmoloi.location.presentation.splash.SplashScreenActivity;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LocationDatabaseTest {

    LocationDatabase locationDatabase;
    LocationDao locationDao;

    @Before
    public void setUp() {
        locationDatabase = LocationDatabase.getDatabase(InstrumentationRegistry.getTargetContext());
        locationDao = locationDatabase.locationDao();
    }

    @After
    public void tearDown() {
        locationDatabase.close();
    }

    @Rule
    public ActivityTestRule<SplashScreenActivity> mActivityTestRule = new ActivityTestRule<>(SplashScreenActivity.class);

    @Test
    public void databaseFunctionalityTest() {
        Assert.assertEquals(0, locationDao.getAllLocations().getValue().size());
    }
}
