package com.example.asus.devakademi2019.network.restapi;

import com.example.asus.devakademi2019.network.model.Advert;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 19.10.2019.
 */

public interface RestApi {

    @GET("auctions")
    Call<List<Advert>> callAdvertList(@Query("offset") String offset, @Query("size") String size);


}
