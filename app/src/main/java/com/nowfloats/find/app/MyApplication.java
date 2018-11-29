package com.nowfloats.find.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;

public class MyApplication extends Application
{
    public static final String TAG = MyApplication.class.getSimpleName();

    public static MyApplication mInstance;

    public MyApplication()
    {
        super();
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
        mInstance = MyApplication.this;
    }


    /**
     * Call attachBaseContext method
     *
     * @param base application context
     *             Install multidex
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * Call when configuration changed
     *
     * @param newConfig Pass configuration
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Call when device memory low
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * Call on application terminate
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * Return application instance
     *
     * @return instance
     */
    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}
