package com.example.gitmguid;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<uploadPDF> uploadPDFs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);



        listView = (ListView) findViewById(R.id.list_view);
        uploadPDFs = new ArrayList<>();


        viewAllFiles();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                uploadPDF uploadPDF = uploadPDFs.get(position);
                Intent intent = new Intent();
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);
            }
        });


    }

    private void viewAllFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] uploads = new String[uploadPDFs.size()];
                for (int i = 0; i < uploads.length; i++) {

                    uploads[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads)
                {
                    @NonNull
                    @Override
                    public View getView(int position, View convertView,  ViewGroup parent) {


                        View view = super.getView(position, convertView, parent);
                        TextView mytext = (TextView) view.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.WHITE);
                        return view;
                    }
                };

                listView .setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });
    }
}
