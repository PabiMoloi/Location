package com.example.pmoloi.location.presentation.details;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.database.LocationDatabase;
import com.example.pmoloi.location.data.model.LocationModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DetailsViewTest {

    private static final int LOCATION_ID = 1;
    @Rule
    public ActivityTestRule<DetailsViewActivity> activityTestRule = new ActivityTestRule<DetailsViewActivity>(DetailsViewActivity.class, true, false);
    private LocationDatabase locationDatabase;
    private LocationDao locationDao;

    @Before
    public void setUp() {
        locationDatabase = LocationDatabase.getDatabase(InstrumentationRegistry.getTargetContext());
        locationDao = locationDatabase.locationDao();
        databaseInsertFunctionalityTest();
    }

    @After
    public void tearDown() {
        locationDatabase.close();
    }

    public void databaseInsertFunctionalityTest() {

        final LocationModel location = new LocationModel("DVT", 26.1215, 28.0313, "Android Development", "Work", 40);
        locationDao.insertLocation(location);
    }

    @Test
    public void displayLocationInformation() {
        Intent locationDetailIntent = new Intent();
        locationDetailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        locationDetailIntent.putExtra("LocationId", LOCATION_ID);
        activityTestRule.launchActivity(locationDetailIntent);

        onView(withText("DVT")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
