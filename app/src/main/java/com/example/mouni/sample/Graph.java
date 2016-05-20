package com.example.mouni.sample;

/**
 * Created by MOUNI on 19-Mar-16.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.util.ArrayList;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import android.os.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by MOUNI on 18-Mar-16.
 */
public class Graph extends Activity {

    ArrayList<String>  items_value;
    ArrayList<String>  items_time;
     ArrayList<Entry> entries = new ArrayList<>();
  //  LineChart lineChart;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.graph);
        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        Intent i = getIntent();
        items_value = i.getStringArrayListExtra("items_value");
      items_time = i.getStringArrayListExtra("items_time");
        float f[]=new float[5];
                for(int j=0;j<5;j++)
                {
                    f[j]= Float.parseFloat(items_value.get(j));
                    entries.add(new Entry(f[j], j));
                }






                LineDataSet dataset = new LineDataSet(entries, "");


                //ArrayList<String> labels = new ArrayList<String>();


        LineData data = new LineData(items_time, dataset);

        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //

                dataset.setDrawCubic(true);

                dataset.setDrawFilled(true);


                lineChart.setData(data);

                lineChart.animateY(5000);

/*        for(int k=0;k<5;k++) {
    if (Integer.parseInt(items_value.get(k))>9)
    {
        new AlertDialog.Builder(this).setTitle("Argh").setMessage("Watch out!").setNeutralButton("Close", null).show();
        break;
    }
}*/
    }

    }



