package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button B1, B2, B3, B4, B5, B6, B7, B8, B9, B0;
    Button add, sub, div, mul, dec, eql;
    Button clr, sin, cos, tan;
    EditText txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1 = (Button) findViewById(R.id.button17);
        B1.setOnClickListener(this);
        B2 = (Button) findViewById(R.id.button18);
        B2.setOnClickListener(this);
        B3 = (Button) findViewById(R.id.button19);
        B3.setOnClickListener(this);
        B4 = (Button) findViewById(R.id.button11);
        B4.setOnClickListener(this);
        B5 = (Button) findViewById(R.id.button14);
        B5.setOnClickListener(this);
        B6 = (Button) findViewById(R.id.button15);
        B6.setOnClickListener(this);
        B7 = (Button) findViewById(R.id.button);
        B7.setOnClickListener(this);
        B8 = (Button) findViewById(R.id.button8);
        B8.setOnClickListener(this);
        B9 = (Button) findViewById(R.id.button9);
        B9.setOnClickListener(this);
        B0 = (Button) findViewById(R.id.button26);
        B0.setOnClickListener(this);
        add = (Button) findViewById(R.id.button24);
        add.setOnClickListener(this);
        sub = (Button) findViewById(R.id.button20);
        sub.setOnClickListener(this);
        div = (Button) findViewById(R.id.button10);
        div.setOnClickListener(this);
        mul = (Button) findViewById(R.id.button27);
        mul.setOnClickListener(this);
        dec = (Button) findViewById(R.id.button21);
        dec.setOnClickListener(this);
        eql = (Button) findViewById(R.id.button23);
        eql.setOnClickListener(this);
        clr = (Button) findViewById(R.id.button25);
        clr.setOnClickListener(this);
        sin = (Button) findViewById(R.id.button2);
        sin.setOnClickListener(this);
        cos = (Button) findViewById(R.id.button3);
        cos.setOnClickListener(this);
        tan = (Button) findViewById(R.id.button4);
        tan.setOnClickListener(this);
        txtResult = (EditText) findViewById(R.id.editTextTextPersonName);
        txtResult.setText("");
    }

    public void onClick(View v) {
        if (v.equals(B1))
            txtResult.append("1");
        if (v.equals(B2))
            txtResult.append("2");
        if (v.equals(B3))
            txtResult.append("3");
        if (v.equals(B4))
            txtResult.append("4");
        if (v.equals(B5))
            txtResult.append("5");
        if (v.equals(B6))
            txtResult.append("6");
        if (v.equals(B7))
            txtResult.append("7");
        if (v.equals(B8))
            txtResult.append("8");
        if (v.equals(B9))
            txtResult.append("9");
        if (v.equals(B0))
            txtResult.append("0");
        if (v.equals(add))
            txtResult.append("+");
        if (v.equals(sub))
            txtResult.append("-");
        if (v.equals(div))
            txtResult.append("/");
        if (v.equals(dec))
            txtResult.append(".");
        if (v.equals(mul))
            txtResult.append("*");
        if (v.equals(sin))
            txtResult.append("Sin");
        if (v.equals(cos))
            txtResult.append("Cos");
        if (v.equals(tan))
            txtResult.append("Tan");
        if (v.equals(clr))
            txtResult.setText(" ");

        if (v.equals(eql)) {
            String data = txtResult.getText().toString();

            if (data.contains("+")) {
                String[] operands = data.split(Pattern.quote("+"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);
                    double Op2 = Double.parseDouble(operands[1]);
                    double result = Op1 + Op2;
                    txtResult.setText(String.valueOf(result));

                }
            }
            if (data.contains("-")) {
                String[] operands = data.split(Pattern.quote("-"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);
                    double Op2 = Double.parseDouble(operands[1]);
                    double result = Op1 - Op2;
                    txtResult.setText(String.valueOf(result));

                }
            }

            if (data.contains("*")) {
                String[] operands = data.split(Pattern.quote("*"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);
                    double Op2 = Double.parseDouble(operands[1]);
                    double result = Op1 * Op2;
                    txtResult.setText(String.valueOf(result));
                }


            }
            if (data.contains("/")) {
                String[] operands = data.split(Pattern.quote("/"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);
                    double Op2 = Double.parseDouble(operands[1]);
                    double result = Op1 / Op2;
                    txtResult.setText(String.valueOf(result));

                }
            }
            if (data.contains("Sin")) {
                String[] operands = data.split(Pattern.quote("Sin"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);

                    double result = Math.sin(Op1);
                    txtResult.setText(String.valueOf(result));

                }
            }

            if (data.contains("Cos")) {
                String[] operands = data.split(Pattern.quote("Cos"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);

                    double result = Math.cos(Op1);
                    txtResult.setText(String.valueOf(result));
                }
            }

            if (data.contains("Tan")) {
                String[] operands = data.split(Pattern.quote("Tan"));
                if (operands.length == 2) {
                    double Op1 = Double.parseDouble(operands[0]);

                    double result = Math.tan(Op1);
                    txtResult.setText(String.valueOf(result));
                }


            }




        }
    }
}



