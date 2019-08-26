package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "movie.db";
    public static final String TABLE_NAME = "movie_table";

    public static final String COL_1 = "movie_id";
    public static final String COL_2 = "movie_name";
    public static final String COL_3 = "cast_name";
    public static final String COL_4 = "movie_disp";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (movie_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "movie_name TEXT, cast_name TEXT, movie_disp TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertDB(String name, String cast, String disp) {
        SQLiteDatabase sqLiteDatabase  = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,cast);
        contentValues.put(COL_3,disp);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getMovieData() {
        SQLiteDatabase sqLiteDatabase  = this.getReadableDatabase();
        Cursor result = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        return result;

    }

    public boolean UpdateData(String id, String name, String cast, String disp){
        SQLiteDatabase sqLiteDatabase  = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,cast);
        contentValues.put(COL_3,disp);

        sqLiteDatabase.update(TABLE_NAME, contentValues, "movie_id = ?", new String[]{id});
        return true;
    }

    public int DeleteData(String id){
        SQLiteDatabase sqLiteDatabase  = this.getReadableDatabase();
       return sqLiteDatabase.delete(TABLE_NAME, "movie_id = ?", new String[]{id});

    }
}
