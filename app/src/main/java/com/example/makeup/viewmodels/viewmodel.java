package com.example.makeup.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.makeup.Model.ServerResponse;
import com.example.makeup.Network.Api;
import com.example.makeup.Network.RetrofitApiClient;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class viewmodel extends ViewModel {

    private MutableLiveData<ServerResponse> data;


    public viewmodel() {
        data=new MutableLiveData<>();
    }

    public MutableLiveData<ServerResponse> getCourses(){

        return data;
    }


    public void makeApiCall(){


      /*  Api api = RetrofitApiClient.getClient().create(Api.class);
        Call<ServerResponse> call=api.loadCourse();*/
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://makeup-api.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build();
        Api requestInterface=retrofit.create(Api.class);
        Call<ServerResponse> call= requestInterface.getJSON();

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                assert response.body() != null;

                data.postValue(response.body());

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                data.postValue(null);
            }
        });
    }



}
