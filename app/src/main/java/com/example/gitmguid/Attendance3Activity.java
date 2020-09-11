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

public class Attendance3Activity extends AppCompatActivity {

    ListView attendace3listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance3);

        attendace3listview = (ListView) findViewById(R.id.attendace3_listview);
        String[] attendacefiles3= {"Attendance1", "Attendance2", "Attendance3", "Attendance4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,attendacefiles3){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView mytext =(TextView) view.findViewById(R.id.text);
                return view;
            }
        };
        attendace3listview.setAdapter(adapter);

        attendace3listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = attendace3listview.getItemAtPosition(position).toString();

                Intent attendanceopener3intent = new Intent(getApplicationContext(),Attendanceopener3Activity.class);
                attendanceopener3intent.putExtra("FileName",item);
                startActivity(attendanceopener3intent);
            }
        });
    }
}
