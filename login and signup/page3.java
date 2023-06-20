package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page3 extends AppCompatActivity implements View.OnClickListener {
    Button cancel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        cancel =(Button) findViewById(R.id.button3);
        cancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
    }
}