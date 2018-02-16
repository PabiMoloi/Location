package com.example.pmoloi.location.data.utils;


import android.content.Context;

import com.example.pmoloi.location.data.database.LocationDatabase;
import com.example.pmoloi.location.data.repository.ILocationRepository;
import com.example.pmoloi.location.data.repository.LocationRepositoryImpl;

public class InjectorUtil {

    private static ILocationRepository iLocationRepository = null;

    public static ILocationRepository getInstance(final Context context) {
        if (iLocationRepository == null) {
            synchronized (ILocationRepository.class) {
                if (iLocationRepository == null) {
                    iLocationRepository = new LocationRepositoryImpl(LocationDatabase.getDatabase(context).locationDao());
                }
            }
        }
        return iLocationRepository;
    }
}
