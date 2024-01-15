package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button start;
    EditText edt1;
    EditText edt2;
    static final String[] Months = new String[] {
            "January", "February", "March", "April", "May", " July", "August", "September", "October", "November", "December"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        start = (Button) findViewById(R.id.button);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        Spinner spinYear = (Spinner)findViewById(R.id.spinnerYears);
        spinYear.setAdapter(adapter);

        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Months);
        adapterMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinMonths = (Spinner)findViewById(R.id.spinnerMonths);
        spinMonths.setAdapter(adapterMonths);

        ArrayList<String> days = new ArrayList<String>();

        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapterDays = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        Spinner spinDays = (Spinner)findViewById(R.id.spinnerDays);
        spinDays.setAdapter(adapterDays);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inttext = Integer.parseInt(edt1.getText().toString());
                int inttext2 = Integer.parseInt(edt2.getText().toString());
                int resilt = inttext-inttext2;
                Intent go = new Intent(MainActivity.this, MainActivity2.class);
                go.putExtra(Intent.EXTRA_TEXT, String.valueOf(resilt));
                startActivity(go);
            }
        });

    }
}