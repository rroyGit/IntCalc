package com.example.roy.contact;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Integer.MAX_VALUE;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText num1, num2;
    Button add, sub, div, mul;
    TextView text;
    Button ethHit;

    double res_num;
    double n1, n2;


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
        ethHit = (Button) findViewById(R.id.js);

        ethHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doIt().execute();
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

                double a  = Double.parseDouble(num1.getText().toString());
                double b  = Double.parseDouble(num2.getText().toString());

                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;
                }
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());

                if(n1 > Double.MAX_VALUE - n2){
                    result.setText(getString(R.string.error3));
                    return;
                }
                res_num = (double) n1 + n2;
               result.setText(NumberFormat.getInstance().format(res_num));
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

                double a  = Double.parseDouble(num1.getText().toString());
                double b  = Double.parseDouble(num2.getText().toString());
                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;
                }

                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());

                res_num = n1 - n2;
                result.setText(NumberFormat.getInstance().format(res_num));
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

                double a  = Double.parseDouble(num1.getText().toString());
                double b  = Double.parseDouble(num2.getText().toString());
                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;
                }

                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());
                double res = (double) n1 * n2;

                if(res < 0 || res > Integer.MAX_VALUE) {
                    result.setText(R.string.error3);
                    return;
                }


                res_num = n1 * n2;
                result.setText(NumberFormat.getInstance().format(res_num));
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

                double a  = Double.parseDouble(num1.getText().toString());
                double b  = Double.parseDouble(num2.getText().toString());
                if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE){
                    result.setText(R.string.error3);
                    return;

                }

                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());
                if(n2 == 0) {
                    result.setText(getString(R.string.error2));
                    return;
                }
                res_num = n1 / n2;
                result.setText(NumberFormat.getInstance().format(res_num));
            }
        });

        btnHit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String res = result.getText().toString();
                res = res.replace(",", "");
                String res2 = res.replace(".","");
                if(StringUtil.isNumeric(res2)) {
                    num1.setText(res);
                }
            }
        });

    }

    private class doIt extends AsyncTask<Void, Void, Void>{
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
            result.setText(R.string.Result);
            text.setText(res);
            num1.setText("1");
            num2.setText(words.substring(1,words.length()));

        }
    }
}
