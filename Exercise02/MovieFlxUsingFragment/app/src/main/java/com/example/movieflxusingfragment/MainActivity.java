package com.example.movieflxusingfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.placeholder)!= null)
        {
            if(savedInstanceState != null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Movie_List movieFragment = new Movie_List();
            fragmentTransaction.add(R.id.placeholder,movieFragment,null );
            fragmentTransaction.commit();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getApplicationContext(), "Portrate Mode",Toast.LENGTH_SHORT).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(getApplicationContext(), "Landscape Mode",Toast.LENGTH_SHORT).show();
        }
    }

}
