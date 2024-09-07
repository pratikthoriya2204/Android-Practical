package com.example.uncovert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SumActivity extends AppCompatActivity {

    EditText n1,n2;
    Button sum;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        sum = findViewById(R.id.sum);
        textView = findViewById(R.id.textView);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt( n1.getText().toString()) + Integer.parseInt( n2.getText().toString());
                textView.setText("The sum is : " + sum);
            }
        });

    }
}