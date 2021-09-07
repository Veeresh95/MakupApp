package com.example.makeup.Network;

import com.example.makeup.Model.ServerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api/v1/products.json")
    Call<List<ServerResponse>> getJSON();
}
