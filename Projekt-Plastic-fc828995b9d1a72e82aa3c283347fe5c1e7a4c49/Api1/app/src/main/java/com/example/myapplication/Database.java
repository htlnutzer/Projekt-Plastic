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
import java.util.ArrayList;
import java.util.Hashtable;

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
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd"); // New Pattern
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

    public Hashtable<String, String> getGramsOfWeek() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT Day, SUM(Weight) as Weight from  " + TABLE_NAME + " GROUP BY Day ORDER BY DAY DESC" ,null);
        Hashtable<String, String> weightPerDay = new Hashtable<String, String>();
        for(res.moveToFirst(); !res.isAfterLast(); res.moveToNext()){
            weightPerDay.put(res.getString(0), res.getString(1));
        }
        res.close();
        return weightPerDay;
    }

    public String getMostUsedProduct(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT Product, MAX(Count) As Anzahl FROM (SELECT Product, COUNT(Product) AS Count FROM PLASTIC_USAGE GROUP BY Product ) AS CountTable", null);
        res.moveToFirst();
        String product = res.getString(0);
        return product;
    }
}
