package com.example.facebookclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_navigationView;
//    all Fragment
    homeFragment homeFragment = new homeFragment();
    friendsFragment friendsFragment = new friendsFragment();
    menuFragment menuFragment = new menuFragment();
    tvFragment tvFragment = new tvFragment();
    notificationFragment notificationFragment = new notificationFragment();

    LinearLayout facebook_header,f_menu_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebook_header  = findViewById(R.id.facebook_header);
        bottom_navigationView = findViewById(R.id.bottom_navigationView);

        View f_header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.f_header_layout,facebook_header,false);
        facebook_header.addView(f_header);

        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,homeFragment).commit();

        BadgeDrawable badgeForNoti =bottom_navigationView.getOrCreateBadge(R.id.notification);
        badgeForNoti.setVisible(true);
        badgeForNoti.setNumber(8);

        BadgeDrawable badgeFortv =bottom_navigationView.getOrCreateBadge(R.id.tv);
        badgeFortv.setVisible(true);
        badgeFortv.setNumber(3);

        bottom_navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,homeFragment).commit();
                        break;
                    case R.id.friends:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,friendsFragment).commit();
                        break;
                    case R.id.tv:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,tvFragment).commit();
                        break;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,notificationFragment).commit();
                        break;
                    case R.id.menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framContainer,menuFragment).commit();
                        break;
                }
                return true;
            }
        });

    }
}