package com.example.gitmguid;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Attendance7Activity extends AppCompatActivity {

    ListView attendance7listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance7);

        attendance7listview = (ListView) findViewById(R.id.atttendance7_listview);
        String[] attendace7files ={"Attendance1", "Attendance2", "Attendance3", "Attendance4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,attendace7files){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView mytext = (TextView) findViewById(R.id.text);
                return view;
            }
        };

        attendance7listview.setAdapter(adapter);

        attendance7listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = attendance7listview.getItemAtPosition(position).toString();
                Intent attendanceopener7 = new Intent(getApplicationContext(),Attendanceopener7Activity.class);
                attendanceopener7.putExtra("FileName",item);
                startActivity(attendanceopener7);

            }
        });
    }
}
