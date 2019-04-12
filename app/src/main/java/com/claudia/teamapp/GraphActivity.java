package com.claudia.teamapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;


public class GraphActivity extends AppCompatActivity {

    RadarChart RadarChart;
    RadarData radarData;
    RadarDataSet radarDataSet;
    ArrayList radarEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        RadarChart = findViewById(R.id.RadarChart);
        getEntries();
        radarDataSet = new RadarDataSet(radarEntries, "");
        radarData = new RadarData(radarDataSet);
        RadarChart.setData(radarData);
        radarDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        radarDataSet.setValueTextColor(Color.BLACK);
        radarDataSet.setValueTextSize(18f);
    }

    private void getEntries() {
        radarEntries = new ArrayList<>();
        radarEntries.add(new RadarEntry(0, 0.21f));
        radarEntries.add(new RadarEntry(1, 0.12f));
        radarEntries.add(new RadarEntry(2, 0.20f));
        radarEntries.add(new RadarEntry(2, 0.52f));
        radarEntries.add(new RadarEntry(3, 0.29f));
        radarEntries.add(new RadarEntry(4, 0.62f));
    }
}
