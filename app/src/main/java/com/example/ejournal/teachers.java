package com.example.ejournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class teachers extends AppCompatActivity implements Serializable {
    ArrayList<String> classes = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers);

        for(int i = 0; i<getIntent().getIntExtra("size",0);i++){
            classes.add(((Teacher) getIntent().getExtras().getSerializable(Integer.toString(i))).getTeacher());
        }
        ListView teachers_list = findViewById(R.id.teachers_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,classes);
        teachers_list.setAdapter(adapter);


        Button button_back = findViewById(R.id.go_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teachers.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
