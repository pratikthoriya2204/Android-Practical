package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigationView;
    homeFragment homeFragment = new homeFragment();
    settingFragment settingFragment = new settingFragment();
    notificationFragment notificationFragment  = new notificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnav);

        bottom_navigationView = findViewById(R.id.bottom_navigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,homeFragment).commit();

        BadgeDrawable badgeDrawable = bottom_navigationView.getOrCreateBadge(R.id.notification);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(7);

        bottom_navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,homeFragment).commit();
                        return true;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,notificationFragment).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,settingFragment).commit();
                        return true;
                }
                return true;
            }
        });
    }
}