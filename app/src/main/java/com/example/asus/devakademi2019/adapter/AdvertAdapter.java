package com.example.asus.devakademi2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.devakademi2019.R;
import com.example.asus.devakademi2019.common.DetailActivity;
import com.example.asus.devakademi2019.common.MainActivity;
import com.example.asus.devakademi2019.network.model.Advert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 19.10.2019.
 */

public class AdvertAdapter extends RecyclerView.Adapter<AdvertAdapter.AdvertHolder> {

    private Context context;
    private List<Advert> mList;

    class AdvertHolder extends RecyclerView.ViewHolder {
        public TextView advertTitle_tv;
        public TextView advertPrice_tv;
        public TextView advertTown_tv;
        public TextView advertCity_tv;
        public ImageView advert_iv;
        public ImageView advertHasPromotion_iv;
        public ImageView advert_mostViewed_iv;
        public CardView cardView;
        public AdvertHolder(View itemView) {
            super(itemView);
            advertTitle_tv             = itemView.findViewById(R.id.advertTitle_tv);
            advertPrice_tv             = itemView.findViewById(R.id.advertPrice_tv);
            advertTown_tv              = itemView.findViewById(R.id.town_tv);
            advertCity_tv              = itemView.findViewById(R.id.city_tv);
            advert_iv                  = itemView.findViewById(R.id.placeHolder_iv);
            advertHasPromotion_iv      = itemView.findViewById(R.id.specialOffer_detail_iv);
            advert_mostViewed_iv       = itemView.findViewById(R.id.mostViewed_iv);
            cardView                   = itemView.findViewById(R.id.cardView);
        }
    }

    public AdvertAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdvertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_advert,parent,false);
        return new AdvertHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertHolder holder, int position) {

        final Advert currentAdvert = mList.get(position);

        holder.advertTitle_tv.setText(currentAdvert.getTitle());
        holder.advertPrice_tv.setText(String.valueOf(currentAdvert.getPrice()));
        holder.advertTown_tv.setText(currentAdvert.getTown());
        holder.advertCity_tv.setText(currentAdvert.getCity());

        if (currentAdvert.getHasPromotion() == 1) {
            holder.advertHasPromotion_iv.setVisibility(View.VISIBLE);
        } else {
            holder.advertHasPromotion_iv.setVisibility(View.GONE);
        }

        if (currentAdvert.getViewCount() > 25) {
            holder.advert_mostViewed_iv.setVisibility(View.VISIBLE);
        } else {
            holder.advert_mostViewed_iv.setVisibility(View.GONE);
        }

        final String price = String.valueOf(currentAdvert.getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title",currentAdvert.getTitle());
                intent.putExtra("description",currentAdvert.getDescription());
                intent.putExtra("has_promotion",currentAdvert.getHasPromotion());
                intent.putExtra("price",price);
                intent.putExtra("town",currentAdvert.getTown());
                intent.putExtra("city",currentAdvert.getCity());
                context.startActivity(intent);

            }
        });

    }

    public void addToList(List<Advert> advertList) {
        mList.addAll(advertList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
