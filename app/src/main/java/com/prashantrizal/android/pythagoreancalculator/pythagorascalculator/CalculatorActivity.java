package com.prashantrizal.android.pythagoreancalculator.pythagorascalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.prashantrizal.android.pythagoreancalculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {
    HashMap<String, Double> hMap = new HashMap<>();
    // User Input values spaces
    EditText user_input_value_a ;
    EditText user_input_value_b ;
    EditText user_input_value_c ;
    EditText user_input_value_angleA;
    EditText user_input_value_angleB;

    // TextView on the triangle
    TextView textView_a;
    TextView textView_b ;
    TextView textView_c ;
    TextView textView_angle_A ;
    TextView textView_angle_B ;
    double a;
    double b;
    double c;
    double angle_a;
    double angle_b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Intent intent = new Intent(CalculatorActivity.this, StepsActivity.class);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> {
            intent.putExtra("userInputMap", hMap);
            startActivity(intent);
        });

        ImageView infoButton = findViewById(R.id.info_button);
        infoButton.setOnClickListener(v -> {
            Intent info_intent = new Intent(CalculatorActivity.this, HelpActivity.class);
            startActivity(info_intent);
        });

        user_input_value_a = (EditText) findViewById(R.id.user_input_value_a);
        user_input_value_b = (EditText) findViewById(R.id.user_input_value_b);
        user_input_value_c = (EditText) findViewById(R.id.user_input_value_c);
        user_input_value_angleA = (EditText) findViewById(R.id.user_input_value_angleA);
        user_input_value_angleB = (EditText) findViewById(R.id.user_input_value_angleB);

        // TextView on the triangle
        textView_a = (TextView) findViewById(R.id.textView_a);
        textView_b = (TextView) findViewById(R.id.textView_b);
        textView_c = (TextView) findViewById(R.id.textView_c);
        textView_angle_A = (TextView) findViewById(R.id.textView_angle_A);
        textView_angle_B = (TextView) findViewById(R.id.textView_angle_B);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.calculatorLayout);
        mainLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                Log.d("Json Response", "Touch outside");
                InputMethodManager inputMethodManager = (InputMethodManager) com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.CalculatorActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                View focusedView = com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.CalculatorActivity.this.getCurrentFocus();
                if (focusedView != null) {
                    inputMethodManager.hideSoftInputFromWindow(com.prashantrizal.android.pythagoreancalculator.pythagorascalculator.CalculatorActivity.this.getCurrentFocus().getWindowToken(), 0);
                }
                return false;
            }
        });


        // the three buttons
        Button button_calculate = (Button) findViewById(R.id.button_calculate);
        Button button_reset = (Button) findViewById(R.id.button_reset);
        Button button_exit = (Button) findViewById(R.id.button_exit);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hMap.clear();
                double a = getValue(user_input_value_a);
                double b = getValue(user_input_value_b);
                double c = getValue(user_input_value_c);
                double angle_a = getValue(user_input_value_angleA);
                double angle_b = getValue(user_input_value_angleB);

                if (a > 100000 || b > 100000 || c > 100000) {
                    recreate();
                    Toast.makeText(getApplicationContext(), "At least one number is too big", Toast.LENGTH_LONG).show();
                    return;
                }
                if (angle_a >= 90 || angle_b >= 90) {
                    recreate();
                    Toast.makeText(getApplicationContext(), "Angle should be less than 90", Toast.LENGTH_LONG).show();
                    return;
                }
                if ((c != 0) && (c <= a || c <= b)) { // c != 0 because when its empty its always gonna be less than a and b
                    recreate();
                    Toast.makeText(getApplicationContext(), "hypotenuse cant be less than the other sides", Toast.LENGTH_LONG).show();
                    return;
                }
                if (angle_a != 0 && angle_b != 0 && a == 0 && b == 0 && c == 0) {
                    recreate();
                    Toast.makeText(getApplicationContext(), "Infinite triangles possible from only angular value.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (a != 0 && b != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    c = Math.sqrt(a * a + b * b);
                    angle_a = Math.toDegrees(Math.asin(a / c));
                    angle_b = Math.toDegrees(Math.asin(b / c));

                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (a != 0 && c != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    b = Math.sqrt(c * c - a * a);
                    angle_a = Math.toDegrees(Math.asin(a / c));
                    angle_b = Math.toDegrees(Math.asin(b / c));
                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (b != 0 && c != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    a = Math.sqrt(c * c - b * b);
                    angle_a = Math.toDegrees(Math.asin(a / c));
                    angle_b = Math.toDegrees(Math.asin(b / c));
                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (angle_a != 0 && a != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    b = a / (Math.tan(Math.toRadians(angle_a)));
                    c = Math.sqrt(a * a + b * b);
                    angle_b = 90 - angle_a;
                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (angle_a != 0 && b != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    a = b * (Math.tan(Math.toRadians(angle_a)));
                    c = Math.sqrt(a * a + b * b);
                    angle_b = 90 - angle_a;

                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (angle_a != 0 && c != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    a = c * (Math.sin(Math.toRadians(angle_a)));
                    b = Math.sqrt(c * c - a * a);
                    angle_b = 90 - angle_a;
                    display(a, b, c, angle_a, angle_b);
                    return;
                }


                if (angle_b != 0 && a != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    b = a * (Math.tan(Math.toRadians(angle_b)));
                    c = Math.sqrt(a * a + b * b);
                    angle_a = 90 - angle_b;
                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (angle_b != 0 && b != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    a = b / (Math.tan(Math.toRadians(angle_b)));
                    c = Math.sqrt(a * a + b * b);
                    angle_a = 90 - angle_b;
                    display(a, b, c, angle_a, angle_b);
                    return;
                }

                if (angle_b != 0 && c != 0) {
                    storeUserInputList(a, b, c, angle_a, angle_b);
                    b = c * (Math.sin(Math.toRadians(angle_b)));
                    a = Math.sqrt(c * c - b * b);
                    angle_a = 90 - angle_b;
                    display(a, b, c, angle_a, angle_b);
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter at least 2 values", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            private void display(double a, double b, double c, double angle_a, double angle_b) {
                textView_a.setText(String.format("%.1f", b));
                textView_b.setText(String.format("%.1f", a));
                textView_c.setText(String.format("%.1f", c));
                user_input_value_a.setText(String.valueOf(a));
                user_input_value_b.setText(String.valueOf(b));
                user_input_value_c.setText(String.valueOf(c));
                user_input_value_angleA.setText(String.valueOf(angle_a));
                user_input_value_angleB.setText(String.valueOf(angle_b));
            }

            private double getValue(EditText value) {
                try {
                    return Double.parseDouble(value.getText().toString());
                } catch (Exception E) {
                    return (double) 0;
                }
            }
        });


        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
                user_input_value_a.getText().clear();
                user_input_value_b.getText().clear();
                user_input_value_c.getText().clear();
                user_input_value_angleA.getText().clear();
                user_input_value_angleB.getText().clear();

            }
        });
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    private void storeUserInputList(double a, double b, double c, double angle_a, double angle_b) {
        if (a != 0) hMap.put("a", a);
        if (b != 0) hMap.put("b", b);
        if (c != 0) hMap.put("c", c);
        if (angle_a != 0) hMap.put("angle_a", angle_a);
        if (angle_b != 0) hMap.put("angle_b", angle_b);
    }
}