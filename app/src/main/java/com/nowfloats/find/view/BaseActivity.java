package com.nowfloats.find.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.nowfloats.find.data.api.OnHttpResponse;
import com.nowfloats.find.app.MyApplication;

/**
 * Created by chiranjitbardhan on 20/01/18.
 */
public abstract class BaseActivity extends AppCompatActivity implements OnHttpResponse
{
    public static final String TAG = BaseActivity.class.getSimpleName();

    public MyApplication mController;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.mController = MyApplication.getInstance();
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute(int requestCode, int responseCode, String response) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        try
        {
            if (getCurrentFocus() != null)
            {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                if(imm != null)
                {
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.dispatchTouchEvent(ev);
    }
}