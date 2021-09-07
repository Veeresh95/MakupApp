package com.example.makeup.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitApiClient {
    private static Retrofit retrofit = null;



    public static Retrofit getClient()
    {
        String URL_BASEURL="https://makeup-api.herokuapp.com/";
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit==null)
        {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(360, TimeUnit.SECONDS)
                    .readTimeout(360, TimeUnit.SECONDS)
                    .writeTimeout(360, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASEURL)
                //    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
