package com.nowfloats.find.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.nowfloats.find.R;


public class SplashScreenActivity extends AppCompatActivity implements View.OnClickListener
{
    private final String TAG = SplashScreenActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        makeActivityAppearOnLockScreen();
        redirect_home();
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Inside : ", "onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("Inside : ", "onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Inside : ", "onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Inside : ", "onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d("Inside : ", "onDestroy() event");
    }

    @Override
    public void onBackPressed()
    {

    }


    private void makeActivityAppearOnLockScreen()
    {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                        | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
                        | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    }


    private void redirect_home()
    {
        new Handler().postDelayed(new Runnable() {

            /**
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run()
            {
                if(!isFinishing())
                {
                    startHomeActivity(false);
                }
            }
        }, 3000);
    }


    @Override
    public void onClick(View view)
    {
        startHomeActivity(true);
    }

    /**
     * Redirect to Home
     * @param is_offline
     */
    private void startHomeActivity(boolean is_offline)
    {
        Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
        i.putExtra("IS_OFFLINE", is_offline);
        startActivity(i);
        finish();
    }
}