package com.nowfloats.find.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nowfloats.find.data.api.URLBuilder;
import com.nowfloats.find.data.entity.Restaurant;
import com.nowfloats.find.R;
import com.nowfloats.find.helper.ui.ImageLoader;

import java.util.List;


public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RestaurantRecyclerAdapter.ViewHolder>
{
    private OnItemClickListener clickListener;
    private Context context;
    private List<Restaurant> restaurantList;

    public RestaurantRecyclerAdapter(Context context, List<Restaurant> restaurantList)
    {
        super();

        this.restaurantList = restaurantList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_layout, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i)
    {
        viewHolder.bindData(restaurantList.get(i));
        viewHolder.ib_favourite.setTag(i);
    }


    @Override
    public int getItemCount()
    {
        return restaurantList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tv_name;
        TextView tv_location;
        TextView tv_rating;
        TextView tv_opening_hour;
        ImageView iv_thumbnail;
        ImageButton ib_favourite;

        public ViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);

            tv_name = itemView.findViewById(R.id.tvName);
            tv_location = itemView.findViewById(R.id.tvLocation);
            tv_rating = itemView.findViewById(R.id.tvRating);
            tv_opening_hour = itemView.findViewById(R.id.tvOpeningHour);
            iv_thumbnail = itemView.findViewById(R.id.thumbnail);
            ib_favourite = itemView.findViewById(R.id.ibFavorite);

            ib_favourite.setOnClickListener(onFavouriteClickListener);
        }

        private View.OnClickListener onFavouriteClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                int index = (int) v.getTag();

                switch (v.getId())
                {
                    case R.id.ibFavorite:

                        clickListener.onFavoriteClick(v, index);
                        break;
                }
            }
        };


        @Override
        public void onClick(View v)
        {
            clickListener.onItemClick(v, getAdapterPosition());
        }


        private void bindData(Restaurant restaurant)
        {
            tv_name.setText(restaurant.getName());
            tv_location.setText(restaurant.getAddress());
            tv_rating.setText(String.valueOf(restaurant.getRating()));

            if(restaurant.getRating() >= 3)
            {
                tv_rating.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_rating_background_green));
            }

            else if(restaurant.getRating() >= 2)
            {
                tv_rating.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_rating_background_yellow));
            }

            else
            {
                tv_rating.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_rating_background_red));
            }

            if(restaurant.isOpen_now())
            {
                tv_opening_hour.setTextColor(ContextCompat.getColor(context, R.color.green));
                tv_opening_hour.setText("Open");
            }

            else
            {
                tv_opening_hour.setTextColor(ContextCompat.getColor(context, R.color.red));
                tv_opening_hour.setText("Closed");
            }

            if(restaurant.isIs_favourite())
            {
                ib_favourite.setImageResource(R.drawable.ic_favorite_red);
            }

            else
            {
                ib_favourite.setImageResource(R.drawable.ic_favorite_grey);
            }

            loadThumbnail(URLBuilder.thumbURL(restaurant.getPhoto_reference()));
        }


        private void loadThumbnail(final String url)
        {
            try
            {
                if(!url.isEmpty())
                {
                    ImageLoader.loadThumbnail(context, url, iv_thumbnail, R.drawable.restaurant, 75, 75);
                }
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onFavoriteClick(View view, int position);
    }


    public void SetOnItemClickListener(final OnItemClickListener itemClickListener)
    {
        this.clickListener = itemClickListener;
    }
}