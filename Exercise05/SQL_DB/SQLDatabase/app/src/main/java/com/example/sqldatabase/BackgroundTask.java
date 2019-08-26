package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;

public class BackgroundTask extends AsyncTask<String, Void, Void> {

    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected Void doInBackground(String... voids) {
        return null;
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
