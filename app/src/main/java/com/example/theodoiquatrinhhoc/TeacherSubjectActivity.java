package com.example.theodoiquatrinhhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class TeacherSubjectActivity extends AppCompatActivity {

    int lessonID;
    DiemDanhHelper db;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_subject);

        btn = findViewById(R.id.submitBtn);
        btn.setEnabled(false);

        Bundle bundle = getIntent().getExtras();
        String subj = bundle.getString("name");
        String id = bundle.getString("id");
        TextView txt = findViewById(R.id.subName);
        txt.setText(subj);

        ListView buoiHoc = (ListView) findViewById(R.id.lessonList);
        db = new DiemDanhHelper(this);
        Cursor dataMon = db.getQuery("SELECT maBuoi as _id, gioHoc as col2 FROM tbl_buoiHoc INNER JOIN tbl_monHoc ON tbl_monHoc.maMon = tbl_buoiHoc.maMon WHERE tbl_buoiHoc.maMon = '" + id + "'");
        MyAdapter adapter = new MyAdapter(this, dataMon);
        buoiHoc.setAdapter(adapter);

        buoiHoc.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = adapter.getCursor();
                String selectedLesson = cursor.getString(1);
                lessonID = cursor.getInt(0);

                String lesson = "Buổi học " + selectedLesson;
                TextView date = findViewById(R.id.lesson);
                date.setText(lesson);
                btn.setEnabled(true);
            }
        });
    }

    public void setCode(View view) {
        if (lessonID == 0) {
            Toast.makeText(this, "Xin hãy chọn buổi học để đặt mã", Toast.LENGTH_SHORT).show();
        }
        else {
            EditText subCode = findViewById(R.id.subCode);

            if (!subCode.getText().toString().equals("")) {
                btn.setEnabled(false);
                int code = Integer.parseInt(subCode.getText().toString());
                db.makeQuery("UPDATE tbl_buoiHoc SET maDiemDanh = " + code + " WHERE maBuoi = " + lessonID);
                Toast.makeText(this, "Đặt mã điểm danh thành công", Toast.LENGTH_SHORT).show();

                InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
                subCode.setText(null);
                subCode.clearFocus();
            } else {
                Toast.makeText(this, "Xin hãy nhập mã điểm danh", Toast.LENGTH_SHORT).show();
            }

        }
    }
}