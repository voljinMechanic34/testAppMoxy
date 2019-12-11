package com.example.testapp.api;

import com.example.testapp.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTest {

    @GET("json/JSONSample.json")
    Call<Example> getAllTodo();
}
