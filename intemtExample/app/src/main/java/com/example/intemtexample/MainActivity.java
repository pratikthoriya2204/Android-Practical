package com.example.intemtexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e_name;
    Button button;
    public static final String EXTRA_NAME = "com.example.intentexample.extra.Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_name = findViewById(R.id.e_name);
        button = findViewById(R.id.button);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
//                startActivity(intent);
//            }
//        });
    }

    public void sendData(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
        String nameText = e_name.getText().toString();
        intent.putExtra(EXTRA_NAME,nameText);
        startActivity(intent);
    }
}