package com.example.asus.devakademi2019.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.devakademi2019.R;

public class DetailActivity extends AppCompatActivity {

    private TextView detailTitle_tv;
    private TextView detailDesc_tv;
    private TextView detailPrice_tv;
    private TextView town_detail_tv;
    private TextView city_detail_tv;
    private ImageView specialOffer_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle_tv     = findViewById(R.id.advertDetailTitle_tv);
        detailDesc_tv      = findViewById(R.id.advertDetailDescription_tv);
        specialOffer_iv    = findViewById(R.id.detailSpecialOffer_iv);
        town_detail_tv     = findViewById(R.id.town_detail_tv);
        city_detail_tv     = findViewById(R.id.city_detail_tv);
        detailPrice_tv     = findViewById(R.id.detailAdvertPrice_tv);

        String title       = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String town        = getIntent().getStringExtra("town");
        String city        = getIntent().getStringExtra("city");
        String price       = getIntent().getStringExtra("price");
        int has_promotion  = getIntent().getIntExtra("has_promotion",0);

        detailTitle_tv.setText(title);
        detailDesc_tv.setText(description);
        town_detail_tv.setText(town);
        city_detail_tv.setText(city);
        detailPrice_tv.setText(String.valueOf(price));

        if (has_promotion==1) {
            specialOffer_iv.setVisibility(View.VISIBLE);
        } else {
            specialOffer_iv.setVisibility(View.GONE);
        }
    }
}
