package com.example.pmoloi.location.ui.activity.map;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.pmoloi.location.R;
import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.viewmodel.LocationViewModel;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;

class LoadMapPoints {

    LoadMapPoints() {
    }

    void populateMap(MapsActivity mapsActivity, final GoogleMap mMap, LocationViewModel locationViewModel) {
        locationViewModel = ViewModelProviders.of(mapsActivity).get(LocationViewModel.class);
        final MapMarkersAdapter mapMarkersAdapter = new MapMarkersAdapter(mapsActivity, R.layout.recyclerview_item);
        locationViewModel.getAllLocations().observe(mapsActivity, new Observer<List<LocationModel>>() {
            @Override
            public void onChanged(List<LocationModel> locationModels) {
                for (int i = 0; i < locationModels.size(); i++) {
                    mapMarkersAdapter.setMapMarkers(mMap, locationModels.get(i));
                }
            }
        });
    }
}
