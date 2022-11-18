package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class AddSubjectActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView startDate;
    TextView endDate;
    EditText subjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        startDate = (TextView) findViewById(R.id.subjectStart);
        endDate = (TextView) findViewById(R.id.subjectEnd);
    }

    public void setStartDate(View view) {
        final Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog pickStart = new DatePickerDialog(AddSubjectActivity.this,
                this, year, month, day);
        pickStart.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
        String date = "Ngay " + day + " thang " + month + " nam " + year;
        startDate.setText(date);
    }
}