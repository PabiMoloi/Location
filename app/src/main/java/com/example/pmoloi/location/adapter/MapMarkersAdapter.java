package com.example.pmoloi.location.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.pmoloi.location.R;
import com.example.pmoloi.location.model.LocationModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashSet;

public class MapMarkersAdapter extends ArrayAdapter<LocationModel> {
    private final LayoutInflater layoutInflater;
    private final HashSet<MapView> mMaps = new HashSet<>();


    public MapMarkersAdapter(Context context, int resource) {
        super(context, resource);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View mapRow = convertView;
        ViewHolder holder;

        if (mapRow == null) {
            mapRow = layoutInflater.inflate(R.layout.activity_maps, null);
            holder = new ViewHolder();
            mapRow.setTag(holder);
            holder.initializeMap();
            mMaps.add(holder.mapView);
        } else {
            holder = (ViewHolder) mapRow.getTag();
        }
        LocationModel mapPoint = getItem(position);
        holder.mapView.setTag(mapPoint);

        if (holder.map != null) {
            setMapMarkers(holder.map, mapPoint);
        }
        return mapRow;
    }

    public void setMapMarkers(GoogleMap map, LocationModel locationModel) {
        map.addMarker(new MarkerOptions().position(new LatLng(locationModel.getLocationLatitude(), locationModel.getLocationLongitude()))
                .title(locationModel.getLocationName())
                .snippet(locationModel.getLocationBestFeature())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
    }

    class ViewHolder implements OnMapReadyCallback {
        MapView mapView;
        GoogleMap map;

        void initializeMap() {
            if (mapView != null) {
                mapView.onCreate(null);
                mapView.getMapAsync(this);
            }
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsInitializer.initialize(getContext());
            map = googleMap;
            LocationModel locationModel = (LocationModel) mapView.getTag();
            if (locationModel != null) {
                setMapMarkers(map, locationModel);
            }
        }
    }

}
