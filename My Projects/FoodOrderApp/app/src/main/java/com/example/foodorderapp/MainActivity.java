package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger,"Burger","5","Veg Burger with Extra Souse and Chips"));
        list.add(new MainModel(R.drawable.burger2,"Burger","15","Non Veg Burger with Extra Souse and Chips"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","10","Pizza with Extra Souse and Chips"));
        list.add(new MainModel(R.drawable.sandwitch,"Sandwich","12","Veg Sandwich with Extra Souse and Chips"));
        list.add(new MainModel(R.drawable.vadapau,"Vadapau","10","Veg Vada pau with Extra Souse and Chips"));
        list.add(new MainModel(R.drawable.panipuri,"Pani Puri","10","Best Pani Puri with many type of pani"));
        list.add(new MainModel(R.drawable.ghughra,"Ghughra","10","Ghughra with tho chatni"));
        list.add(new MainModel(R.drawable.dalpakvan,"Dal Pakvan","10","Rajkot's Best Dal Pakvan with namkeen"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit")
                .setIcon(R.drawable.warning)
                .setMessage("Are Sure want to Exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Go to Help", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }
}