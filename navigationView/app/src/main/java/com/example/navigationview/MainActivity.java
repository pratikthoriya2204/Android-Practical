package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigation_view;
    DrawerLayout drawer_layout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        navigation_view = findViewById(R.id.navigation_view);
        drawer_layout = findViewById(R.id.drawer_layout);

        // Create a toggle with java code......
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawer_layout,toolbar,R.string.open_drawer,R.string.close_drawer);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.gallery:
                        Toast.makeText(MainActivity.this, "Gallery Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.slideshow:
                        Toast.makeText(MainActivity.this, "Slide Show Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_nav:
                        Toast.makeText(MainActivity.this, "Bottom Navigation Activity Opened", Toast.LENGTH_SHORT).show();
                        openBottomActivity();
                        break;
                    case R.id.rate:
                        Toast.makeText(MainActivity.this, "Rate Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.privacy:
                        Toast.makeText(MainActivity.this, "Privacy Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.exit:
                        exitToActivity();
                        break;
                }
                drawer_layout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    public void exitToActivity(){
        super.onBackPressed();
    }
    public void openBottomActivity(){
        Intent intent = new Intent(MainActivity.this,BottomNavActivity.class);
        startActivity(intent);
    }
}