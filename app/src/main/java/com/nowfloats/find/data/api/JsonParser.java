package com.nowfloats.find.data.api;

import com.nowfloats.find.data.entity.Restaurant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class JsonParser
{

    public static ArrayList<Restaurant> parseJson(String result)
    {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        try
        {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = (JSONArray) jsonObject.get("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonOBJ = jsonArray.getJSONObject(i);

                Restaurant restaurant = new Restaurant();

                restaurant.setPlace_id(jsonOBJ.get("place_id").toString());

                if(jsonOBJ.has("name"))
                {
                    restaurant.setName(jsonOBJ.get("name").toString());
                }

                if(jsonOBJ.has("rating"))
                {
                    restaurant.setRating(Float.parseFloat(jsonOBJ.get("rating").toString()));
                }

                else
                {
                    restaurant.setRating(Float.parseFloat("0"));
                }

                if(jsonOBJ.has("price_level"))
                {
                    restaurant.setPrice_level(Integer.parseInt((jsonOBJ.get("price_level").toString())));
                }

                if(jsonOBJ.has("vicinity"))
                {
                    restaurant.setAddress(jsonOBJ.get("vicinity").toString());
                }

                if(jsonOBJ.has("geometry"))
                {
                    restaurant.setLat(Double.parseDouble(jsonOBJ.getJSONObject("geometry").getJSONObject("location").get("lat").toString()));
                    restaurant.setLng(Double.parseDouble(jsonOBJ.getJSONObject("geometry").getJSONObject("location").get("lng").toString()));
                }

                if(jsonOBJ.has("photos"))
                {
                    restaurant.setPhoto_reference(jsonOBJ.getJSONArray("photos").getJSONObject(0).getString("photo_reference").toString());
                }

                if(jsonOBJ.has("opening_hours"))
                {
                    restaurant.setOpen_now(jsonOBJ.getJSONObject("opening_hours").getBoolean("open_now"));
                }

                restaurantList.add(restaurant);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Collections.sort(restaurantList);

        return restaurantList;
    }
}