package com.example.bottomnavigationview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    SettingFragment settingFragment = new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,homeFragment).commit();
                        break;
                    case  R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,notificationFragment).commit();
                        break;


                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,settingFragment).commit();
                        break;
                }
                return true;
            }
        });
    }
}