package com.example.user.wr_internalfileome;

import android.content.Context;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.FileNameMap;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tv1;
    String FILENAME = "FILENAME.text";
    String st1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void omer1 (View view)  {
        if (et1.getText()!=null){
            st1=et1.getText().toString();
        }
        FILENAME = et1.getText().toString();
        FileOutputStream fos = null;
        try {
           fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(st1);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

        public void omer2 (View view) throws IOException {
            try {
                InputStream is = openFileInput(FILENAME);
                InputStreamReader tmp = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuffer buffer = new StringBuffer();
                while ((str = reader.readLine()) != null) {
                    buffer.append(str + "/n");
                    tv1.setText(st1);
                }
                is.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
            }
        }



