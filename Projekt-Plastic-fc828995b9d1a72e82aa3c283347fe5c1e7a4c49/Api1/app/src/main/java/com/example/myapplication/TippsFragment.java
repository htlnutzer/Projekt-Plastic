package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TippsFragment extends Fragment {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    Database db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        db = new Database(getActivity());

        View v = inflater.inflate(R.layout.fragment_tipps, null);
        String mostUsedProduct = db.getMostUsedProduct();

        tv2 = (TextView) v.findViewById(R.id.textView2);
        tv3 = (TextView) v.findViewById(R.id.textView3);

        tv2.setText(mostUsedProduct);

        switch(mostUsedProduct){
            case "Flasche":
                tv3.setText("Try to take a glass bottle with you. It is much better for the environment. If you are not able to take" +
                        " a glass bottle with you it is much better to a beverage that is " +
                        "stored in a glass bottle");
                break;
            case "Einkaufsack":
                tv3.setText("Nowadays you can get a fabric bag basically everywhere. It is also much more convenient to store one." +
                        " There are even fabric bags that can be stored in a wallet.  ");
                break;
            case "Tupperware":
                tv3.setText("Instead of buying tupperware to store food ore beverages, try to buy glass containers. They are " +
                        "available everywhere and are much better for the environment. They are also cheaper than plastic containers ");
                break;
            case "Folie":
                tv3.setText("When it comes to foil it is difficult to find something that can hold up to it" +
                        " but what you can try is reusing the foil so you don't have to take one every single day");
                break;
            case "Kaffee":
                tv3.setText("Most of the machines offer a carton cup instead of a plastic cup. This carton often times is more expensive" +
                        "but it is worth the money ");
                break;
            case "Chips":
                tv3.setText("Many of us love to eat crisps but they are not healthy for you and even unhealthier for the environment." +
                        "Try to step down your chips game to half of what you usually eat and you will clearly see the results");
                break;
        }

        return v;
    }
}





