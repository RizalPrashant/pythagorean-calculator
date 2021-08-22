package com.prashantrizal.android.pythagoreancalculator1.pythagorascalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.prashantrizal.android.pythagoreancalculator1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StepsActivity extends AppCompatActivity {
    ListView listView;
    List<String> listValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        Bundle bundle = getIntent().getExtras();
        //TextView steps_list_item = findViewById(R.id.steps_list_item);
        listView = findViewById(R.id.steps_list);
        listValue = new ArrayList<>();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Steps");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });

        if (bundle.getSerializable("userInputMap") != null) {
            HashMap<String, Double> userInputMap = (HashMap<String, Double>) bundle.getSerializable("userInputMap");

            if(userInputMap.size() == 0 || userInputMap.size() == 1) {
                listValue.add("Please type correct values and calculate result first to see steps");
            }
            else {
                executeStepsProduction(userInputMap, listValue);
            }
        }

        ArrayAdapter<String> adapter = new CustomListAdapter(this , R.layout.custom_list , listValue);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);
            }
        });
    }

    private void executeStepsProduction(HashMap<String, Double> userInputMap, List<String> steps_list_item) {
        if (userInputMap.containsKey("a") && userInputMap.containsKey("b")) {
            double a = userInputMap.get("a");
            double b = userInputMap.get("b");
            double c = Math.sqrt(a * a + b * b);
            double angle_a = Math.toDegrees(Math.asin(a / c));
            double angle_b = Math.toDegrees(Math.asin(b / c));

            steps_list_item.add("a = " + a + "\n");
            steps_list_item.add("b = " + b + "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = " + b + "\u00B2" +  "+" + a + "\u00B2" + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle A = " + "sin-1(" + a + "/" + c + ")" + "\n");
            steps_list_item.add("Angle A = " + angle_a + "\n");
            steps_list_item.add("Angle B = " + "sin-1(" + b + "/" + c + ")" + "\n");
            steps_list_item.add("Angle B = " + angle_b + "\n");
        }
        else if (userInputMap.containsKey("a") && userInputMap.containsKey("c")) {
            double a = userInputMap.get("a");
            double c = userInputMap.get("c");
            double b = Math.sqrt(c * c - a * a);
            double angle_a = Math.toDegrees(Math.asin(a / c));
            double angle_b = Math.toDegrees(Math.asin(b / c));

            steps_list_item.add("a = " + a + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("b\u00B2 = " + c + "\u00B2" + "-" + a + "\u00B2" + "\n");
            steps_list_item.add("b = " + b + "\n");
            steps_list_item.add("Angle A = " + "sin-1(" + a + "/" + c + ")" + "\n");
            steps_list_item.add("Angle A = " + angle_a +  "\n");
            steps_list_item.add("Angle B = " + "sin-1(" + b + "/" + c + ")" + "\n");
            steps_list_item.add("Angle B = " + angle_b +  "\n");

        }
        else if (userInputMap.containsKey("b") && userInputMap.containsKey("c")) {
            double b = userInputMap.get("b");
            double c = userInputMap.get("c");
            double a = Math.sqrt(c * c - b * b);
            double angle_a = Math.toDegrees(Math.asin(a / c));
            double angle_b = Math.toDegrees(Math.asin(b / c));

            steps_list_item.add("b = " + b + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("a\u00B2 = " + c + "\u00B2" + "-" + b + "\u00B2" + "\n");
            steps_list_item.add("a = " + a + "\n");
            steps_list_item.add("Angle A = " + "sin-1(" + a + "/" + c + ")" + "\n");
            steps_list_item.add("Angle A = " + angle_a +  "\n");
            steps_list_item.add("Angle B = " + "sin-1(" + b + "/" + c + ")" + "\n");
            steps_list_item.add("Angle B = " + angle_b +  "\n");
        }
        else if (userInputMap.containsKey("angle_a") && userInputMap.containsKey("a")) {
            double a = userInputMap.get("a");
            double angle_a = userInputMap.get("angle_a");
            double b = a / (Math.tan(Math.toRadians(angle_a)));
            double c = Math.sqrt(a * a + b * b);
            double angle_b = 90 - angle_a;

            steps_list_item.add("a = " + a + "\n");
            steps_list_item.add("Angle A = " + angle_a + "\n");
            steps_list_item.add("b = " + a + "/ tan " + angle_a +  "\n");
            steps_list_item.add("b = " + b +  "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle B = 90 - " + angle_a +  "\n");
            steps_list_item.add("Angle B =" + angle_b +  "\n");
        }
        else if (userInputMap.containsKey("angle_a") && userInputMap.containsKey("b")) {
            double b = userInputMap.get("b");
            double angle_a = userInputMap.get("angle_a");
            double a = b * (Math.tan(Math.toRadians(angle_a)));
            double c = Math.sqrt(a * a + b * b);
            double angle_b = 90 - angle_a;

            steps_list_item.add("b = " + b + "\n");
            steps_list_item.add("Angle A = " + angle_a + "\n");
            steps_list_item.add("a = " + b + "* tan " + angle_a +  "\n");
            steps_list_item.add("a = " + a  +  "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle B = 90 - " + angle_a +  "\n");
            steps_list_item.add("Angle B =" + angle_b +  "\n");
        }
        else if (userInputMap.containsKey("angle_a") && userInputMap.containsKey("c")) {
            double c = userInputMap.get("c");
            double angle_a = userInputMap.get("angle_a");
            double a = c * (Math.sin(Math.toRadians(angle_a)));
            double b = Math.sqrt(c * c - a * a);
            double angle_b = 90 - angle_a;

            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle A = " + angle_a + "\n");
            steps_list_item.add("a = " + c + "* sin " + angle_a +  "\n");
            steps_list_item.add("a = " + a +  "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("b\u00B2 = " + c + "\u00B2" + "-" + a + "\u00B2" + "\n");
            steps_list_item.add("b = " + b + "\n");
            steps_list_item.add("Angle B = 90 - " + angle_a +  "\n");
            steps_list_item.add("Angle B =" + angle_b +  "\n");
        }
        else if (userInputMap.containsKey("angle_b") && userInputMap.containsKey("a")) {
            double a = userInputMap.get("a");
            double angle_b = userInputMap.get("angle_b");
            double b = a * (Math.tan(Math.toRadians(angle_b)));
            double c = Math.sqrt(a * a + b * b);
            double angle_a = 90 - angle_b;

            steps_list_item.add("a = " + a + "\n");
            steps_list_item.add("Angle B = " + angle_b + "\n");
            steps_list_item.add("b = " + a + "* tan " + angle_b +  "\n");
            steps_list_item.add("b = " + b +  "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle A = 90 - " + angle_b +  "\n");
            steps_list_item.add("Angle A =" + angle_a +  "\n");
        }
        else if (userInputMap.containsKey("angle_b") && userInputMap.containsKey("b")) {
            double b = userInputMap.get("b");
            double angle_b = userInputMap.get("angle_b");
            double a = b / (Math.tan(Math.toRadians(angle_b)));
            double c = Math.sqrt(a * a + b * b);
            double angle_a = 90 - angle_b;

            steps_list_item.add("b = " + b + "\n");
            steps_list_item.add("Angle B = " + angle_b + "\n");
            steps_list_item.add("a = " + b + "/ tan " + angle_b +  "\n");
            steps_list_item.add("a = " + a +  "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = " + a + "\u00B2" + "+" + b + "\u00B2" + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle A = 90 - " + angle_b +  "\n");
            steps_list_item.add("Angle A =" + angle_a +  "\n");
        }
        else if (userInputMap.containsKey("angle_b") && userInputMap.containsKey("c")) {
            double c = userInputMap.get("c");
            double angle_b = userInputMap.get("angle_b");
            double b = c * (Math.sin(Math.toRadians(angle_b)));
            double a = Math.sqrt(c * c - b * b);
            double angle_a = 90 - angle_b;

            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle B = " + angle_b + "\n");
            steps_list_item.add("b = " + c + "* sin " + angle_b +  "\n");
            steps_list_item.add("b = " + b +  "\n");
            steps_list_item.add("h\u00B2 = p\u00B2 + b\u00B2" + "\n");
            steps_list_item.add("c\u00B2 = b\u00B2 + a\u00B2" + "\n");
            steps_list_item.add("a\u00B2 = " + c + "\u00B2" + "-" + b + "\u00B2" + "\n");
            steps_list_item.add("c = " + c + "\n");
            steps_list_item.add("Angle A = 90 - " + angle_b +  "\n");
            steps_list_item.add("Angle A =" + angle_a +  "\n");
        }
    }
}