package com.example.asus.devakademi2019.network.restapi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asus on 19.10.2019.
 */

public class RestApiClient {

    private RestApi restApiListener;

    public RestApiClient (String baseUrl) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .connectTimeout(3,TimeUnit.SECONDS);

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApiListener = retrofit.create(RestApi.class);


    }
    public RestApi getRestApiListener() {
        return restApiListener;
    }

}
