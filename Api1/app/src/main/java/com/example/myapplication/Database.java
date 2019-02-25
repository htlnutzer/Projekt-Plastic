package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Timestamp;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "plastic.db";
    public static final String TABLE_NAME = "plastic_usage";
    public static final String Product = "PRODUCT";
    public static final String ProductWeight = "WEIGHT";
    public static final String Date = "DAY";


    public Database(Context context) {
        super(context,DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (DAY DATE PRIMARY KEY, PRODUCT TEXT, WEIGHT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
