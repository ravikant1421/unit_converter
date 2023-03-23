package com.example.unitconverter3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    CardView cv_temperature;
    CardView cv_weight;
    CardView cv_length;
    CardView cv_speed;
    CardView cv_volume;
    CardView cv_time;
    CardView cv_area;
    CardView cv_fuel;
    CardView cv_pressure;
    CardView cv_force;
    CardView cv_frequency;
    AdView bannerAdView;
    AdRequest adRequest;
    private final String CHANNEL_ID="update";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadAd();


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,"Update Information", NotificationManager.IMPORTANCE_HIGH);
        NotificationManager notificationManager1=getSystemService(NotificationManager.class);
        notificationManager1.createNotificationChannel(channel);
        }
        cv_temperature = findViewById(R.id.cv_temperature);
        cv_weight = findViewById(R.id.cv_weight);
        cv_length = findViewById(R.id.cv_length);
        cv_speed = findViewById(R.id.cv_speed);
        cv_volume = findViewById(R.id.cv_volume);
        cv_time = findViewById(R.id.cv_time);
        cv_area = findViewById(R.id.cv_area);
        cv_fuel = findViewById(R.id.cv_fuel);
        cv_pressure = findViewById(R.id.cv_pressure);
        cv_force = findViewById(R.id.cv_force);
        cv_frequency = findViewById(R.id.cv_frequency);


        cv_weight.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WeightActivity.class)));
        cv_length.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,LengthActivity.class)));
        cv_area.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AreaActivity.class)));
        cv_volume.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, VolumeActivity.class)));
        cv_speed.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SpeedActivity.class)));
        cv_time.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TimeActivity.class)));
        cv_frequency.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FrequencyActivity.class)));
        cv_temperature.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TemperatureActivity.class)));
        cv_force.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ForceActivity.class)));
        cv_pressure.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PressureActivity.class)));
        cv_fuel.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,FuelActivity.class)));

    }

    private void loadAd() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.bannerAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}