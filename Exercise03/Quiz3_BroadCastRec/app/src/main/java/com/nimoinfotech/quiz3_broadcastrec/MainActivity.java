package com.nimoinfotech.quiz3_broadcastrec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // broadcast a custom intent.

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.nimoinfotech.CUSTOM_INTENT"); sendBroadcast(intent);

    }
}
