package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CoursesActivity extends AppCompatActivity {

    Button ebookbtn;
    TextView uploadtext;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ebookbtn = (Button) findViewById( R.id.ebook_btn);
        uploadtext = (TextView) findViewById(R.id.upload_text);

        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ebookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ebookintent = new Intent(CoursesActivity.this,EbookActivity.class);
                startActivity(ebookintent);

            }
        });

        uploadtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CoursesActivity.this,UploadActivity.class);
                startActivity(intent);
            }
        });

    }
}
