package com.example.pmoloi.location.adapter;

import android.content.Context;
import android.view.LayoutInflater;


import com.example.pmoloi.location.model.LocationModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.HashSet;
import java.util.List;

public class MapMarkersAdapter
        //extends SupportMapFragment.Adapter<MapMarkersAdapter.MapMarkerViewHolder>
{
    public static class MapMarkerViewHolder extends SupportMapFragment implements OnMapReadyCallback
    {

        @Override
        public void onMapReady(GoogleMap googleMap) {

        }
    }

    private final LayoutInflater layoutInflater;
    private List<LocationModel> mLocations;

    public MapMarkersAdapter(Context context)
    {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setMapMarker( List<LocationModel> location)
    {
       mLocations = location;
       //notifyDataSetChanged();
    }


}
