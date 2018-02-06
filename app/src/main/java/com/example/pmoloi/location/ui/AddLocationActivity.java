package com.example.pmoloi.location.ui;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pmoloi.location.R;
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

    public void onSaveClick(View view)
    {
        getViewsFromScreen();
        LocationModel locationModel = new LocationModel(locationName.getEditText().getText().toString(),
                mapLocationLatitude,
                mapLocationLongitude,
                locationBestFeature.getEditText().getText().toString(),
                locationType.getEditText().getText().toString(),
                mNumberOfVisits
                );
        locationViewModel.insertLocation(locationModel);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void getViewsFromScreen()
    {
        locationName = findViewById(R.id.textInputLayoutLocationName);
        locationType = findViewById(R.id.textInputLayoutLocationType);
        locationBestFeature = findViewById(R.id.textInputLayoutLocationBestFeature);
        locationNumberOfVisits = findViewById(R.id.textInputLayoutNumberOfVisits);
        mNumberOfVisits = Integer.parseInt(locationNumberOfVisits.getEditText().getText().toString());
    }
}
