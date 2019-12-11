package com.example.testapp.api;

import com.example.testapp.constants.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofitInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static ApiTest getApiService() {
        return getRetrofitInstance().create(ApiTest.class);
    }
}
