package com.example.movieflxusingactivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private int[] image;
    private List<String> list;
    private List<String> movie_cast;
    private List<String> movie_disp;
    private Context context;

    public RecyclerAdapter(int[] image, List<String> list,Context context,List<String> movie_cast,List<String> movie_disp)
    {
        this.image = image;
        this.list = list;
        this.movie_cast = movie_cast;
        this.movie_disp = movie_disp;
        this.context = context;
    }


    public RecyclerAdapter(List<String> list)
    {
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.test_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);*/
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.test_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,context,image,list,movie_cast,movie_disp);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       // holder.android_ve.setText(list.get(position));
        int image_id = image[position];
        holder.photo_v.setImageResource(image_id);
        holder.android_ve.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView android_ve;
        ImageView photo_v;
        Context context;
        int[] image;
        List<String> list;
        List<String> movie_cast;
        List<String> movie_disp;

        public MyViewHolder(View itemView, Context context, int[] image, List<String> list,List<String> movie_cast,List<String> movie_disp) {
            super(itemView);

            photo_v = itemView.findViewById(R.id.photo);
            android_ve = itemView.findViewById(R.id.android_v);
            itemView.setOnClickListener(this);
            this.context = context;
            this.image = image;
            this.list = list;
            this.movie_cast = movie_cast;
            this.movie_disp = movie_disp;
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(context,DisplayActivity.class );
            intent.putExtra("Image_id", image[getAdapterPosition()]);
            intent.putExtra("Name_id", list.get(getAdapterPosition()));
            intent.putExtra("Movie_Cast_id", movie_cast.get(getAdapterPosition()));
            intent.putExtra("Movie_Disp_id", movie_disp.get(getAdapterPosition()));
            context.startActivity(intent);

        }
    }
}
