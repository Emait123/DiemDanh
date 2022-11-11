package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SubjectListActivity extends AppCompatActivity {

    ArrayList dsMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        ListView monHoc =   (ListView) findViewById(R.id.subjectLV);
        dsMon = new ArrayList();
        dsMon.add("Mang");
        dsMon.add("Toan");

        ArrayAdapter adapter = new ArrayAdapter(SubjectListActivity.this, android.R.layout.simple_list_item_1, dsMon);
        monHoc.setAdapter(adapter);
    }
}