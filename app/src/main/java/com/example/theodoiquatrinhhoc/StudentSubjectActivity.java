package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentSubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_subject);

        Bundle bundle = getIntent().getExtras();
        String subj = bundle.getString("name");
        TextView txt = findViewById(R.id.subName);
        txt.setText(subj);
    }
}