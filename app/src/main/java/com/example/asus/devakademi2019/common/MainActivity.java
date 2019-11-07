package com.example.asus.devakademi2019.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.asus.devakademi2019.R;
import com.example.asus.devakademi2019.adapter.AdvertAdapter;
import com.example.asus.devakademi2019.network.model.Advert;
import com.example.asus.devakademi2019.network.restapi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AdvertAdapter advertAdapter;

    private List<Advert> partOfList;

    private int offset = 0;

    private boolean isScrolling = false;
    private boolean isFinished  = false;
    private boolean isSendingRequest = false;

    private int currentItems = 0;
    private int totalItems = 0;
    private int scrolledItems = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.main_rv);
        recyclerView.setHasFixedSize(true);

        advertAdapter = new AdvertAdapter(MainActivity.this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = linearLayoutManager.getChildCount();
                totalItems   = linearLayoutManager.getItemCount();
                scrolledItems = linearLayoutManager.findFirstVisibleItemPosition();

                if (isScrolling && totalItems == currentItems + scrolledItems ) {
                    isScrolling = false;

                    if (!isFinished) {
                        if (!isSendingRequest){
                            sendRequest();
                        }
                    } else {
                        Toast.makeText(MainActivity.this,"There is no more element for shown",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sendRequest();

    }

    public void sendRequest() {

        isSendingRequest = true;
        partOfList = new ArrayList<>();
        final int sizeOfList = ManagerAll.sizeOfList;

        Call<List<Advert>> advertList = ManagerAll.getInstance().getAdvertList(offset);
        advertList.enqueue(new Callback<List<Advert>>() {
            @Override
            public void onResponse(Call<List<Advert>> call, Response<List<Advert>> response) {
                partOfList = response.body();
                advertAdapter.addToList(partOfList);
                recyclerView.setAdapter(advertAdapter);
                isSendingRequest = false;

                if (partOfList.size()+1 < sizeOfList) {
                    isFinished = true;
                } else {
                    offset = offset + sizeOfList;
                }

            }

            @Override
            public void onFailure(Call<List<Advert>> call, Throwable t) {
                isSendingRequest = false;
                Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
