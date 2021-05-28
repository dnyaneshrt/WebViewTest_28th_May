package com.tech.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {


//step1: download the animation and paste into raw folder
    //step 2- add the depency library.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent intent=new Intent(SplashActivity.this,MainActivity.class);
              startActivity(intent);
              finish();//later we cannot come back to splash activity.

            }
        }, 4500);
    }
}