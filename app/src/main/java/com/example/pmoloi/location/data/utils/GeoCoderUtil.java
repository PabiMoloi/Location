package com.example.pmoloi.location.data.utils;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoCoderUtil {

    private Context context;
    private StringBuilder address;

    public GeoCoderUtil(Context context) {
        this.context = context;
    }

    public StringBuilder getLocationAddress(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);

        try {
            List<Address> retrievedAddresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (retrievedAddresses.size() > 0) {
                Address currentAddress = retrievedAddresses.get(0);
                address = new StringBuilder();
                for (int i = 0; i <= currentAddress.getMaxAddressLineIndex(); i++) {
                    address.append(currentAddress.getAddressLine(i)).append(",");
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            address.append("Could not retrieve street address");
        }
        return address;
    }
}

