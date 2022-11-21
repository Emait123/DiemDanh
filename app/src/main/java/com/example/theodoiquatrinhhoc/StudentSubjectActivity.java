package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class StudentSubjectActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    DiemDanhHelper db;
    int lessonID = -1;
    Button btn;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_subject);

        Bundle bundle = getIntent().getExtras();
        String subj = bundle.getString("name");
        String id = bundle.getString("id");
        TextView txt = findViewById(R.id.subName);
        txt.setText(subj);

        Spinner list = findViewById(R.id.list);
        db = new DiemDanhHelper(this);
        Cursor data = db.getQuery("SELECT maBuoi as _id, gioHoc as col2 FROM tbl_buoiHoc INNER JOIN tbl_monHoc ON tbl_monHoc.maMon = tbl_buoiHoc.maMon WHERE tbl_buoiHoc.maMon = '" + id + "'");
        adapter = new MyAdapter(this, data);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(this);
        btn = findViewById(R.id.submitBtn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Cursor cursor = adapter.getCursor();
        String selectedLesson = cursor.getString(1);
        lessonID = cursor.getInt(0);

        TextView selected = findViewById(R.id.selectedLesson);
        selected.setText(selectedLesson);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        TextView selected = findViewById(R.id.selectedLesson);
        selected.setText(R.string.lesson_prompt);
    }

    @Override
    public void onClick(View view) {
        if (lessonID != -1) {
            EditText editext = findViewById(R.id.subCode);
            String code = editext.getText().toString();
            if (!code.equals("")) {
                int inputCode = Integer.parseInt(code);
                Cursor c = db.getQuery("SELECT gioHoc, maDiemDanh FROM tbl_buoiHoc WHERE maBuoi = " + lessonID);
                c.moveToFirst();
                int setCode = c.getInt(1);
                if (inputCode == setCode) {
                    Toast.makeText(this, "Điểm danh thành công", Toast.LENGTH_LONG).show();
                    db.makeQuery("UPDATE tbl_sinhVien SET buoiHoc = " + lessonID + ", diemDanh = 1");
                } else {
                    Toast.makeText(this, "Mã buổi học không đúng", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Xin hãy nhập mã điểm danh", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.lesson_prompt, Toast.LENGTH_LONG).show();
        }

    }
}