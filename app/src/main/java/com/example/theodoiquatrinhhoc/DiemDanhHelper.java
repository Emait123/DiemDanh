package com.example.theodoiquatrinhhoc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DiemDanhHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "DiemDanh.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase readDB;
    private SQLiteDatabase writeDB;

    public DiemDanhHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        readDB = getReadableDatabase();
        writeDB = getWritableDatabase();
    }

    public void makeQuery(String query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor getQuery(String query) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(query, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public void createTable(){
    }
}
