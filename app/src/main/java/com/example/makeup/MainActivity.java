package com.example.makeup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.makeup.Model.ServerResponse;
import com.example.makeup.viewmodels.viewmodel;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    RecyclerView recyclerView;

    TextView noData;
    ServerResponse data;
     viewmodel  viewm_odel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//getting error
        recyclerView=(RecyclerView)findViewById(R.id.course_recyclerview);
        noData=findViewById(R.id.noData);

        //    LoadCourse();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(data, this);
        recyclerView.setAdapter(adapter);


        viewm_odel= ViewModelProviders.of(this).get(viewmodel.class);
        viewm_odel.getCourses().observe(this, new Observer<ServerResponse>() {
            @Override
            public void onChanged(ServerResponse dataResponse) {

                if (dataResponse!=null){
//
                    noData.setVisibility(View.GONE);
                    data=dataResponse;
                    adapter.setCourses(data);

                }
                else {
                    noData.setVisibility(View.VISIBLE);
                }
            }
        });

        viewm_odel.makeApiCall();
    }
}