package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    View view;
    ListView listView;
     String arr[] = {"PUSHPA ","ALL VAIKUNTH PURAMA","KHTAR NAKH KHILADI","ARYA",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
//        listView.setAdapter(ad);

        //use custom adapter ..
        listAdapter listAdapter = new listAdapter(this,R.layout.list_item_view,arr);
        listView.setAdapter(listAdapter);


    }
}