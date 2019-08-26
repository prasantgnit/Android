package com.example.sqldatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText movie_name,movie_cast,movie_disp,editText_id;
    Button add_data, show_movie,update_movie,delete_movie;
    BackgroundTask backgroundTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);
       // backgroundTask = new BackgroundTask(this);

        movie_name = (EditText) findViewById(R.id.edittext_name);
        movie_cast = (EditText) findViewById(R.id.editText_cast);
        movie_disp = (EditText) findViewById(R.id.edittext_disp);
        editText_id = (EditText) findViewById(R.id.editText_id);

        add_data = (Button) findViewById(R.id.add_movie);
        show_movie = (Button) findViewById(R.id.show_movie);
        update_movie = (Button) findViewById(R.id.update_movie);
        delete_movie = (Button) findViewById(R.id.delete_movie);
        Add_Data();
        Show_MovieData();
        UpdateData();
        DeleteData();

    }

    public void DeleteData(){
        delete_movie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer del = mydb.DeleteData(editText_id.getText().toString());
                    }
                }
        );
    }

    public void UpdateData(){
        update_movie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                                boolean isupdated = mydb.UpdateData(editText_id.getText().toString(),movie_name.getText().toString(),movie_cast.getText().toString(),
                                        movie_cast.getText().toString());
                                Toast.makeText(MainActivity.this,"Movie updated", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void Add_Data(){
        add_data.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                     /*   boolean isinserted = mydb.insertDB(movie_name.getText().toString(),movie_cast.getText().toString(),
                                movie_cast.getText().toString());
                        if(isinserted)
                            Toast.makeText(MainActivity.this,"Movie inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Movie not inserted", Toast.LENGTH_SHORT).show();
                        */
                     //Below code added for async task
                        backgroundTask = new BackgroundTask(view.getContext());
                        backgroundTask.execute("Add_Data",movie_name.getText().toString(),movie_cast.getText().toString(),
                                movie_cast.getText().toString());
                    }
                }
        );
    }

    public void Show_MovieData(){
        show_movie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = mydb.getMovieData();
                        if(res.getCount() == 0) {
                            ShowData("ERROR", "NO movie data found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("movie_id :"+ res.getString(0)+ "\n");
                            buffer.append("movie_name :"+ res.getString(1)+ "\n");
                            buffer.append("cast_name :"+ res.getString(2)+ "\n");
                            buffer.append("movie_disp :"+ res.getString(3)+ "\n\n");

                        }
                        ShowData("Movie Data", buffer.toString());
                    }
                }
        );
    }

    public void ShowData(String tit, String mes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tit);
        builder.setMessage(mes);
        builder.show();

    }
}
