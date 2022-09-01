package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Recycler_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView programmingList = findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        String[] langueges = {"Java","JavaScript","C#","C","Dart","Swift","Python","Java","JavaScript","C#","C","Dart","Swift","Python","Java","JavaScript","C#","C","Dart","Swift","Python",
                "Java","JavaScript","C#","C","Dart","Swift","Python","Java","JavaScript","C#","C","Dart","Swift","Python"};
        programmingList.setAdapter(new ProgrammingAdapter(langueges));
    }
}