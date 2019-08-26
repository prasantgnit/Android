package com.example.movieflxusingfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Movie_List extends Fragment {

public LinearLayout layout;
    LinearLayout layoutmovie;
    LinearLayout layoutlist;
    public Movie_List() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie__list, container, false);

        RecyclerView recycleview = (RecyclerView) view.findViewById(R.id.recyclerview);
        ListAdapter listAdapter = new ListAdapter(view);
        recycleview.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycleview.setLayoutManager(layoutManager);
        layout  = (LinearLayout)view.findViewById(R.id.linearlayoubase);
        layoutmovie  = (LinearLayout)view.findViewById(R.id.linearlayoumovie);
        layoutlist  = (LinearLayout)view.findViewById(R.id.linearlayoulist);
        return view;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            layout.setOrientation(LinearLayout.VERTICAL);
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            layout.setOrientation(LinearLayout.HORIZONTAL);
        }
    }

    public boolean onBackPressed() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 0.0f;
        layout.setLayoutParams(params);
        LinearLayout.LayoutParams paramslist = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramslist.weight = 1.0f;
        layoutlist.setLayoutParams(paramslist);
        return false;
    }
}
