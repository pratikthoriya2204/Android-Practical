package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EnterNumberActivity extends AppCompatActivity {

    EditText enterNumber;
    Button btnGetOtp;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_number);

        enterNumber = findViewById(R.id.enter_mobile_number);
        btnGetOtp = findViewById(R.id.buttonGetOtp);
        progressBar = findViewById(R.id.progressbar_sending_otp);

        btnGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!enterNumber.getText().toString().trim().isEmpty()){
                    if((enterNumber.getText().toString().trim()).length() == 10 ){

                        progressBar.setVisibility(View.VISIBLE);
                        btnGetOtp.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + enterNumber.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                EnterNumberActivity.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        btnGetOtp.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        btnGetOtp.setVisibility(View.VISIBLE);
                                        Toast.makeText(EnterNumberActivity.this, "Error Please check Network Connection", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendOtp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        btnGetOtp.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(getApplicationContext(),VerifyNumberActivity.class);
                                        intent.putExtra("mobile",enterNumber.getText().toString());
                                        intent.putExtra("backendOtp",backendOtp);
                                        startActivity(intent);
                                    }
                                }

                        );


                    }else
                    {
                        Toast.makeText(EnterNumberActivity.this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(EnterNumberActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}