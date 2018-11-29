package com.nowfloats.find.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.nowfloats.find.data.entity.Restaurant;
import com.nowfloats.find.app.Global;
import com.nowfloats.find.data.dao.RestaurantDao;


@Database(entities = {Restaurant.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{

    private static AppDatabase INSTANCE;

    public abstract RestaurantDao restaurantDao();

    public static AppDatabase getAppDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, Global.DATABASE_NAME)
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}