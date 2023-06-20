package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText txtusername;
EditText txtpassword;
Button btnsignup;
String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtusername=(EditText) findViewById(R.id.editTextTextPersonName);
        txtpassword=(EditText) findViewById(R.id.editTextTextPersonName2);
        btnsignup=(Button) findViewById(R.id.button);
        btnsignup.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        String username=txtusername.getText().toString();
        String password=txtpassword.getText().toString();
        if(validatepassword(password)){
            Bundle bundle=new Bundle();
            bundle.putString("user",username);
            bundle.putString("Lab@2022",password);
            Intent it=new Intent(this,loginactivity.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatepassword(String password)
    {
        Pattern pattern= Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}