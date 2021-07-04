package com.prashantrizal.android.pythagoreancalculator.pythagorascalculator;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.MainActivity;
import com.prashantrizal.android.pythagoreancalculator.R;


public class HelpActivity extends AppCompatActivity {
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.HelpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

