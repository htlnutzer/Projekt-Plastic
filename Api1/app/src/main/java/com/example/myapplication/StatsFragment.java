package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class StatsFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, null);

        return v;

    }

}






















     /**   barChart = (BarChart) v.findViewById(R.id.barChart);

        BarDataSet barDataSet1 = new BarDataSet(dataValues1(), "DataSet1");

        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);
        barChart.setData(barData);
        barChart.invalidate();


        // barChartWeekView("01-03-2019", "18-04-2019");
            return v;
    }

    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> dataVals = new ArrayList<BarEntry>();
        dataVals.add(new BarEntry(0,3));
        dataVals.add(new BarEntry(1,4));
        dataVals.add(new BarEntry(3,6));
        dataVals.add(new BarEntry(4,10));
        return dataVals;
    }




















        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(88f, 1));
        barEntries.add(new BarEntry(66, 2));
        barEntries.add(new BarEntry(12, 3));
        barEntries.add(new BarEntry(19, 4));
        barEntries.add(new BarEntry(91, 5));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("April");
        theDates.add("May");
        theDates.add("June");
        theDates.add("July");
        theDates.add("August");
        theDates.add("September");

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.9f);




        Description description = new Description();
        description.setText("Growth Rate");
        barChart.setDescription(description);
        barChart.invalidate();



    public void barChartWeekView(String Date1, String Date2){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        try {
            Date date1 = simpleDateFormat.parse(Date1);
            Date date2 = simpleDateFormat.parse(Date2);

            Calendar mDate1 = Calendar.getInstance();
            Calendar mDate2 = Calendar.getInstance();
            mDate1.clear();
            mDate2.clear();

            mDate1.setTime(date1);
            mDate1.setTime(date2);

            dates = new ArrayList<>();
            dates = getList(mDate1, mDate2);

            weightEntries = new ArrayList<>();
            Random random = new Random();
            float max = 0f;
            float value = 0f;
            for(int j = 0; j < dates.size(); j++){
                max = 100f;
                value = random.nextFloat()*max;
                weightEntries.add(new BarEntry(value,j));
            }

        }catch (ParseException e){
            e.printStackTrace();


        }

        BarDataSet barDataSet =  new BarDataSet(weightEntries, "Dates");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

    }

    public ArrayList<String> getList(Calendar startDate, Calendar endDate){
        ArrayList<String> list = new ArrayList<>();
        while(startDate.compareTo(endDate) <= 0){
            list.add(getDate(startDate));
            startDate.add(Calendar.DAY_OF_MONTH,1);
        }
        return list;
    }

    public String getDate(Calendar cld){
        String curDate = cld.get(Calendar.DAY_OF_MONTH) + "-" + (cld.get(Calendar.MONTH) + 1) + "-"
                    + cld.get(Calendar.YEAR);
        try {
              Date date = new SimpleDateFormat("dd-MM-yyyy").parse(curDate);
              curDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return curDate;
    }**/



