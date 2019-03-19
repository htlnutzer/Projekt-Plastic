package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProductFragment extends Fragment {
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private Button displayBtn;
    Database db;




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        db = new Database(getActivity());
        View v = inflater.inflate(R.layout.fragment_product, null);

        btn1 = (ImageButton) v.findViewById(R.id.btn1);
        btn2 = (ImageButton) v.findViewById(R.id.btn2);
        btn3 = (ImageButton) v.findViewById(R.id.btn3);
        btn4 = (ImageButton) v.findViewById(R.id.btn4);
        btn5 = (ImageButton) v.findViewById(R.id.btn5);
        btn6 = (ImageButton) v.findViewById(R.id.btn6);
        displayBtn = (Button) v.findViewById(R.id.DisplayBtn);
        db.resetDatabase();
        AddData();
        viewALL();
        return v;

    }

    public void AddData(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted = db.insertData("Tupperware", "100");

               if(isInserted == true) {
                   Toast.makeText(getContext(), " Tupperware wurde hinzugefügt", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getContext(), " Tupperware konnte nicht hinzugefügt werden", Toast.LENGTH_SHORT).show();
               }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData("Flasche", "10");

                if(isInserted == true) {
                    Toast.makeText(getContext(), "Wurde hinzugefügt", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Konnte nicht hinzugefügt werden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData("Folie", "30");

                if(isInserted == true) {
                    Toast.makeText(getContext(), "Folie wurde hinzugefügt", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Folie konnte nicht hinzugefügt werden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData("Einkaufsack", "10");

                if(isInserted == true) {
                    Toast.makeText(getContext(), "Einkaufsack wurde hinzugefügt", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Einkaufsack konnte nicht hinzugefügt werden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData("Kaffee", "10");

                if(isInserted == true) {
                    Toast.makeText(getContext(), "Kaffee wurde hinzugefügt", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Kaffee konnte nicht hinzugefügt werden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData("Chips", "10");

                if(isInserted == true) {
                    Toast.makeText(getContext(), "Chips Packung wurde hinzugefügt", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Chips Packung konnte nicht hinzugefügt werden", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void viewALL(){
        displayBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();
                if(res.getCount() == 0){
                    showMessage("Error", "nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); // New Pattern
                    java.util.Date date;
                    try {
                        date = sdf1.parse(res.getString(3)); // Returns a Date format object with the pattern
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    buffer.append("Product: "+ res.getString(1) + "\n");
                    buffer.append("Product Weight: "+ res.getString(2) + "\n");
                    buffer.append("Datum "+ res.getString(3) + "\n\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}