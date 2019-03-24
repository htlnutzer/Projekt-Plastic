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
                tv3.setText("Try to take a glass Bottle with you");
            case "Einkaufsack":
                tv3.setText("Try to buy a stoff bag and take it with you");
        }

       // if(db.getMostUsedProduct().equals("bag")) {
       //     tv3.setText("Try bying a stoff Sack it is cheeper and you can take it with you all the time" );
       // }

        return v;
    }
}





