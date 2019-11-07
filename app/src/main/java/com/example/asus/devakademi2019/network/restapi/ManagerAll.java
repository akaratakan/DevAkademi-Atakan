package com.example.asus.devakademi2019.network.restapi;


import com.example.asus.devakademi2019.common.MainActivity;
import com.example.asus.devakademi2019.network.model.Advert;

import java.util.List;

import retrofit2.Call;

/**
 * Created by asus on 19.10.2019.
 */

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();
    public static int sizeOfList = 10;

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<List<Advert>> getAdvertList(int offset) {
        Call<List<Advert>> callAllAdvertList = getRestApiClient().callAdvertList(String.valueOf(offset),String.valueOf(sizeOfList));
        return callAllAdvertList;

    }

}
