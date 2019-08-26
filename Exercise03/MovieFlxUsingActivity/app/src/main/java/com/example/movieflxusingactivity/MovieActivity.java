package com.example.movieflxusingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    private RecyclerView recycleview;
    private int[] image = {R.drawable.pic01, R.drawable.pic02,R.drawable.pic03, R.drawable.pic04,
            R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, R.drawable.pic08, R.drawable.pic09,
            R.drawable.pic10};

    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    private List<String> movie_disp;
    private List<String> movie_cast;
    private RecyclerAdapter adapter;
    // private RecyclerAdapter adapter01;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recycleview.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.moviename));
        movie_disp = Arrays.asList(getResources().getStringArray(R.array.moviedisp));
        movie_cast = Arrays.asList(getResources().getStringArray(R.array.moviecast));
        adapter = new RecyclerAdapter(image,list,this,movie_cast,movie_disp);
        //adapter01 = new RecyclerAdapter(image);
        recycleview.setHasFixedSize(true);
        recycleview.setAdapter(adapter);
    }

    public void sendCancel(View view){
        //startActivity(new Intent(this,MainActivity.class));
         finish();
    }


}
