package com.example.pmoloi.location.presentation.details;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.pmoloi.location.R;
import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.utils.GeoCoderUtil;
import com.example.pmoloi.location.presentation.list.MainActivity;
import com.example.pmoloi.location.viewmodel.LocationViewModel;

public class DetailsViewActivity extends AppCompatActivity {

    LocationViewModel locationViewModel;
    TextView locationName, locationType, locationBestFeature, locationNumberOfVisits, locationStreetAddress;
    int locationId;
    GeoCoderUtil geoCoderUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        initializeVariables();
        geoCoderUtil = new GeoCoderUtil(this);
        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);
        locationViewModel.findLocationById(locationId).observe(this, new Observer<LocationModel>() {
            @Override
            public void onChanged(@Nullable LocationModel locationModel) {
                locationName.setText(locationModel.getLocationName());
                locationType.setText(locationModel.getLocationType());
                locationBestFeature.setText(locationModel.getLocationBestFeature());
                String numberOfVisits = String.valueOf(locationModel.getLocationNumberOfVisits());
                locationNumberOfVisits.setText(numberOfVisits);
                locationStreetAddress.setText(geoCoderUtil.getLocationAddress(locationModel.getLocationLatitude(), locationModel.getLocationLongitude()).toString());
            }
        });
    }

    private void initializeVariables() {
        locationName = findViewById(R.id.textViewDetailsViewLocationName);
        locationType = findViewById(R.id.textViewDetailsViewLocationType);
        locationBestFeature = findViewById(R.id.textViewDetailsViewLocationBestFeature);
        locationStreetAddress = findViewById(R.id.textViewDetailsStreetAddress);
        locationNumberOfVisits = findViewById(R.id.textViewDetailsViewNumberOfVisitsCount);
        locationId = getIntent().getIntExtra("LocationId", 0);
    }

    public void onCancelClick(View view) {
        startActivity(new Intent(DetailsViewActivity.this, MainActivity.class));
        finish();
    }
}