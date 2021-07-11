package com.prashantrizal.android.pythagoreancalculator.pythagorascalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.prashantrizal.android.pythagoreancalculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StepsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        Bundle bundle = getIntent().getExtras();
        TextView steps_view = findViewById(R.id.steps_view);
        if (bundle.getSerializable("userInputMap") != null) {
            HashMap<String, Double> userInputMap = (HashMap<String, Double>) bundle.getSerializable("userInputMap");
            Log.d("prashant","Size of hmap is " + userInputMap.size());

            if(userInputMap.size() == 0 || userInputMap.size() == 1) {
                steps_view.setText("Please type correct values and calculate result first to see steps");
            }
            else {
                executeStepsProduction(userInputMap, steps_view);
            }
        }
    }

    private void executeStepsProduction(HashMap<String, Double> userInputMap, TextView steps_view) {
        if (userInputMap.containsKey("a") && userInputMap.containsKey("b")) {
            double a = userInputMap.get("a");
            double b = userInputMap.get("b");
            double c = Math.sqrt(a * a + b * b);
            double angle_a = Math.toDegrees(Math.asin(a / c));
            double angle_b = Math.toDegrees(Math.asin(b / c));

            steps_view.setText("a = " + a + "\n");
            steps_view.append("b = " + b + "\n");
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("c\u00B2 = " + b + "\u00B2" +  "+" + a + "\u00B2" + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("Angle A = " + "sin-1(" + a + "/" + c + ")" + "\n");
            steps_view.append("Angle A = " + angle_a);
            steps_view.append("Angle B = " + "sin-1(" + b + "/" + c + ")" + "\n");
            steps_view.append("Angle B = " + angle_b);
        }
        else if (userInputMap.containsKey("a") && userInputMap.containsKey("c")) {
            double a = userInputMap.get("a");
            double c = userInputMap.get("c");
            double b = Math.sqrt(c * c - a * a);
            double angle_a = Math.toDegrees(Math.asin(a / c));
            double angle_b = Math.toDegrees(Math.asin(b / c));

            steps_view.setText("a = " + a + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("b\u00B2 = " + c + "\u00B2" + "-" + a + "\u00B2" + "\n");
            steps_view.append("b = " + b + "\n");
            steps_view.append("Angle A = " + "sin-1(" + a + "/" + c + ")" + "\n");
            steps_view.append("Angle A = " + angle_a);
            steps_view.append("Angle B = " + "sin-1(" + b + "/" + c + ")" + "\n");
            steps_view.append("Angle B = " + angle_b);

        }
        else if (userInputMap.containsKey("b") && userInputMap.containsKey("c")) {
            double b = userInputMap.get("b");
            double c = userInputMap.get("c");
            double a = Math.sqrt(c * c - b * b);
            double angle_a = Math.toDegrees(Math.asin(a / c));
            double angle_b = Math.toDegrees(Math.asin(b / c));

            steps_view.setText("b = " + b + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("a\u00B2 = " + c + "\u00B2" + "-" + b + "\u00B2" + "\n");
            steps_view.append("a = " + a + "\n");
            steps_view.append("Angle A = " + "sin-1(" + a + "/" + c + ")" + "\n");
            steps_view.append("Angle A = " + angle_a);
            steps_view.append("Angle B = " + "sin-1(" + b + "/" + c + ")" + "\n");
            steps_view.append("Angle B = " + angle_b);
        }
        else if (userInputMap.containsKey("angle_a") && userInputMap.containsKey("a")) {
            double a = userInputMap.get("a");
            double angle_a = userInputMap.get("angle_a");
            double b = a / (Math.tan(Math.toRadians(angle_a)));
            double c = Math.sqrt(a * a + b * b);
            double angle_b = 90 - angle_a;

            steps_view.setText("a = " + a + "\n");
            steps_view.append("Angle A = " + angle_a + "\n");
            steps_view.append("b = " + a + "/ tan " + angle_a);
            steps_view.append("b = " + b);
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("Angle B = 90 - " + angle_a);
            steps_view.append("Angle B =" + angle_b);
        }
        else if (userInputMap.containsKey("angle_a") && userInputMap.containsKey("b")) {
            double b = userInputMap.get("b");
            double angle_a = userInputMap.get("angle_a");
            double a = b * (Math.tan(Math.toRadians(angle_a)));
            double c = Math.sqrt(a * a + b * b);
            double angle_b = 90 - angle_a;

            steps_view.setText("b = " + b + "\n");
            steps_view.append("Angle A = " + angle_a + "\n");
            steps_view.append("a = " + b + "* tan " + angle_a);
            steps_view.append("a = " + a);
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("Angle B = 90 - " + angle_a);
            steps_view.append("Angle B =" + angle_b);
        }
        else if (userInputMap.containsKey("angle_a") && userInputMap.containsKey("c")) {
            double c = userInputMap.get("c");
            double angle_a = userInputMap.get("angle_a");
            double a = c * (Math.sin(Math.toRadians(angle_a)));
            double b = Math.sqrt(c * c - a * a);
            double angle_b = 90 - angle_a;

            steps_view.setText("c = " + c + "\n");
            steps_view.append("Angle A = " + angle_a + "\n");
            steps_view.append("a = " + c + "* sin " + angle_a);
            steps_view.append("a = " + a);
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("b\u00B2 = " + c + "\u00B2" + "-" + a + "\u00B2" + "\n");
            steps_view.append("b = " + b + "\n");
            steps_view.append("Angle B = 90 - " + angle_a);
            steps_view.append("Angle B =" + angle_b);
        }
        else if (userInputMap.containsKey("angle_b") && userInputMap.containsKey("a")) {
            double a = userInputMap.get("a");
            double angle_b = userInputMap.get("angle_b");
            double b = a * (Math.tan(Math.toRadians(angle_b)));
            double c = Math.sqrt(a * a + b * b);
            double angle_a = 90 - angle_b;

            steps_view.setText("a = " + a + "\n");
            steps_view.append("Angle B = " + angle_b + "\n");
            steps_view.append("b = " + a + "* tan " + angle_b);
            steps_view.append("b = " + b);
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("Angle A = 90 - " + angle_b);
            steps_view.append("Angle A =" + angle_a);
        }
        else if (userInputMap.containsKey("angle_b") && userInputMap.containsKey("b")) {
            double b = userInputMap.get("b");
            double angle_b = userInputMap.get("angle_b");
            double a = b / (Math.tan(Math.toRadians(angle_b)));
            double c = Math.sqrt(a * a + b * b);
            double angle_a = 90 - angle_b;

            steps_view.setText("b = " + b + "\n");
            steps_view.append("Angle B = " + angle_b + "\n");
            steps_view.append("a = " + b + "/ tan " + angle_b);
            steps_view.append("a = " + a);
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("Angle A = 90 - " + angle_b);
            steps_view.append("Angle A =" + angle_a);
        }
        else if (userInputMap.containsKey("angle_b") && userInputMap.containsKey("c")) {
            double c = userInputMap.get("c");
            double angle_b = userInputMap.get("angle_b");
            double b = c * (Math.sin(Math.toRadians(angle_b)));
            double a = Math.sqrt(c * c - b * b);
            double angle_a = 90 - angle_b;

            steps_view.setText("c = " + c + "\n");
            steps_view.append("Angle B = " + angle_b + "\n");
            steps_view.append("b = " + c + "* sin " + angle_b);
            steps_view.append("b = " + b);
            steps_view.append("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_view.append("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_view.append("a\u00B2 = " + c + "\u00B2" + "-" + b + "\u00B2" + "\n");
            steps_view.append("c = " + c + "\n");
            steps_view.append("Angle A = 90 - " + angle_b);
            steps_view.append("Angle A =" + angle_a);
        }
    }
}