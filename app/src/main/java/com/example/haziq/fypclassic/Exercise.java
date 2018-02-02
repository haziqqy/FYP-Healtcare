package com.example.haziq.fypclassic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Exercise extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

    }



    public void click(View v) {
        Intent in = null;
        switch (v.getId()) {
            case R.id.ex1:
                in = new Intent(this, Exercise1.class);
                break;
            case R.id.ex2:
                in = new Intent(this, Exercise2.class);

        }
        startActivity(in);
    }
}
