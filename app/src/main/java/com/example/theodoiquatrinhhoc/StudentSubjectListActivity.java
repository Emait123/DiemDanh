package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentSubjectListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_subject_list);

        ListView monHoc =   (ListView) findViewById(R.id.subjectListStudent);
        ArrayList dsMon = new ArrayList();
        dsMon.add("Lập trình Di động Cơ bản");
        dsMon.add("Lập trình Web Cơ bản");
        dsMon.add("Hệ quản trị Cơ sở dữ liệu");
        dsMon.add("Mạng & Truyền thông");
        dsMon.add("Tiếng Anh Chuyên ngành");
        dsMon.add("Nguyên lý hệ điều hành");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsMon);
        monHoc.setAdapter(adapter);
        monHoc.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSubject = (String) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", selectedSubject);
                Intent intent = new Intent(StudentSubjectListActivity.this, StudentSubjectActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}