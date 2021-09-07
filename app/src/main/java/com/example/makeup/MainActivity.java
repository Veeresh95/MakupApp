package com.example.makeup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makeup.Model.ServerResponse;
import com.example.makeup.Network.Api;
import com.example.makeup.Network.RetrofitApiClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    RecyclerView recyclerView;
    TextView noData;
    ServerResponse data;
    Adapter dataAdapter;
    Context context;
    private List<ServerResponse> dataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        initViews();

    }
    private void initViews() {
        noData=findViewById(R.id.noData);
        recyclerView=(RecyclerView)findViewById(R.id.course_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadJSON();
    }

    private void loadJSON() {

        dataArrayList = new ArrayList<>();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://makeup-api.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build();
        Api api=retrofit.create(Api.class);
        Call<List<ServerResponse>> call= api.getJSON();

        call.enqueue(new Callback<List<ServerResponse>>() {
            @Override
            public void onResponse(Call<List<ServerResponse>> call, Response<List<ServerResponse>> response) {

                assert response.body() != null;


                List<ServerResponse> serverResponse=response.body();
                dataAdapter=new Adapter(serverResponse,context);
                recyclerView.setAdapter(dataAdapter);

            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}