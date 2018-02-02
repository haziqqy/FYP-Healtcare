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
import android.widget.TextView;

public class Monitor extends Activity {

    String incomingMessages;
    TextView sensorView0, sensorView1, sensorView2, sensorView3, sensorView4, sensorView5, leftRight, upDown;
    StringBuilder messages;
    private StringBuilder recDataString = new StringBuilder();


    int s00, s11, s22, s33, s44, s55;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        sensorView0 =  findViewById(R.id.sensorView0);
        sensorView1 =  findViewById(R.id.sensorView1);
        sensorView2 =  findViewById(R.id.sensorView2);
        sensorView3 =  findViewById(R.id.sensorView3);
        sensorView4 =  findViewById(R.id.sensorView4);
        sensorView5 =  findViewById(R.id.sensorView5);
        leftRight = findViewById(R.id.leftRight);
        upDown = findViewById(R.id.upDown);

        messages = new StringBuilder();



                new CountDownTimer(6000, 1000) {
                    int seconds = 0 ;
                    int minutes = 0;
                    TextView sitTimer = findViewById(R.id.sitTimer);

                    @Override
                    public void onTick(long l) {
                        seconds++;
                        if (seconds == 60){
                            minutes++;
                        }
                        sitTimer.setText(minutes + ":" + seconds);
                    }

                    @Override
                    public void onFinish() {
                        sitTimer.setText("Please Move Around");

                    }
                };

        //}else {
        //    TextView sitTimer = findViewById(R.id.sitTimer);
        //    int seconds = 0 ;
        //    int minutes = 0;
        //    sitTimer.setText(minutes + ":" + seconds);
        //}


        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));

    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent){
            String text = intent.getStringExtra("themessage");
            String readMessage = (text);                                                            // msg.arg1 = bytes from connect thread
            recDataString.append(readMessage);                                                      //keep appending to string until ~
            int endOfLineIndex = recDataString.indexOf("~");                                        // determine the end-of-line
            if (endOfLineIndex > 0) {                                                               // make sure there's data before ~

                if (recDataString.charAt(0) == '#')                                                 //if it starts with # we know it is what we are looking for
                {
                    String sensor0 = recDataString.substring(1, 5);                                 //get sensor value from string between indices 1-5
                    Double s0 = new Double(sensor0);
                    s0 = s0 *2.5;
                    s00 = s0.intValue();
                    String s000 = Integer.toString(s00);
                    if(s00 < 2) {                                                                   //update the textviews with sensor values
                        sensorView0.setBackgroundColor(Color.RED);
                        sensorView0.setText(s000);
                    }else if(s00 > 2){
                        sensorView0.setBackgroundColor(Color.GREEN);
                        sensorView0.setText(s000);
                    }

                    String sensor1 = recDataString.substring(6, 10);                                //same again...
                    Double s1 = new Double(sensor1);
                    s1 = s1 *2.5;
                    s11 = s1.intValue();
                    String s111 = Integer.toString(s11);
                    if(s11 < 2) {                                                                   //update the textviews with sensor values
                        sensorView1.setBackgroundColor(Color.RED);
                        sensorView1.setText(s111);
                    }else if(s11 > 2){
                        sensorView1.setBackgroundColor(Color.GREEN);
                        sensorView1.setText(s111);
                    }

                    String sensor2 = recDataString.substring(11, 15);
                    Double s2 = new Double(sensor2);
                    s2 = s2 *2.5;
                    s22 = s2.intValue();
                    String s222 = Integer.toString(s22);
                    if(s22 < 2) {                                                                   //update the textviews with sensor values
                        sensorView2.setBackgroundColor(Color.RED);
                        sensorView2.setText(s222);
                    }else if(s22 > 2){
                        sensorView2.setBackgroundColor(Color.GREEN);
                        sensorView2.setText(s222);
                    }

                    String sensor3 = recDataString.substring(16, 20);
                    Double s3 = new Double(sensor3);
                    s3 = s3 *2.5;
                    s33 = s3.intValue();
                    String s333 = Integer.toString(s33);
                    if(s33 < 2) {                                                                   //update the textviews with sensor values
                        sensorView3.setBackgroundColor(Color.RED);
                        sensorView3.setText(s333);
                    }else if(s33 > 2){
                        sensorView3.setBackgroundColor(Color.GREEN);
                        sensorView3.setText(s333);
                    }

                    String sensor4 = recDataString.substring(21, 25);
                    Double s4 = new Double(sensor4);
                    s4 = s4 *2.5;
                    s44 = s4.intValue();
                    String s444 = Integer.toString(s44);
                    if(s44 < 2) {                                                                   //update the textviews with sensor values
                        sensorView4.setBackgroundColor(Color.RED);
                        sensorView4.setText(s444);
                    }else if(s44 > 2){
                        sensorView4.setBackgroundColor(Color.GREEN);
                        sensorView4.setText(s444);
                    }

                    String sensor5 = recDataString.substring(26, 30);
                    Double s5 = new Double(sensor5);
                    s5 = s5 *2.5;
                    s55 = s5.intValue();
                    String s555 = Integer.toString(s55);
                    if(s55 < 2) {                                                                   //update the textviews with sensor values
                        sensorView5.setBackgroundColor(Color.RED);
                        sensorView5.setText(s555);
                    }else if(s55 > 2){
                        sensorView5.setBackgroundColor(Color.GREEN);
                        sensorView5.setText(s555);
                    }

                    /*String roll = recDataString.substring(32, 36);
                    Double rolldata = new Double(roll);
                    rolldata = rolldata*10;
                    int r0 = rolldata.intValue();
                    String lr0 = Integer.toString(r0);
                    leftRight.setText(lr0);



                    String pitch = recDataString.substring(37,41);
                    Double pitchdata = new Double(pitch);
                    pitchdata = pitchdata * 10;
                    int p0 = pitchdata.intValue();
                    String ud0 = Integer.toString(p0);
                    upDown.setText(ud0);*/
                    
                }

                recDataString.delete(0, recDataString.length());
                //clear all string data
            }

        }
    };

}
