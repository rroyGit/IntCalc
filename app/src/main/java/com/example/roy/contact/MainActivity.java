package com.example.roy.contact;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Integer.MAX_VALUE;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText num1, num2;
    Button add, sub, div, mul;

    int res_num;
    int n1, n2;

    TextView text;
    Button hit;

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

        //---------------------//
        Button btnHit = (Button) findViewById(R.id.btnHit);
        //final TextView txt = (TextView) findViewById(R.id.json);
        //------------------------//
        text = (TextView) findViewById(R.id.json);
        hit = (Button) findViewById(R.id.js);

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doit().execute();
            }
        });




        /*
        btnHit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                HttpURLConnection conn = null;
                BufferedReader reader =  null;

                try{
                    URL url = new URL("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                    conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    InputStream stream = conn.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();
                    String line = "";
                    while((line = reader.readLine()) != null){
                        buffer.append(line);
                    }

                    txt.setText(buffer.toString());

                } catch (MalformedURLException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    if(conn != null){
                        conn.disconnect();
                    }
                    try{
                        if(reader != null) reader.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }

            }
        });
        */

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
                long res = n1 * n2;

                if(res < 0 || res > Integer.MAX_VALUE) {
                    result.setText(R.string.error3);
                    return;
                }
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
    public class doit extends AsyncTask<Void, Void, Void>{
String words;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("https://coinmarketcap.com/currencies/ethereum/").get();
                words = doc.select("span#quote_price").text();

            }catch(IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String res = "1 Ether = " + words;
            text.setText(res);
            num1.setText("1");
            num2.setText(words.substring(1,4));
        }
    }
}
