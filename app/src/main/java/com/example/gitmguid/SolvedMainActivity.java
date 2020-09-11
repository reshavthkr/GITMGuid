package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SolvedMainActivity extends AppCompatActivity {

        Button solvedbtn3rd, solvedbtn5th, solvedbtn7th;
        private AdView mAdView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_solved_main);
            solvedbtn3rd = (Button) findViewById(R.id.solved_3rd);
            solvedbtn5th = (Button) findViewById(R.id.solved_5th);
            solvedbtn7th = (Button) findViewById(R.id.solved_7th);

            MobileAds.initialize(this,
                    "ca-app-pub-5671795406066381~4438625691");

            mAdView = findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

            solvedbtn3rd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent solvedpaper3 = new Intent(SolvedMainActivity.this,Solvedpaper3Activity.class);
                    startActivity(solvedpaper3);

                }
            });

            solvedbtn5th.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent solvedpaper5 = new Intent(SolvedMainActivity.this,SolvedpaperActivity.class);
                    startActivity(solvedpaper5);
                }
            });

            solvedbtn7th.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent solvedpaper7 = new Intent(SolvedMainActivity.this,Solvedpaper7Activity.class);
                    startActivity(solvedpaper7);
                }
            });
    }
}
