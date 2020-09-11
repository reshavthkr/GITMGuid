package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AttendanceActivity extends AppCompatActivity {

    Button attendance3rd, attendance5th, attendance7th;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        attendance3rd = (Button) findViewById(R.id.attendance_3rd);
        attendance5th = (Button) findViewById(R.id.attendance_5th);
        attendance7th = (Button) findViewById(R.id.attendance_7th);


        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        attendance3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attendance3 = new Intent(AttendanceActivity.this,Attendance3Activity.class);
                startActivity(attendance3);
            }
        });

        attendance5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attendance5 = new Intent(AttendanceActivity.this,Attendance5Activity.class);
                startActivity(attendance5);
            }
        });

        attendance7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attendance7 = new Intent(AttendanceActivity.this,Attendance7Activity.class);
                startActivity(attendance7);
            }
        });



    }
}
