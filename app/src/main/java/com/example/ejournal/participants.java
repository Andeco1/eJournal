package com.example.ejournal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class participants extends AppCompatActivity implements Serializable {

    ArrayList<String> participants = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participants);
        for(int i = 0; i<getIntent().getIntExtra("size learners",0);i++){
            participants.add(((Learner) getIntent().getExtras().getSerializable("learner "+Integer.toString(i))).getName());
        }
        for(int i = 0; i<getIntent().getIntExtra("size teachers",0);i++){
            participants.add(((Teacher) getIntent().getExtras().getSerializable("teacher "+Integer.toString(i))).getName());
        }
        for(int i = 0; i<getIntent().getIntExtra("size employees",0);i++){
            participants.add(((Employee) getIntent().getExtras().getSerializable("employee "+Integer.toString(i))).getName());
        }
        Log.i("1",Integer.toString(participants.size()));
        ListView participants_list = findViewById(R.id.participants_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,participants);
        participants_list.setAdapter(adapter);


        Button button_back = findViewById(R.id.go_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
