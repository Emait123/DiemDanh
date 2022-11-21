package com.example.theodoiquatrinhhoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    SwitchMaterial id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (SwitchMaterial) findViewById(R.id.login);

        DiemDanhHelper db = new DiemDanhHelper(MainActivity.this);

        /*db.makeQuery("DROP TABLE IF EXISTS tbl_monHoc");
        db.makeQuery("DROP TABLE IF EXISTS tbl_buoiHoc");
        db.makeQuery("DROP TABLE IF EXISTS tbl_sinhVien");*/


        Cursor checkDb = db.getQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tbl_monHoc'");
        if (checkDb.getCount() == 0) {
            db.makeQuery("CREATE TABLE IF NOT EXISTS tbl_monHoc(maMon NVARCHAR(15) PRIMARY KEY, tenMon NVARCHAR(50))");
            db.makeQuery("INSERT INTO tbl_monHoc VALUES ('mon1', 'Lập trình Di động Cơ bản')");
            db.makeQuery("INSERT INTO tbl_monHoc VALUES ('mon2', 'Lập trình Web Cơ bản')");
            db.makeQuery("INSERT INTO tbl_monHoc VALUES ('mon3', 'Hệ quản trị Cơ sở dữ liệu')");
        }

        checkDb = db.getQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tbl_buoiHoc'");
        if (checkDb.getCount() == 0) {
            db.makeQuery("CREATE TABLE IF NOT EXISTS tbl_buoiHoc(maBuoi INTEGER PRIMARY KEY AUTOINCREMENT, maMon NVARCHAR(15), gioHoc TEXT, maDiemDanh INTEGER)");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon1', datetime('2022-11-20 17:15:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon1', datetime('2022-11-23 17:15:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon1', datetime('2022-11-26 17:15:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon2', datetime('2022-11-20 11:00:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon2', datetime('2022-11-23 11:00:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon2', datetime('2022-11-26 11:00:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon3', datetime('2022-11-20 15:15:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon3', datetime('2022-11-23 15:15:00.000'))");
            db.makeQuery("INSERT INTO tbl_buoiHoc(maMon, gioHoc) VALUES ('mon3', datetime('2022-11-26 15:15:00.000'))");
        }

        checkDb = db.getQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tbl_sinhVien'");
        if (checkDb.getCount() == 0) {
            db.makeQuery("CREATE TABLE IF NOT EXISTS tbl_sinhVien(masv NVARCHAR(15) PRIMARY KEY, buoiHoc INTEGER, diemDanh INTEGER DEFAULT 0)");
            db.makeQuery("INSERT INTO tbl_sinhVien(masv) VALUES ('Trương Tiến Đạt')");
        }
    }

    public void login(View view) {
        Intent intent;

        if (id.isChecked()) {
            intent = new Intent(this, TeacherSubjectListActivity.class);
            startActivity(intent);
        }
        else {
            intent = new Intent(this, StudentSubjectListActivity.class);
            startActivity(intent);
        }
    }
}