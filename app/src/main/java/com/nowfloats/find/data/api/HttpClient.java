package com.nowfloats.find.data.api;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.OkHttpClient;

/**
 * Created by chiranjitbardhan on 03/01/18.
 */
public class HttpClient extends AsyncTask<String, String, String>
{
    private final String LOG_TAG = HttpClient.class.getSimpleName();

    /**
     * 2xx
     */
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int PARTIAL_INFO = 203;
    public static final int NO_RESPONSE = 204;

    /**
     * 3xx
     */
    public static final int MOVED = 301;
    public static final int FOUND = 302;
    public static final int METHOD = 303;
    public static final int NOT_MODIFIED = 304;

    /**
     * 4xx
     */
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int PAYMENT_REQUIRED = 402;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_FOUND = 405;
    public static final int RESOURCE_NOT_AVAILABLE = 410;
    public static final int PRECONDITION_FAILED = 412;
    public static final int UNPROCESSABLE_ENTITY = 422;
    public static final int RESOURCE_LOCKED = 423;
    public static final int REQUEST_LIMIT_EXCEED = 429;

    /**
     * 5xx
     */
    public static final int INTERNAL_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_NOT_AVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;

    private OkHttpClient client = MyOkHttpClient.getOkHttpClient();

    private int responseCode, requestCode;
    private OnHttpResponse listener;


    public HttpClient(int requestCode, OnHttpResponse listener)
    {
        this.requestCode = requestCode;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        listener.onPreExecute();
    }

    @Override
    protected String doInBackground(String...params)
    {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        builder.url(params[0]);

        Log.i(LOG_TAG, "URL :" + params[0]);

        builder.get();

        okhttp3.Request request = builder.build();

        try
        {
            okhttp3.Response response = client.newCall(request).execute();
            responseCode = response.code();

            return response.body().string();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String response)
    {
        super.onPostExecute(response);

        Log.i(LOG_TAG, String.valueOf("RESPONSE DATA :" + response));
        Log.i(LOG_TAG, String.valueOf("RESPONSE CODE :" + responseCode));

        listener.onPostExecute(requestCode, responseCode, String.valueOf(response));
    }
}