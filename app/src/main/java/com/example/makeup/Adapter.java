package com.example.makeup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

    // method for filtering our recyclerview items.
    public void filterList(List<ServerResponse> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        dataResponse = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {



        holder.desc.setText(dataResponse.get(position).getDescription());
        holder.name.setText(dataResponse.get(position).getName());
      //  holder.rating.setText(dataResponse.get(position).getRating());
        holder.category.setText(dataResponse.get(position).getCategory());
        holder.price.setText(dataResponse.get(position).getPrice());
        holder.currency.setText(dataResponse.get(position).getCurrency());


        Uri  uri1 = Uri.parse(dataResponse.get(position).getImage_link());
        context = holder.course_img.getContext();


        Picasso.with(context)
                .load(uri1)
                .placeholder(R.drawable.ic_launcher_background) //this is optional the image to display while the url image is downloading
                .error(R.drawable.ic_launcher_background)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(holder.course_img);


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
                View itemView=LayoutInflater.from(context).inflate(R.layout.image_layout,null);

                TextView name1,desc1,price1,currency1,category1;
                    ImageView    course_img1;
                     LinearLayout       parent1;

                name1=(TextView) itemView.findViewById(R.id.name);
                desc1 = (TextView) itemView.findViewById(R.id.description);
                price1 = (TextView) itemView.findViewById(R.id.price);
                currency1 = (TextView) itemView.findViewById(R.id.currency);
                //   rating=(TextView) itemView.findViewById(R.id.rating);
                category1=(TextView) itemView.findViewById(R.id.category);
                course_img1=(ImageView) itemView.findViewById(R.id.image);
                parent1=(LinearLayout) itemView.findViewById(R.id.parent);


                if (dataResponse.get(position).getProduct_colors().get(position).getHexValue()!=null){
                    desc1.setTextColor(Color.parseColor(dataResponse.get(position).getProduct_colors().get(position).getHexValue()));
                }

                desc1.setText(dataResponse.get(position).getDescription());
                name1.setText(dataResponse.get(position).getName());
                //  holder.rating.setText(dataResponse.get(position).getRating());
                category1.setText(dataResponse.get(position).getCategory());
                price1.setText(dataResponse.get(position).getPrice());
                currency1.setText(dataResponse.get(position).getCurrency());


                Uri  uri1 = Uri.parse(dataResponse.get(position).getImage_link());
                context = course_img1.getContext();


                Picasso.with(context)
                        .load(uri1)
                        .placeholder(R.drawable.ic_launcher_background) //this is optional the image to display while the url image is downloading
                        .error(R.drawable.ic_launcher_background)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                        .into(course_img1);


                alertDialog.setView(itemView);
                final AlertDialog dialog = alertDialog.create();
                dialog.show();

                if (dialog.getWindow()!=null){

                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.height =  WindowManager.LayoutParams.WRAP_CONTENT;
                    dialog.getWindow().setAttributes(lp);

                }



            }
        });

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
        LinearLayout parent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(TextView) itemView.findViewById(R.id.name);
            desc = (TextView) itemView.findViewById(R.id.description);
            price = (TextView) itemView.findViewById(R.id.price);
            currency = (TextView) itemView.findViewById(R.id.currency);
         //   rating=(TextView) itemView.findViewById(R.id.rating);
            category=(TextView) itemView.findViewById(R.id.category);
            course_img=(ImageView) itemView.findViewById(R.id.image);
            parent=(LinearLayout) itemView.findViewById(R.id.parent);


        }


    }

}

