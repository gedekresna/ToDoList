package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvp.View.ILayout2View;

public class Layout2Activity extends AppCompatActivity implements ILayout2View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
    }


}