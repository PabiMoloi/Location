package com.example.pmoloi.location.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.model.LocationModel;

@Database(entities = {LocationModel.class}, version = 1, exportSchema = false)
public abstract class LocationDatabase extends RoomDatabase {

    public abstract LocationDao locationDao();

    private static LocationDatabase INSTANCE;

    public static LocationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return INSTANCE;
    }

    private static LocationDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), LocationDatabase.class, "location_database").build();
    }


}

