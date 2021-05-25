package com.example.dementiaprevention;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatButton selfTestButton, dailyTestButton, scoreButton, hospitalButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selfTestButton = findViewById(R.id.selfTestButton);
        dailyTestButton = findViewById(R.id.dailyTestButton);
        scoreButton = findViewById(R.id.scoreButton);
        hospitalButton = findViewById(R.id.hospitalButton);

        selfTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SelfTestActivity.class));
            }
        });
        dailyTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DailyTestActivity.class));
            }
        });
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ScoreActivity.class));
            }
        });
        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HospitalActivity.class));
            }
        });
    }
}