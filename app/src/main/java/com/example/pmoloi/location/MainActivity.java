package com.example.pmoloi.location;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pmoloi.location.ViewModel.LocationViewModel;
import com.example.pmoloi.location.adapter.LocationListAdapter;
import com.example.pmoloi.location.model.LocationModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LocationViewModel locationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewContentMain);
        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);
        final LocationListAdapter listAdapter = new LocationListAdapter(this);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        locationViewModel.getAllLocations().observe(this, new Observer<List<LocationModel>>() {
            @Override
            public void onChanged(@Nullable List<LocationModel> locationModels) {
                listAdapter.setLocations(locationModels);
            }
        });
    }

    public void addLocationButtonPress(View view)
    {
        Intent addLocationIntent = new Intent(this, MapsActivity.class);
        startActivity(addLocationIntent);
    }
}
