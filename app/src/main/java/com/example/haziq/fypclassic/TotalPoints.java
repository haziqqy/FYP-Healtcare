package com.example.haziq.fypclassic;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class TotalPoints extends Activity {
    private static final String TAG = "TotalPointsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_points);

        int exercise1points;

        if (PointStorage.getExercise1Points() != 0){
            exercise1points = PointStorage.getExercise1Points();
        } else{
            exercise1points = 0;
        }

        TextView ptearnedtxt = findViewById(R.id.ptearned);
        TextView pttotaltxt = findViewById(R.id.pttotal);

        Log.d(TAG, "Exercise 1 points = " + exercise1points);

        int pointsTotal;

        SharedPreferences settings = getSharedPreferences("Points Store", Context.MODE_PRIVATE);
        pointsTotal = settings.getInt("TOTAL_POINTS", 0);

        if(exercise1points != 0){

            pointsTotal = pointsTotal + exercise1points ;
            SharedPreferences.Editor editor  = settings.edit();
            editor.putInt("TOTAL_POINTS", pointsTotal);
            editor.commit();

            String s=Integer.toString(exercise1points);
            String s1=Integer.toString(pointsTotal);
            ptearnedtxt.setText(s);
            pttotaltxt.setText(s1);
            PointStorage.setExercise1Points(0);

        }
        else{

            String s=Integer.toString(exercise1points);
            String s1=Integer.toString(pointsTotal);
            ptearnedtxt.setText(s);
            pttotaltxt.setText(s1);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}