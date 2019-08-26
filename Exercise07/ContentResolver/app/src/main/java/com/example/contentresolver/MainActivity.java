package com.example.contentresolver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText movie_name,movie_cast,movie_disp,editText_id;
    Button add_data, show_movie,update_movie,delete_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_name = (EditText) findViewById(R.id.edittext_name);
        movie_cast = (EditText) findViewById(R.id.editText_cast);
        movie_disp = (EditText) findViewById(R.id.edittext_disp);
        editText_id = (EditText) findViewById(R.id.editText_id);

        add_data = (Button) findViewById(R.id.add_movie);
        show_movie = (Button) findViewById(R.id.show_movie);
        update_movie = (Button) findViewById(R.id.update_movie);
        delete_movie = (Button) findViewById(R.id.delete_movie);

        Show_MovieData();
    }

    public void ShowData(String tit, String mes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tit);
        builder.setMessage(mes);
        builder.show();

    }

    public void Show_MovieData(){
        show_movie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse("content://com.mycontentprovider.PROVIDER");
                        String[] projection = null;
                        String selection = null;
                        String[] selectionArgs = null;
                        String sortOrderl = null;
                        ContentResolver resolver = getContentResolver();
                        Cursor cursor = resolver.query(uri,projection,selection,selectionArgs,sortOrderl);
                        if(cursor.getCount() == 0) {
                            ShowData("ERROR", "NO movie data found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(cursor.moveToNext()){
                            buffer.append("movie_id :"+ cursor.getString(0)+ "\n");
                            buffer.append("movie_name :"+ cursor.getString(1)+ "\n");
                            buffer.append("cast_name :"+ cursor.getString(2)+ "\n");
                            buffer.append("movie_disp :"+ cursor.getString(3)+ "\n\n");

                        }
                        ShowData("Movie Data", buffer.toString());
                    }
                }
        );
    }

}
