package com.example.makeup.Network;

import com.example.makeup.Model.DataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @Headers("Content-Type: application/json")
    @POST("api/v1/products.json")
    Call<DataResponse> loadCourse();
}
