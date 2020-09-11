package com.example.gitmguid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadActivity extends AppCompatActivity {

    Button uploadbtn;
    TextView textviewstatus, marqeetxt;
    EditText editText;
    private AdView mAdView;
    ProgressBar progressBar;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        textviewstatus = (TextView) findViewById(R.id.textviewStatus);
        marqeetxt = (TextView) findViewById(R.id.marqee);
        editText = (EditText) findViewById(R.id.edit_text);
        uploadbtn = (Button ) findViewById(R.id.upload_btn);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        MobileAds.initialize(this,
                "ca-app-pub-5671795406066381~4438625691");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        marqeetxt.setSelected(true);

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("uploads");

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectPDFFile();

            }
        });


    }
    private  void selectPDFFile(){

        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF File"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK
                && data != null && data.getData() != null){

            if (data.getData() !=null) {

                uploadPDFFile(data.getData());
            }else{
                Toast.makeText(this,"No File Chosen",Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void uploadPDFFile(Uri data) {

        //final ProgressDialog progressDialog = new ProgressDialog(this);
        progressBar.setVisibility(View.VISIBLE);
       // progressDialog.setTitle("Its loading...");
       // progressDialog.show();

        StorageReference reference = storageReference.child("uploads/" +System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        progressBar.setVisibility(View.GONE);
                        textviewstatus.setText("File Uploaded Sucessfully");

                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete());
                        Uri url = uri.getResult();

                        uploadPDF uploadPDF = new uploadPDF(editText.getText().toString(),url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDF);
                       // Toast.makeText(UploadActivity.this,"File Uploaded", Toast.LENGTH_SHORT).show();
                        //progressDialog.dismiss();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                textviewstatus.setText((int) progress +"%Uploading...");

                //progressDialog.setMessage("Uploaded:" +(int)progress+"%");

            }
        });

    }
}
