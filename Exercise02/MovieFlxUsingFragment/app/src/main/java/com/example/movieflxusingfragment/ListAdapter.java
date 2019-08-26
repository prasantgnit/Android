package com.example.movieflxusingfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ListAdapter extends RecyclerView.Adapter {
    public View view1;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Data.movie_name.length;
    }
    public ListAdapter(View View){
        view1 = View;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView testview;
        public FragmentManager fragmentManager;
        View BView;
        private TextView testviewcast;
        private TextView testviewdisp;
        private TextView testviewname;
        private ImageView imageviewphoto;
        private ImageView imageview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            BView = itemView;
            testview = (TextView)itemView.findViewById(R.id.movie_name);
            imageview = (ImageView)itemView.findViewById(R.id.photo);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position)
        {
            testview.setText(Data.movie_name[position]);
            //testviewcast.setText(Data.movie_cast[position]);
            //testviewdisp.setText(Data.movie_disp[position]);
            imageview.setImageResource(Data.image[position]);
        }
        @Override
        public void onClick(View view)
        {
            LinearLayout layout =(LinearLayout) view1.findViewById(R.id.linearlayoumovie);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            layout.setLayoutParams(params);
            LinearLayout layoutlist =(LinearLayout) view1.findViewById(R.id.linearlayoulist);
            LinearLayout.LayoutParams paramslist = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            paramslist.weight = 1.0f;
            layoutlist.setLayoutParams(paramslist);
            testviewcast = (TextView)view1.findViewById(R.id.cast);
            testviewdisp = (TextView)view1.findViewById(R.id.disp);
            testviewname = (TextView)view1.findViewById(R.id.name);
            imageviewphoto = (ImageView)view1.findViewById(R.id.image);

            testviewname.setText(Data.movie_name[getAdapterPosition()]);
            testviewcast.setText(Data.movie_cast[getAdapterPosition()]);
            testviewdisp.setText(Data.movie_disp[getAdapterPosition()]);
            imageviewphoto.setImageResource(Data.image[getAdapterPosition()]);
            //MainActivity.fragmentManager.beginTransaction().replace(R.id.recyclerview,new Movie_view()).addToBackStack(null).commit();
        }

    }
}
