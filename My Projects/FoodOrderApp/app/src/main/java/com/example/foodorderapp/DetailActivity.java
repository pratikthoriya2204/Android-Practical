package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = binding.quantity.getText().toString();
                int value = Integer.parseInt(currentValue);
                value++;
                binding.quantity.setText(String.valueOf(value));
            }
        });

        binding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = binding.quantity.getText().toString();
                int value = Integer.parseInt(currentValue);
                if(value < 2 ){
                    Toast.makeText(DetailActivity.this, "Maximum 1 quantity is Required..", Toast.LENGTH_SHORT).show();
                }
                value--;
                binding.quantity.setText(String.valueOf(value));
            }
        });

        final DBHelper helper = new DBHelper(this);
        if (getIntent().getIntExtra("type", 0) == 1) {


            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.foodName.setText(name);
            binding.detailDescription.setText(description);

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            description,
                            name,
                            image,
                            price,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );

                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data saved success....", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(DetailActivity.this,OrderActivity.class);
//                    startActivity(intent);
                    } else {
                        Toast.makeText(DetailActivity.this, "Some problem is occur!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
            binding.foodName.setText(cursor.getString(7));
            binding.detailDescription.setText(cursor.getString(6));
            binding.quantity.setText(cursor.getString(5));

            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   boolean isUpdated =  helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.foodName.getText().toString(),
                            Integer.parseInt(binding.quantity.getText().toString()),
                            id
                    );
                    if (isUpdated) {
                        Toast.makeText(DetailActivity.this, "Data Updated successfully....", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailActivity.this,OrderActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(DetailActivity.this, "Some problem is occur!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
}