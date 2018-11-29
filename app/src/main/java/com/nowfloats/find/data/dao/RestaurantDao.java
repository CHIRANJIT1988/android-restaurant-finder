package com.nowfloats.find.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.nowfloats.find.data.entity.Restaurant;

import java.util.List;


@Dao
public interface RestaurantDao
{
    @Query("SELECT * FROM RESTAURANT")
    List<Restaurant> getAll();

    @Query("SELECT COUNT(*) FROM RESTAURANT WHERE place_id =:id")
    int count(String id);

    @Query("SELECT COUNT(*) FROM RESTAURANT")
    int count();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Restaurant restaurant);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(List<Restaurant> restaurants);

    @Delete
    void delete(Restaurant restaurant);
}