package com.example.graphview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private static GraphView graphView;
    private static AppCompatButton mainCompatButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAllClineListener();
        graphViewTest();
    }

    private void setAllClineListener() {
        mainCompatButton1 = findViewById(R.id.main_compat_button_1);
        mainCompatButton1.setOnClickListener(view -> {
            graphView.removeAllSeries();
        });
    }

    private void graphViewTest() {
        graphView = findViewById(R.id.graph_view);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        graphView.addSeries(series);
    }
}