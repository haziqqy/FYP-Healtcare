package com.example.haziq.fypclassic;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercise1 extends Activity {
    private static final String TAG = "Exercise1";

    public int points = 0;

    StringBuilder messages;
    private StringBuilder recDataString = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        final TextView ex1 = findViewById(R.id.ex1timer);

        messages = new StringBuilder();
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));

        Button tv1 = findViewById(R.id.startpt1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ex1.setTextColor(Color.RED);
                ex1.setBackgroundColor(Color.TRANSPARENT);

                new CountDownTimer(16000, 1000) {

                    int seconds = 0;
                    public void onTick(long millisUntilFinished) {
                        seconds++;
                        points = points +2;
                        ex1.setText(seconds + " s" );

                    }

                    public void onFinish() {
                        ex1.setText("Done!");
                        ex1.setTextColor(Color.BLACK);
                        ex1.setBackgroundColor(Color.GREEN);
                        Log.d(TAG, "Exercise 1 Points = " + points);

                        PointStorage.setExercise1Points(points);

                    }
                }.start();

            }
        });
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent){
            String text = intent.getStringExtra("themessage");
            String readMessage = (text);                                                            // msg.arg1 = bytes from connect thread
            recDataString.append(readMessage);                                                      //keep appending to string until ~
            int endOfLineIndex = recDataString.indexOf("%");
            if (endOfLineIndex > 0) {                                                               // make sure there data before ~

                if (recDataString.charAt(0) == '#')                                                 //if it starts with # we know it is what we are looking for
                {
                    String roll = recDataString.substring(32, 36);
                    Double rolldata = new Double(roll);
                    rolldata = rolldata*10;
                    int r0 = rolldata.intValue();


                    String pitch = recDataString.substring(37,41);
                    Double pitchdata = new Double(pitch);
                    pitchdata = pitchdata * 10;
                    int p0 = pitchdata.intValue();

                    Log.d(TAG, "Roll Data: " + r0);
                    Log.d(TAG, "Pitch Data: " + p0);
                }
                recDataString.delete(0, recDataString.length());
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }


}
