package com.example.gitmguid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Attendanceopener7Activity extends AppCompatActivity {

    PDFView attendanceviewer7;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendanceopener7);

        attendanceviewer7 = (PDFView) findViewById(R.id.attendance_viewer7);

        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        String getItem = getIntent().getStringExtra("FileName");

        if(getItem.equals("Attendance1")){
            attendanceviewer7.fromAsset(".pdf").load();
        }


        if(getItem.equals("Attendance2")){
            attendanceviewer7.fromAsset(".pdf").load();
        }

        if(getItem.equals("Attendance3")){
            attendanceviewer7.fromAsset(".pdf").load();
        }
        if(getItem.equals("Attendance4")){
            attendanceviewer7.fromAsset(".pdf").load();
        }
    }




}
