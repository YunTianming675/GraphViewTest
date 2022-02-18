package com.example.graphview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static GraphView graphView;
    private static AppCompatButton mainCompatButton1;
    private static AppCompatButton mainCompatButton2;

    private int lastXValue = 3;

    private final LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
            new DataPoint(1, 2),
            new DataPoint(2, 2),
            new DataPoint(3, 3)
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAllClickListener();
        graphViewTest();
    }

    private void setAllClickListener() {
        mainCompatButton1 = findViewById(R.id.main_compat_button_1);
        mainCompatButton2 = findViewById(R.id.main_compat_button_2);

        mainCompatButton1.setOnClickListener(view -> {
            series.resetData(generateData());
            lastXValue = 10;
        });

        mainCompatButton2.setOnClickListener(view -> {
            lastXValue++;
            series.appendData(new DataPoint(lastXValue, Math.sin(lastXValue)), true, 40);
            graphView.onDataChanged(true, true); // 调用此方法刷新
        });
    }

    private void graphViewTest() {
        graphView = findViewById(R.id.graph_view);
        graphView.addSeries(series);
    }

    private DataPoint[] generateData() {
        DataPoint[] dataPoints = new DataPoint[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            double f = random.nextDouble()*0.15+0.3;
            double y = Math.sin(i*f+2) + random.nextDouble()*0.3;
            DataPoint dataPoint = new DataPoint(i, y);
            dataPoints[i] = dataPoint;
        }
        lastXValue = 10;

        return  dataPoints;
    }
}