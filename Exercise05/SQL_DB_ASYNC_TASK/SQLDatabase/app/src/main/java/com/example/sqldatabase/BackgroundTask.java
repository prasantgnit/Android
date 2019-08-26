package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context ctx;
    DatabaseHelper mydb;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
        mydb = new DatabaseHelper(this.ctx);
    }


    @Override
    protected void onPostExecute(String  res) {
        Toast.makeText(ctx,res,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];

        if(method.equals("Add_Data")){
            boolean isinserted = mydb.insertDB(params[1].toString(),params[2].toString(),params[3].toString());
        }
        return "Movie Added";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
