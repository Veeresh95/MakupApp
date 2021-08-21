package com.example.makeup.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.makeup.MainActivity;
import com.example.makeup.Model.DataResponse;
import com.example.makeup.Network.Api;
import com.example.makeup.Network.RetrofitApiClient;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;

public class viewmodel extends ViewModel {

    private MutableLiveData<DataResponse> data;


    public viewmodel() {
        data=new MutableLiveData<>();
    }

    public MutableLiveData<DataResponse> getCourses(){

        return data;
    }


    public void makeApiCall(){


        Api api = RetrofitApiClient.getClient().create(Api.class);
        Call<DataResponse> call=api.loadCourse();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                assert response.body() != null;

                data.postValue(response.body());

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

                data.postValue(null);
            }
        });
    }



}
