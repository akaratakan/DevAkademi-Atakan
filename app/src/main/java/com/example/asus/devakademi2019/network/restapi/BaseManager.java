package com.example.asus.devakademi2019.network.restapi;

/**
 * Created by asus on 19.10.2019.
 */

public class BaseManager {

    protected RestApi getRestApiClient() {

        RestApiClient restApiClient = new RestApiClient(BaseUrl.main_url);
        return restApiClient.getRestApiListener();

    }

}
