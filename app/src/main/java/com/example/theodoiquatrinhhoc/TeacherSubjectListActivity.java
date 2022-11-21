package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TeacherSubjectListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_subject_list);

        ListView monHoc = findViewById(R.id.subjectListTeacher);
        DiemDanhHelper db = new DiemDanhHelper(TeacherSubjectListActivity.this);
        Cursor dataMon = db.getQuery("SELECT maMon as _id, tenMon as col2 FROM tbl_monHoc");
        MyAdapter adapter = new MyAdapter(TeacherSubjectListActivity.this, dataMon);
        monHoc.setAdapter(adapter);

        monHoc.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = adapter.getCursor();
                String selectedSubject = cursor.getString(1);
                String subjectID = cursor.getString(0);
                Bundle bundle = new Bundle();
                bundle.putString("name", selectedSubject);
                bundle.putString("id", subjectID);
                Intent intent = new Intent(TeacherSubjectListActivity.this, TeacherSubjectActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}