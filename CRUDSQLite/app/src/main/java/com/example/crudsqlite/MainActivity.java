package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e_name, e_phone, e_email;
    Button b_insert, b_update, b_delete, b_show;
    TableLayout tabView;
    SQLite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_name = findViewById(R.id.e_name);
        e_phone = findViewById(R.id.e_phone);
        e_email = findViewById(R.id.e_email);


        b_insert = findViewById(R.id.b_insert);
        b_update = findViewById(R.id.b_update);
        b_delete = findViewById(R.id.b_delete);
        b_show = findViewById(R.id.b_show);





        sqlite = new SQLite(this);
        b_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e_name.getText().toString();
                String phone = e_phone.getText().toString();
                String email = e_email.getText().toString();
                if (name.equals("") && phone.equals("") && email.equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill all fields!!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean data = sqlite.insertData(name, phone, email);
                    if (data == false) {
                        Toast.makeText(MainActivity.this, "something is wrong with database", Toast.LENGTH_SHORT).show();
                    } else {
                        clear();

                        Toast.makeText(MainActivity.this, "Data Inserted Successfully... ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e_name.getText().toString();
                String phone = e_phone.getText().toString();
                String email = e_email.getText().toString();
                if (name.equals("") && phone.equals("") && email.equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill all fields!!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean data = sqlite.updateData(name, phone, email);
                    if (data == false) {
                        Toast.makeText(MainActivity.this, "Something is wrong in Database.", Toast.LENGTH_SHORT).show();
                    } else {
                        clear();
                        Toast.makeText(MainActivity.this, "Record Updated Successfully.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e_name.getText().toString();
                String phone = e_phone.getText().toString();
                String email = e_email.getText().toString();
                if(phone.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter name to Delete", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean data = sqlite.deleteData(phone);
                    if (data == false) {
                        Toast.makeText(MainActivity.this, "Something is wrong in Database.", Toast.LENGTH_SHORT).show();
                    } else {
                        clear();
                        Toast.makeText(MainActivity.this, "Record Deleted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = sqlite.ShowData();
                if(data.getCount() == 0){
                    Toast.makeText(MainActivity.this, "No DATA to Fetch...", Toast.LENGTH_SHORT).show();
                }else{
                    tabView = findViewById(R.id.tabView);
                    tabView.removeAllViews();
                    TableRow trHeading =new TableRow(getApplicationContext());
                    trHeading.setBackground(getDrawable(R.drawable.tr_back));
//                    trHeading.setBackgroundColor(Color.rgb(58,58,56));
                    TextView th1 = new TextView(getApplicationContext());
                    TextView th2 = new TextView(getApplicationContext());
                    TextView th3 = new TextView(getApplicationContext());
                    TextView th4 = new TextView(getApplicationContext());
                    th1.setPadding(45,30,30,30);
                    th2.setPadding(20,30,30,30);
                    th3.setPadding(20,30,30,30);
                    th4.setPadding(20,30,30,30);
                    th1.setTextColor(Color.rgb(0,0,255));
                    th2.setTextColor(Color.rgb(0,0,255));
                    th3.setTextColor(Color.rgb(0,0,255));
                    th4.setTextColor(Color.rgb(0,0,255));
                    th1.setText("ID");
                    th2.setText("Name");
                    th3.setText("Phone");
                    th4.setText("Email");
                    trHeading.addView(th1);
                    trHeading.addView(th2);
                    trHeading.addView(th3);
                    trHeading.addView(th4);
                    tabView.addView(trHeading);
                    while (data.moveToNext()){
                        TableRow trData = new TableRow(getApplicationContext());
                        trData.setBackground(getDrawable(R.drawable.tab_back));
//                        trData.setBackgroundColor(Color.rgb(150,145,56));
                        TextView td1 = new TextView(getApplicationContext());
                        TextView td2 = new TextView(getApplicationContext());
                        TextView td3 = new TextView(getApplicationContext());
                        TextView td4 = new TextView(getApplicationContext());
                        td1.setPadding(45,30,30,30);
                        td2.setPadding(20,30,30,30);
                        td3.setPadding(20,30,30,30);
                        td4.setPadding(20,30,30,30);
                        td1.setTextColor(Color.rgb(255,255,255));
                        td2.setTextColor(Color.rgb(255,255,255));
                        td3.setTextColor(Color.rgb(255,255,255));
                        td4.setTextColor(Color.rgb(255,255,255));
                        td1.setText(data.getString(0));
                        td2.setText(data.getString(1));
                        td3.setText(data.getString(2));
                        td4.setText(data.getString(3));
                        trData.addView(td1);
                        trData.addView(td2);
                        trData.addView(td3);
                        trData.addView(td4);
                        tabView.addView(trData);
                    }
                }
            }
        });
    }
    public void clear(){
        e_name.getText().clear();
        e_email.getText().clear();
        e_phone.getText().clear();
    }
}