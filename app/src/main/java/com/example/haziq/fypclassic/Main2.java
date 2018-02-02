package com.example.haziq.fypclassic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button monitor = findViewById(R.id.monitor);
        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2.this, Monitor.class);
                startActivity(i);
            }
        });

        Button exercise = findViewById(R.id.exercise);
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2.this, Exercise.class);
                startActivity(i);
            }
        });

        Button points = findViewById(R.id.points);
        points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2.this, TotalPoints.class);
                startActivity(i);
            }
        });
    }
}
