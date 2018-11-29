package com.nowfloats.find.data.api;

import com.nowfloats.find.app.Global;

public class URLBuilder
{

    public static String thumbURL(String photo_ref)
    {
        return new StringBuilder().append("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=")
                .append(photo_ref)
                .append("&key=")
                .append(Global.GOOGLE_KEY).toString();

    }

    public static String placesURL(double latitude, double longitude, int radius)
    {
        return new StringBuilder().append("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=")
                .append(latitude)
                .append(",")
                .append(longitude)
                .append("&radius=")
                .append(radius)
                .append("&type=restaurant&key=")
                .append(Global.GOOGLE_KEY).toString();
    }
}
