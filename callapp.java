package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bStar,bHash,bDel,bCall,bSave;
    EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(this);
        bDel = (Button) findViewById(R.id.button);
        bDel.setOnClickListener(this);
        b0 = (Button) findViewById(R.id.button0);
        b0.setOnClickListener(this);
        bStar = (Button) findViewById(R.id.buttonStar);
        bStar.setOnClickListener(this);
        bHash = (Button) findViewById(R.id.buttonHash);
        bHash.setOnClickListener(this);
        bCall = (Button) findViewById(R.id.buttonCall);
        bCall.setOnClickListener(this);
        bSave = (Button) findViewById(R.id.buttonSave);
        bSave.setOnClickListener(this);
        textView = (EditText) findViewById(R.id.editTextNumber);
        textView.setText("");
    }

    @Override
    public void onClick(View view) {
        if (view.equals(b0)) textView.append("0");
        else if (view.equals(b1)) textView.append("1");
        else if (view.equals(b2)) textView.append("2");
        else if (view.equals(b3)) textView.append("3");
        else if (view.equals(b4)) textView.append("4");
        else if (view.equals(b5)) textView.append("5");
        else if (view.equals(b6)) textView.append("6");
        else if (view.equals(b7)) textView.append("7");
        else if (view.equals(b8)) textView.append("8");
        else if (view.equals(b9)) textView.append("9");
        else if (view.equals(bStar)) textView.append("*");
        else if (view.equals(bHash)) textView.append("#");
        else if (view.equals(bSave)){
            Intent it = new Intent(ContactsContract.Intents.Insert.ACTION);
            it.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            it.putExtra(ContactsContract.Intents.Insert.NAME, "Unknown");
            it.putExtra(ContactsContract.Intents.Insert.PHONE, textView.getText().toString());
            startActivity(it);
        }
        else if(view.equals(bDel)){
            String d = textView.getText().toString();
            if(d.length() > 0){
                textView.setText(d.substring(0, d.length()-1));
            }
            else textView.setText("");
        } else if (view.equals(bCall)) {
            String data = textView.getText().toString();
            Intent it = new Intent(Intent.ACTION_DIAL);
            it.setData(Uri.parse("tel:"+data));
            startActivity(it);
        }
    }
}