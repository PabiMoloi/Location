package com.example.pmoloi.location;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pmoloi.location.ViewModel.LocationViewModel;
import com.example.pmoloi.location.model.LocationModel;

public class AddLocationActivity extends AppCompatActivity {

    private TextInputLayout locationName, locationBestFeature, locationType,locationNumberOfVisits;
    private int mNumberOfVisits;
    LocationViewModel locationViewModel;
    private Double mapLocationLatitude,mapLocationLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        mapLocationLatitude = getIntent().getDoubleExtra("mMapCoordinatesLatitude",0);
        mapLocationLongitude = getIntent().getDoubleExtra("mMapCoordinatesLongitude",0);
        locationViewModel = new LocationViewModel(this.getApplication());
    }
}
