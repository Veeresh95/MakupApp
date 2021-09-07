package com.example.makeup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeup.Model.ServerResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    List<ServerResponse> dataResponse;
    Context context;
    public Adapter(List<ServerResponse> dataResponse, Context context) {
        this.dataResponse=dataResponse;
        this.context=context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {



        holder.desc.setText(dataResponse.get(position).getName());
        holder.name.setText(dataResponse.get(position).getDescription());
        holder.rating.setText(dataResponse.get(position).getRating());
        holder.category.setText(dataResponse.get(position).getCategory());
        holder.price.setText(dataResponse.get(position).getPrice());
        holder.currency.setText(this.dataResponse.get(position).getCurrency());


        Uri  uri1 = Uri.parse(dataResponse.get(position).getImage_link());
        context = holder.course_img.getContext();


        Picasso.with(context)
                .load(uri1)
                .placeholder(R.drawable.ic_launcher_background) //this is optional the image to display while the url image is downloading
                .error(R.drawable.ic_launcher_background)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(holder.course_img);



        //animate(holder);


    }




    @Override
    public int getItemCount() {
        if (this.dataResponse!=null){
            return this.dataResponse.size();
        }
        return 0;//withdrawLists.length; //userlmh.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,desc,price,currency,rating,category;
        ImageView course_img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(TextView) itemView.findViewById(R.id.name);
            desc = (TextView) itemView.findViewById(R.id.description);
            price = (TextView) itemView.findViewById(R.id.price);
            currency = (TextView) itemView.findViewById(R.id.currency);
            rating=(TextView) itemView.findViewById(R.id.rating);
            category=(TextView) itemView.findViewById(R.id.category);
            course_img=(ImageView) itemView.findViewById(R.id.image);



        }


    }

}

