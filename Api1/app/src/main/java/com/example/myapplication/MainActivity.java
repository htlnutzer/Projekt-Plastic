package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        db = new Database(this);



    /**   btn2 = (ImageButton) findViewById(R.id.btn2);

     btn2.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    openDifBottles();
    }
    });
     btn1 = (ImageButton) findViewById(R.id.btn1);
     btn3 = (ImageButton) findViewById(R.id.btn3);
     btn4 = (ImageButton) findViewById(R.id.btn4);
     btn5 = (ImageButton) findViewById(R.id.btn5);
     btn6 = (ImageButton) findViewById(R.id.btn6);

     btn1.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
    });

     btn2.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
    });

     btn3.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
    });

     btn4.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
    });

     btn5.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
    });

     btn6.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
    });
     **/
}


  //  public void openDifBottles(){
  //      Intent intent = new Intent(this, welche_flasche);
  //      startActivity(intent);
  //  }


    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch(item.getItemId()){
            case R.id.navigation_products:
                fragment = new ProductFragment();
                break;

            case R.id.navigation_stats:
                fragment = new StatsFragment();
                break;

            case R.id.navigation_tipps:
                fragment = new TippsFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
