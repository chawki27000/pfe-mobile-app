package com.dev.chawki.alpha;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;


public class DashFragment extends Fragment {


    public DashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dash, container, false);

        // Setup charts
        // in this example, a LineChart is initialized from xml
        LineChart lineChart = (LineChart) view.findViewById(R.id.line_chart);

        LineDataSet dataSet = new LineDataSet(lineChartData(10), "Label");

        LineData lineData = new LineData(dataSet);

        lineChart.setData(lineData);
        lineChart.invalidate(); // refresh


        // Bar chart
        BarChart barChart = (BarChart) view.findViewById(R.id.bar_chart);

        BarDataSet barDataSet = new BarDataSet(barChartData(10), "Medical");

        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);
        barChart.invalidate(); // refresh

        // Radar Chart
        RadarChart radarChart = (RadarChart) view.findViewById(R.id.radar_chart);
        RadarDataSet radarDataSet = new RadarDataSet(radarChartData(10), "Medical");
        RadarData radarData = new RadarData(radarDataSet);
        radarChart.setData(radarData);
        radarChart.invalidate();

        // Pie Chart
        PieChart pieChart = (PieChart) view.findViewById(R.id.pie_chart);
        PieDataSet pieDataSet = new PieDataSet(pieChartData(10), "Medical");
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        return view;
    }

    private List<PieEntry> pieChartData(int count) {
        ArrayList<PieEntry> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(new PieEntry(i));
        }
        return data;
    }

    private ArrayList<RadarEntry> radarChartData(int count) {
        ArrayList<RadarEntry> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(new RadarEntry(i));
        }
        return data;
    }

    private ArrayList<Entry> lineChartData(int count) {
        ArrayList<Entry> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(new Entry(i, i));
        }
        return data;
    }

    private ArrayList<BarEntry> barChartData(int count) {
        ArrayList<BarEntry> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(new BarEntry(i, i));
        }
        return data;
    }

}
