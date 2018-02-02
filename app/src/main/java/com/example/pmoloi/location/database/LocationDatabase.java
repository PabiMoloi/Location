package com.example.pmoloi.location.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pmoloi.location.dao.LocationDao;
import com.example.pmoloi.location.model.LocationModel;

@Database(entities = {LocationModel.class}, version = 1)
public abstract class LocationDatabase extends RoomDatabase{

    public abstract LocationDao locationDao();
    public static LocationDatabase INSTANCE;

    static LocationDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null) {
            synchronized (LocationDatabase.class) {
                if (INSTANCE == null) {
                    {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                LocationDatabase.class, "location-database").build();
                    }
                }
            }
        }
        return INSTANCE;
    }

}
