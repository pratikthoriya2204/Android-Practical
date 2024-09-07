package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText  = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        SharedPreferences sp = getSharedPreferences("myPref",MODE_PRIVATE);
        String editval = sp.getString("name","No value are available");
        textView.setText(editval);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("myPref",MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name",val);
                textView.setText(val);
                ed.apply();
                Toast.makeText(MainActivity.this, "Value Added success " + val, Toast.LENGTH_SHORT).show();
            }
        });
    }
}