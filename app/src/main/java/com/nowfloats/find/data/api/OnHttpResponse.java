package com.nowfloats.find.data.api;

/**
 * Created by chiranjit on 11/05/17.
 */

public interface OnHttpResponse
{
    void onPreExecute();
    void onPostExecute(int requestCode, int responseCode, String response);
}