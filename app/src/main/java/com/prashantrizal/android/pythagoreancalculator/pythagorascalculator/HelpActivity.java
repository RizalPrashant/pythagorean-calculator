package com.prashantrizal.android.pythagoreancalculator.pythagorascalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.prashantrizal.android.pythagoreancalculator.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.HelpActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });
    }
}