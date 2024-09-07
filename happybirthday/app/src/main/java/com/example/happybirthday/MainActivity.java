package com.example.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_num;
    Button btn_enjoy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_num = findViewById(R.id.edt_num);
        btn_enjoy = findViewById(R.id.btn_enjoy);
        TextView numText = findViewById(R.id.textView);


        btn_enjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edt_num.getText().toString();
                long value  = Long.parseLong(text);
                numText.setText(text);

                long minvalue = 8401648553l;
                long enteredVlaue = Long.parseLong(edt_num.getText().toString());
                if (enteredVlaue == minvalue){
                    Toast.makeText(MainActivity.this, "this is correct", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,BirthdayActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "enter right number", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void onBackPressed() {
        // Check if the current activity is the main activity
        if (isTaskRoot()) {
            // If it is the main activity, exit the app
            finish();
        } else {
            // If it's not the main activity, navigate to the previous activity
            super.onBackPressed();
        }
    }
}