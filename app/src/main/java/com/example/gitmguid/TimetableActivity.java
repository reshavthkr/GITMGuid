package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class TimetableActivity extends AppCompatActivity {

    Button btn3rd, btn5th, btn7th;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        btn3rd = (Button) findViewById(R.id.btn_3rd);
        btn5th = (Button) findViewById(R.id.btn_5th);
        btn7th = (Button) findViewById(R.id.btn_7th);


        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timetable3intent = new Intent(TimetableActivity.this,Time3Activity.class);
                startActivity(timetable3intent);
            }
        });

        btn5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timetable5intent = new Intent(TimetableActivity.this,Time5Activity.class);
                startActivity(timetable5intent);
            }
        });

        btn7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timetable7intent = new Intent(TimetableActivity.this,Time7Activity.class);
                startActivity(timetable7intent);
            }
        });

    }
}
