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

public class Attendance5Activity extends AppCompatActivity {

    ListView attendance5listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance5);

        attendance5listview = (ListView) findViewById(R.id.attendance5_listview);
        String[] attendancefile5 ={"Attendance1", "Attendance2", "Attendance3", "Attendace4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,attendancefile5){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView mytext = (TextView) findViewById(R.id.text);
                return view;
            }
        };
        attendance5listview.setAdapter(adapter);

        attendance5listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = attendance5listview.getItemAtPosition(position).toString();
                Intent attendanceopener5intent = new Intent(getApplicationContext(),Attendanceopener5Activity.class);
                attendanceopener5intent.putExtra("FileName" ,item);
                startActivity(attendanceopener5intent);
            }
        });
    }
}
