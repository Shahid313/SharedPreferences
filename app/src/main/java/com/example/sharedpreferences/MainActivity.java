package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText Data;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Data = (EditText) findViewById(R.id.data);
        addBtn = (Button) findViewById(R.id.addbtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Data.getText().toString();
                SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString("name", text);
                editor.apply();
                SharedPreferences getShrd = getSharedPreferences("demo", MODE_PRIVATE);
                String Name = getShrd.getString("name", "Please Save a note");
                textView.setText(Name);
            }


        });

        SharedPreferences getShrd = getSharedPreferences("demo", MODE_PRIVATE);
        String Name = getShrd.getString("name", "Please Save a note");
        textView.setText(Name);

    }
}