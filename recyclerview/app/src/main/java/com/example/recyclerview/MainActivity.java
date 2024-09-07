package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

     String [] arr = {"my Name is lakhkhan","Don't angry me","salam rockey bhai","bhai jan","my Name is lakhkhan","Don't angry me","salam rockey bhai","bhai jan","my Name is lakhkhan","Don't angry me","salam rockey bhai","bhai jan","my Name is lakhkhan","Don't angry me","salam rockey bhai","bhai jan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter cs = new CustomAdapter(arr);
        recyclerView.setAdapter(cs);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}