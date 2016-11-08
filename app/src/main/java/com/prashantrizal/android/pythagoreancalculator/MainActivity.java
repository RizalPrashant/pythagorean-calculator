package com.prashantrizal.android.pythagoreancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.mainlayout);
        mainLayout.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                Log.d("Json Response", "Touch outside");
                InputMethodManager inputMethodManager = (InputMethodManager)  MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), 0);
                return false;
            }
        });
        // User Input values spaces
        final EditText user_input_value_a = (EditText) findViewById(R.id.user_input_value_a);
        final EditText user_input_value_b = (EditText) findViewById(R.id.user_input_value_b);
        final EditText user_input_value_c = (EditText) findViewById(R.id.user_input_value_c);
        final EditText user_input_value_angleA = (EditText) findViewById(R.id.user_input_value_angleA);
        final EditText user_input_value_angleB = (EditText) findViewById(R.id.user_input_value_angleB);

        // TextView on the triangle
        final TextView textView_a = (TextView) findViewById(R.id.textView_a);
        final TextView textView_b = (TextView) findViewById(R.id.textView_b);
        final TextView textView_c = (TextView) findViewById(R.id.textView_c);
        final TextView textView_angle_A = (TextView) findViewById(R.id.textView_angle_A);
        final TextView textView_angle_B = (TextView) findViewById(R.id.textView_angle_B);

        // the three buttons
        Button button_calculate = (Button) findViewById(R.id.button_calculate);
        Button button_reset = (Button) findViewById(R.id.button_reset);
        Button button_exit = (Button) findViewById(R.id.button_exit);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // gets text from user input values and converts to double

                    //Double a = new Double(Double.parseDouble(user_input_value_a.getText().toString()));
                    //      Double b = Double.parseDouble(user_input_value_b.getText().toString());
                    //      Double c = Double.parseDouble(user_input_value_c.getText().toString());
                    //     Double angle_a = Double.parseDouble(user_input_value_angleA.getText().toString());
                    //   Double angle_b = Double.parseDouble(user_input_value_angleB.getText().toString());
                double a = getValue(user_input_value_a);
                double b = getValue(user_input_value_b);
                double c = getValue(user_input_value_c);
                double angle_a = getValue(user_input_value_angleA);
                double angle_b = getValue(user_input_value_angleB);

                if (a != 0 && b != 0){
                    c = Math.sqrt(a * a + b * b);
                    angle_a = Math.toDegrees(Math.asin(a / c));
                    angle_b = Math.toDegrees(Math.asin(b / c));
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));

                    return;
                }

                if (a != 0 && c != 0){
                    b = Math.sqrt(c*c - a*a);
                    angle_a = Math.toDegrees(Math.asin(a/c));
                    angle_b = Math.toDegrees(Math.asin(b / c));
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }

                if (b != 0 && c != 0){
                    a = Math.sqrt(c * c - b * b);
                    angle_a = Math.toDegrees(Math.asin(a/c));
                    angle_b = Math.toDegrees(Math.asin(b / c));
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }

                if (angle_a != 0 && a != 0){
                    b = a / (Math.tan(Math.toRadians(angle_a)));
                    c = Math.sqrt(a * a + b * b);
                    angle_b = 90 - angle_a;
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;

                }

                if (angle_a != 0 && b != 0){
                    a = b * (Math.tan(Math.toRadians(angle_a)));
                    c = Math.sqrt(a * a + b * b);
                    angle_b = 90 - angle_a;
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }
                if (angle_a != 0 && c != 0){
                    a = c * (Math.sin(Math.toRadians(angle_a)));
                    b = Math.sqrt(c * c - a * a);
                    angle_b = 90 - angle_a;
                    textView_a.setText(String.format("%.1f",b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }


                if (angle_b != 0 && a != 0) {
                    b = a * (Math.tan(Math.toRadians(angle_b)));
                    c = Math.sqrt(a * a + b * b);
                    angle_a = 90 - angle_b;
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }
                if (angle_b != 0 && b != 0) {
                    a = b / (Math.tan(Math.toRadians(angle_b)));
                    c = Math.sqrt(a * a + b * b);
                    angle_a = 90 - angle_b;
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }
                if (angle_b != 0 && c != 0) {
                    b = c * (Math.sin(Math.toRadians(angle_b)));
                    a = Math.sqrt(c*c - b*b);
                    angle_a = 90 - angle_b;
                    textView_a.setText(String.format("%.1f", b));
                    textView_b.setText(String.format("%.1f", a));
                    textView_c.setText(String.format("%.1f", c));
                    user_input_value_a.setText(String.valueOf(a));
                    user_input_value_b.setText(String.valueOf(b));
                    user_input_value_c.setText(String.valueOf(c));
                    user_input_value_angleA.setText(String.valueOf(angle_a));
                    user_input_value_angleB.setText(String.valueOf(angle_b));
                    return;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter at least 2 values",Toast.LENGTH_SHORT).show();
                    return;
                }
            }



                //if(b == null){
                  //  textView_b.setText("test data");
          //      }
               // if (a== ~0 && b== ~0){
                 //   c = Math.sqrt(a*a+b*b);
                //}


            private double getValue(EditText value){
                try {
                    double obtain_data = Double.parseDouble(value.getText().toString());
                    return obtain_data;
                }
                catch(Exception E){
                    double obtain_data = 0;
                    return obtain_data;
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
}
