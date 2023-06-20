package com.example.exp6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button parseXMLbtn,parseJSONbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseXMLbtn=(Button) findViewById(R.id.button);
        parseXMLbtn.setOnClickListener(this);
        parseJSONbtn=(Button) findViewById(R.id.button2);
        parseJSONbtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.equals(parseXMLbtn)){
            Intent intent=new Intent(this,View_Activity.class);
            intent.putExtra("dataType","xml");
            startActivity(intent);
        }
        else if(v.equals(parseJSONbtn)){
            Intent intent=new Intent(this,View_Activity.class);
            intent.putExtra("dataType","jason");
            startActivity(intent);
        }
    }
}