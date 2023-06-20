package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonstart,buttonstop,buttonreset;
    TextView countervalue;
    public int counter=0;
    public boolean running=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonstart=(Button)findViewById(R.id.button);
        buttonstart.setOnClickListener(this);
        buttonstop=(Button) findViewById(R.id.button2);
        buttonstop.setOnClickListener(this);
        buttonreset=(Button) findViewById(R.id.button3);
        buttonreset.setOnClickListener(this);
        countervalue=(TextView)findViewById(R.id.textView2);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(buttonstart)){
            counterstart();
        }
        else if(v.equals(buttonstop)){
            counterstop();

        } else if (v.equals(buttonreset)) {
            countervalue.setText("0");
        }

    }
    private void counterstop(){
        this.running=false;
        buttonstart.setEnabled(true);
        buttonstop.setEnabled(false);
    }
    private void counterstart(){
        counter=0;
        running=true;
        //System.out.println("start->"+Thread.currentThread().getname());
        new MyCounter().start();
        buttonstart.setEnabled(false);
        buttonstop.setEnabled(true);

    }
    Handler handler=new Handler(Looper.getMainLooper())
    {
        public void handleMessage(Message mes){
            countervalue.setText(String.valueOf(mes.what));

        }
    };
    class MyCounter extends Thread{
        public void run()
        {
            //System.out.println("My counter->"+Thread.currentThread().getName());
            while(running){
                counter++;
                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);

                }
                catch(Exception e){}

            }
        }
    }

}