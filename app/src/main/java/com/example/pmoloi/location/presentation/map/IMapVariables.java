package com.example.pmoloi.location.presentation.map;

import com.google.android.gms.maps.model.LatLng;

public interface IMapVariables {
    int DEFAULT_ZOOM = 18;
    int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    LatLng mDefaultLocation = new LatLng(26.2041, 28.0473);
    String KEY_CAMERA_POSITION = "camera_position";
    String KEY_LOCATION = "location";
    String TAG = MapsActivity.class.getSimpleName();
}
