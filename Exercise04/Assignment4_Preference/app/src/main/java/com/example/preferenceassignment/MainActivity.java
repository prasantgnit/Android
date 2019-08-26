package com.example.preferenceassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<String> menuList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] menuList = {"General","Notification","Data & Sync","Sound"};

        listView = findViewById(R.id.menus);
        ListAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menuList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String retdata;
        retdata = (String) adapterView.getItemAtPosition(i);

        switch(retdata){
            case "General":Intent intentGeneral=new Intent(MainActivity.this,General.class);
                    startActivity(intentGeneral);
                    break;
            case "Notification":Intent intentNotification=new Intent(MainActivity.this,Notification.class);
                    startActivity(intentNotification);
                    break;
            case "Data & Sync" : Intent intentSync=new Intent(MainActivity.this,Sync.class);
                    startActivity(intentSync);
                    break;
            case "Sound" : Intent intentSound=new Intent(MainActivity.this,Sound.class);
                    startActivity(intentSound);
                    break;
        }
    }
}
