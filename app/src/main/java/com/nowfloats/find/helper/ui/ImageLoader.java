package com.nowfloats.find.helper.ui;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

    public static void loadThumbnail(final Context context, String url, final ImageView imageView, int placeholder, int size_x, int size_y)
    {
        try
        {
            Glide.with(context)
                    .load(url)
                    .placeholder(placeholder)
                    .dontAnimate()
                    .override(size_x, size_y)
                    .centerCrop()
                    .thumbnail(0.1f)
                    .into(imageView);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}