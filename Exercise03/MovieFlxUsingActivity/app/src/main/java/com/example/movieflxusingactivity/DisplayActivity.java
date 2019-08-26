package com.example.movieflxusingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    ImageView imageview;
    TextView textView;
    TextView textViewdisp;
    TextView textViewcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        imageview = findViewById(R.id.display);
        textView = findViewById(R.id.nameview);
        textViewcast = findViewById(R.id.castView);
        textViewdisp = findViewById(R.id.dispView);
        imageview.setImageResource(getIntent().getIntExtra("Image_id",00));
        textView.setText(getIntent().getStringExtra("Name_id"));
        textViewcast.setText(getIntent().getStringExtra("Movie_Cast_id"));
        textViewdisp.setText(getIntent().getStringExtra("Movie_Disp_id"));
    }
}
