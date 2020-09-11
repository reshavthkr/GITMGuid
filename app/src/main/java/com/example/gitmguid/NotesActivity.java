package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class NotesActivity extends AppCompatActivity {

    Button notesbtn3rd, notesbtn5th, notesbtn7th;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        notesbtn3rd = (Button) findViewById(R.id.notes_3rd);
        notesbtn5th = (Button) findViewById(R.id.notes_5th);
        notesbtn7th = (Button) findViewById(R.id.notes_7th);

        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

      //  notesbtn3rd.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {

             //   Intent notes3intent = new Intent(NotesActivity.this,Notes3Activity.class);
          //      startActivity(notes3intent);

        //    }
       // });

        notesbtn5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent notes3intent = new Intent(NotesActivity.this,Notes5Activity.class);
                startActivity(notes3intent);

            }
        });

        notesbtn7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
