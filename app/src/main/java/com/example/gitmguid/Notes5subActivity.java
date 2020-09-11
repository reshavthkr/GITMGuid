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

public class Notes5subActivity extends AppCompatActivity {

    ListView notes5lst;
    DatabaseReference databaseReference;
    List<uploadPDF> uploadPDFs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes5sub);

        notes5lst = (ListView) findViewById(R.id.notes5sub_lst);
        uploadPDFs = new ArrayList<>();

        notes5lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                uploadPDF uploadPDF = uploadPDFs.get(position);
                Intent intent = new Intent();
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);
            }
        });

        String getItem =getIntent().getStringExtra("SubjectName");

        if(getItem.equals("Computer Graphics")){

            viewAllFiles();
        }
        if(getItem.equals("Microprocessors and Interfacing")){

            viewAllFiles1();
        }

        if(getItem.equals("Multimedia Technology")){

            viewAllFiles2();
        }

        if(getItem.equals("Theory of Automata Computation")){

            viewAllFiles3();
        }

        if(getItem.equals("Web Development")){

            viewAllFiles4();
        }

        if(getItem.equals("Pricniple of Operating System")){

            viewAllFiles5();
        }

    }

    private void viewAllFiles5() {


        databaseReference = FirebaseDatabase.getInstance().getReference("Principle_of_Operating_System");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] Principle_of_Operating_System = new String[uploadPDFs.size()];
                for (int i = 0; i < Principle_of_Operating_System.length; i++) {

                    Principle_of_Operating_System[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Principle_of_Operating_System)
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

                notes5lst .setAdapter(adapter5);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }

    private void viewAllFiles4() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Web_Development");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] Web_Development = new String[uploadPDFs.size()];
                for (int i = 0; i < Web_Development.length; i++) {

                    Web_Development[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Web_Development)
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

                notes5lst .setAdapter(adapter4);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }

    private void viewAllFiles3() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Theory_of_Automata_Computation");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] Theory_of_Automata_Computation = new String[uploadPDFs.size()];
                for (int i = 0; i < Theory_of_Automata_Computation.length; i++) {

                    Theory_of_Automata_Computation[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Theory_of_Automata_Computation)
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

                notes5lst .setAdapter(adapter3);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }

    private void viewAllFiles2() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Multimedia_Technology");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] Multimedia_Technology = new String[uploadPDFs.size()];
                for (int i = 0; i < Multimedia_Technology.length; i++) {

                    Multimedia_Technology[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Multimedia_Technology)
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

                notes5lst .setAdapter(adapter2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });



    }

    private void viewAllFiles1() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Microprocessors_and_Interfacing");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] Microprocessors_and_Interfacing = new String[uploadPDFs.size()];
                for (int i = 0; i < Microprocessors_and_Interfacing.length; i++) {

                    Microprocessors_and_Interfacing[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Microprocessors_and_Interfacing)
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

                notes5lst .setAdapter(adapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }

    private void viewAllFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Computer_Graphics");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.gitmguid.uploadPDF.class);
                    uploadPDFs.add(uploadPDF);


                }

                String[] Computer_Graphics = new String[uploadPDFs.size()];
                for (int i = 0; i < Computer_Graphics.length; i++) {

                    Computer_Graphics[i] = uploadPDFs.get(i).getName();


                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Computer_Graphics)
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

                notes5lst .setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }
}
