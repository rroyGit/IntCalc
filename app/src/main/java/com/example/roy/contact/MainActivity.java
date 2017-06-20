package com.example.roy.contact;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

import static java.lang.Integer.MAX_VALUE;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText num1, num2;
    Button add, sub, div, mul;

    int res_num;
    int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.text1);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(num1.getText().toString().trim().isEmpty() ||
                        num2.getText().toString().trim().isEmpty()) {
                    result.setText(getString(R.string.error));
                    return;
                }
                long a  = Long.parseLong(num1.getText().toString());
                long b  = Long.parseLong(num2.getText().toString());

                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;
                }

                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());

                if(n1 > MAX_VALUE - n2){
                    result.setText(getString(R.string.error3));
                    return;
                }
            res_num = n1 + n2;
            result.setText(String.valueOf(res_num));

            }

        });

        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(num1.getText().toString().trim().isEmpty() ||
                        num2.getText().toString().trim().isEmpty()) {
                    result.setText(getString(R.string.error));
                    return;
                }
                if (num1.getText().toString().length() >= 11){
                    result.setText(getString(R.string.error3));
                    return;
                }else if(num2.getText().toString().length() >= 11){
                    result.setText(getString(R.string.error3));
                    return;
                }
                long a  = Long.parseLong(num1.getText().toString());
                long b  = Long.parseLong(num2.getText().toString());
                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;
                }

                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());

                res_num = n1 - n2;
                result.setText(String.valueOf((int)res_num));
            }
        });

        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(num1.getText().toString().trim().isEmpty() ||
                        num2.getText().toString().trim().isEmpty()) {
                    result.setText(getString(R.string.error));
                    return;
                }
                if (num1.getText().toString().length() >= 11){
                    result.setText(getString(R.string.error3));
                    return;
                }else if(num2.getText().toString().length() >= 11){
                    result.setText(getString(R.string.error3));
                    return;
                }

                long a  = Long.parseLong(num1.getText().toString());
                long b  = Long.parseLong(num2.getText().toString());
                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;
                }

                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());

                res_num = n1 * n2;
                result.setText(String.valueOf((int)res_num));
            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(num1.getText().toString().trim().isEmpty() ||
                        num2.getText().toString().trim().isEmpty()) {
                    result.setText(getString(R.string.error));
                    return;
                }
                if (num1.getText().toString().length() >= 11){
                    result.setText(getString(R.string.error3));
                    return;
                }else if(num2.getText().toString().length() >= 11){
                    result.setText(getString(R.string.error3));
                    return;
                }

                long a  = Long.parseLong(num1.getText().toString());
                long b  = Long.parseLong(num2.getText().toString());
                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;

                }

                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());
                if(n2 == 0) {
                    result.setText(getString(R.string.error2));
                    return;
                }
                res_num = n1 / n2;
                result.setText(String.valueOf((int)res_num));
            }
        });

    }
}
