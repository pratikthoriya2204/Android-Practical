package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button show_notify;
    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_notify = findViewById(R.id.show_notify);

        show_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable  drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.aa3,null);
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap largeicon = bitmapDrawable.getBitmap();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notification = new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeicon)
                            .setSmallIcon(R.drawable.food)
                            .setContentTitle("Allu Arjun")
                            .setContentText("This is the pushpa and he is super star of south industry")
                            .setChannelId(CHANNEL_ID)
                            .build();
                    notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"my channel",NotificationManager.IMPORTANCE_HIGH));
                }else
                {
                    notification = new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeicon)
                            .setSmallIcon(R.drawable.food)
                            .setContentText("Allu Arjun")
                            .setSubText("This is the pushpa and he is super star of south industry")
                            .build();
                }
                notificationManager.notify(NOTIFICATION_ID,notification);
            }
        });


    }
}