package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Notes5Activity extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes5);

        listView1 = (ListView) findViewById(R.id.list_view1);
        String[] Subjects= {"Computer Graphics", "Microprocessors and Interfacing", "Multimedia Technology",
                "Theory of Automata Computation", "Web Development", "Pricniple of Operating System"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Subjects){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView mytext =(TextView) view.findViewById(R.id.text);
                return view;
            }
        };

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                String item = listView1.getItemAtPosition(i).toString();

                Intent notes5sub = new Intent(getApplicationContext(),Notes5subActivity.class);
                notes5sub.putExtra("SubjectName",item);
                startActivity(notes5sub);
            }
        });

    }
}
