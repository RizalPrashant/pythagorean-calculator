package com.prashantrizal.android.pythagoreancalculator.pythagorascalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.prashantrizal.android.pythagoreancalculator.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = findViewById(R.id.toolbar_help);
        toolbar.setTitle("Info");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });

//        Button startButton = (Button) findViewById(R.id.startButton);
//        startButton.setOnClickListener(v -> {
//            Intent intent = new Intent(com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.HelpActivity.this, CalculatorActivity.class);
//            startActivity(intent);
//        });
    }
}