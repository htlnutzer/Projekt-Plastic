package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StatsFragment extends Fragment {
    BarChart barChart;
    ArrayList<String> dates;
    Random random;
    ArrayList<BarEntry> barEntries;
    Database db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stats, null);

        barChart = (BarChart) v.findViewById(R.id.bar_Chart);

        db = new Database(getActivity());

        createRandomBarGraph();


        return v;

    }

    public void createRandomBarGraph(){

        Hashtable<String, String> hashtable = db.getGramsOfWeek();
        ArrayList<BarEntry> xVal = new ArrayList<>();
        int counter = 0;
        for(Map.Entry<String, String> entry: hashtable.entrySet() ){
            xVal.add(new BarEntry(counter, Float.parseFloat(entry.getValue())));
            counter++;
        }



        BarDataSet barDataSet = new BarDataSet(xVal, "gramms");


        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        Description description = new Description();
        description.setText("my first bar graph");
        barChart.setDescription(description);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new DateValueFormater());
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

    }



    public class DateValueFormater implements IAxisValueFormatter {

        Hashtable<String, String> data = new Hashtable<>();

        Database db= new Database(getActivity());

        public DateValueFormater(){
            data = db.getGramsOfWeek();
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            int index = (int) value;
            String[] values = data.keySet().toArray(new String[0]);
           if(index == -1){
               index = 0;
           }else if(index == values.length){
               index--;
           }
            return values[index];
        }
    }


}












//first BarChar Try

  /**  BarDataSet barDataSet1 = new BarDataSet(dataValues1(), "DataSet1");

    BarData barData = new BarData();
        barData.addDataSet(barDataSet1);
                barChart.setData(barData);
                barChart.invalidate();

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



   try {
   Date date1 = simpleDateFormat.parse(Date1);
   Date date2 = simpleDateFormat.parse(Date2);

   Calendar mDate1 = Calendar.getInstance();
   Calendar mDate2 = Calendar.getInstance();
   mDate1.clear();
   mDate2.clear();

   mDate1.setTime(date1);
   mDate2.setTime(date2);

   dates = new ArrayList<>();
   dates = getList(mDate1,mDate2);

   barEntries = new ArrayList<>();
   float max = 0f;
   float value = 0f;
   random = new Random();
   for(int j = 0; j< dates.size();j++){
   max = 50f;
   value = random.nextFloat()*max;
   barEntries.add(new BarEntry(value,j));
   }

   }catch(ParseException e){
   e.printStackTrace();
   }


   public ArrayList<String> getList(Calendar startDate, Calendar endDate){
   ArrayList<String> list = new ArrayList<String>();
   while(startDate.compareTo(endDate)<=0){
   list.add(getDate(startDate));
   startDate.add(Calendar.DAY_OF_MONTH,1);
   }
   return list;
   }

   public String getDate(Calendar cld){
   String curDate = cld.get(Calendar.YEAR) + "/" + (cld.get(Calendar.MONTH) + 1) + "/"
   +cld.get(Calendar.DAY_OF_MONTH);
   try{
   Date date = new SimpleDateFormat("yyyy/MM/dd").parse(curDate);
   curDate =  new SimpleDateFormat("yyy/MM/dd").format(date);
   }catch(ParseException e){
   e.printStackTrace();
   }
   return curDate;
   }
   **/