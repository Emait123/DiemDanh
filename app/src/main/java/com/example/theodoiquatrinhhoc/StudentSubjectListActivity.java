package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
        DiemDanhHelper dbHelper = new DiemDanhHelper(StudentSubjectListActivity.this);

        /*Cursor checkDb = dbHelper.getQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tbl_monHoc'");
        if (checkDb.getCount() == 0) {
            dbHelper.makeQuery("CREATE TABLE IF NOT EXISTS tbl_monHoc(PK_sMaMon NVARCHAR(15) PRIMARY KEY, sTenMon NVARCHAR(50))");
            dbHelper.makeQuery("INSERT INTO tbl_monHoc VALUES ('mon1', 'Lập trình Di động Cơ bản')");
            dbHelper.makeQuery("INSERT INTO tbl_monHoc VALUES ('mon2', 'Lập trình Web Cơ bản')");
            dbHelper.makeQuery("INSERT INTO tbl_monHoc VALUES ('mon3', 'Hệ quản trị Cơ sở dữ liệu')");
        }*/

        Cursor dataMon = dbHelper.getQuery("SELECT maMon as _id, tenMon as col2 FROM tbl_monHoc");

        /*ArrayList dsMon = new ArrayList();
        while (dataMon.moveToNext()) {
            dsMon.add(dataMon.getString(1));
        }*/

        MyAdapter adapter = new MyAdapter(this, dataMon);
        monHoc.setAdapter(adapter);

        /*ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsMon);
        monHoc.setAdapter(adapter);*/

        monHoc.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = adapter.getCursor();
                String selectedSubject = cursor.getString(1);
                String subjectID = cursor.getString(0);
                Bundle bundle = new Bundle();
                bundle.putString("name", selectedSubject);
                bundle.putString("id", subjectID);
                Intent intent = new Intent(StudentSubjectListActivity.this, StudentSubjectActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}