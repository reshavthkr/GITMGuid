package com.example.gitmguid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button timetablebtn, attendacebtn, notesbtn, coursebtn, solvedbtn, privacybtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        timetablebtn = (Button) findViewById(R.id.timetable_btn);
        attendacebtn = (Button) findViewById(R.id.attendance_btn);
        notesbtn = (Button) findViewById(R.id.notes_btn);
        coursebtn = (Button) findViewById(R.id.course_btn);
        solvedbtn = (Button) findViewById(R.id.solved_papers);
        privacybtn = (Button) findViewById(R.id.privacy);



        timetablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timetableintent = new Intent(HomeActivity.this,TimetableActivity.class);
                startActivity(timetableintent);
            }
        });

        attendacebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attendanceintent = new Intent(HomeActivity.this,AttendanceActivity.class);
                startActivity(attendanceintent);
            }
        });

        solvedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent solvedpaperintent = new Intent( HomeActivity.this,SolvedMainActivity.class);
                startActivity(solvedpaperintent);
            }
        });

        coursebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent courseintent = new Intent(HomeActivity.this,CoursesActivity.class);
                startActivity(courseintent);
            }
        });

        privacybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent privactintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/gitmguid/home"));
                startActivity(privactintent);
            }
        });

        notesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notesintent = new Intent(HomeActivity.this,NotesActivity.class);
                startActivity(notesintent);
            }
        });
    }
}
