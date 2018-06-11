package com.gabcode.randomgallery_mvvm.data.source.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceApiClient {

    private static ServiceApi instance = null;

    public static ServiceApi getInstance() {
        if (instance == null)
            getRetrofitInstance();

        return instance;
    }

    private static void getRetrofitInstance() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        instance = retrofit.create(ServiceApi.class);
    }
}
