package com.example.pmoloi.location.ui.activity.splashscreenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.pmoloi.location.BuildConfig;
import com.example.pmoloi.location.R;
import com.example.pmoloi.location.ui.activity.mainactivity.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private TextView appVersionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appVersionCode = findViewById(R.id.textViewSplashScreenVersionCodeLabel);
        appVersionCode.setText(BuildConfig.VERSION_NAME);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        stimulateSomeWork();
    }

    private void stimulateSomeWork() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 1000);
    }
}
