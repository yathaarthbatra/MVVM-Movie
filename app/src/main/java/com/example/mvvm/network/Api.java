package com.example.mvvm.network;

import com.example.mvvm.model.Actors;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    //in this we will declare the functions to call the API:
    @GET("data.php")
    Call<List<Actors>>  getAllActors();
}
