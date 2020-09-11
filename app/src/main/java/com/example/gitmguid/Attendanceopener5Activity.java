package com.example.gitmguid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Attendanceopener5Activity extends AppCompatActivity {
    PDFView attendanceview5;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendanceopener5);

        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        attendanceview5 = (PDFView) findViewById(R.id.attendance_viewer5);
        String getItem =getIntent().getStringExtra("FileName");

        if(getItem.equals("Attendance1")){
            attendanceview5.fromAsset(".pdf").load();
        }

        if(getItem.equals("Attendance2")){
            attendanceview5.fromAsset(".pdf").load();
        }

        if(getItem.equals("Attendance3")){
            attendanceview5.fromAsset(".pdf").load();
        }
        if(getItem.equals("Attendance4")){
            attendanceview5.fromAsset(".pdf").load();
        }

    }
}
