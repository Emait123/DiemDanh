package com.example.theodoiquatrinhhoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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