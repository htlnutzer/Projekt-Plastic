package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "plastic.db";
    public static final String TABLE_NAME = "plastic_usage";
    public static final String Product = "PRODUCT";
    public static final String ProductWeight = "WEIGHT";
    public static final String Date = "DAY";
    //public static final Timestamp Date = Timestamp.valueOf();


    public Database(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    public void resetDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("create table if not exists " + TABLE_NAME + " (ID integer primary key autoincrement, PRODUCT TEXT, WEIGHT Text, DAY text)");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + TABLE_NAME + " (ID integer primary key autoincrement, PRODUCT TEXT, WEIGHT Text, DAY text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String product, String productWeight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        java.util.Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); // New Pattern
        String heute = sdf1.format(today);


        contentValues.put(Product, product);
        contentValues.put(ProductWeight, productWeight);
        contentValues.put(Date, heute);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME, null);
        return res;
    }

   /** public Cursor getWeightPerDay(){
        SQLiteDatabase db = this.getWritableDatabase();

        java.util.Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); // New Pattern
        String heute = sdf1.format(today);

        Cursor res = db.rawQuery("Select " + ProductWeight + "from " + TABLE_NAME + "where DAY = " + today);
        return res;
   **/ }

