package com.nowfloats.find.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;


@Entity(tableName = "restaurant")
public class Restaurant implements Serializable, Comparable<Restaurant>
{
    @PrimaryKey
    @NonNull
    private String place_id;
    private Double lat;
    private Double lng;
    private String name;
    private boolean open_now;
    private String photo_reference;
    private Float rating;
    private String address;
    private boolean is_favourite;
    private int price_level;


    public int getPrice_level() {
        return price_level;
    }

    public void setPrice_level(int price_level) {
        this.price_level = price_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen_now() {
        return open_now;
    }

    public void setOpen_now(boolean open_now) {
        this.open_now = open_now;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", price_level=" + price_level +
                ", name='" + name + '\'' +
                ", open_now=" + open_now +
                ", photo_reference='" + photo_reference + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull Restaurant restaurant)
    {
        return restaurant.getRating().compareTo(this.getRating());
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public boolean isIs_favourite() {
        return is_favourite;
    }

    public void setIs_favourite(boolean is_favourite) {
        this.is_favourite = is_favourite;
    }
}