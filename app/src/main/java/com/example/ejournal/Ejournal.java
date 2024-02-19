package com.example.ejournal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejournal extends AppCompatActivity implements Serializable {
    ArrayList<Class> allClasses = new ArrayList<>(0);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejournal);

        for(int i = 0; i<getIntent().getIntExtra("size",0);i++){
            allClasses.add(((Class) getIntent().getExtras().getSerializable(Integer.toString(i))));
        }


        ArrayList<String> nameOfClasses = new ArrayList<>(0);
        for(int i = 0; i<allClasses.size();i++){
            nameOfClasses.add(allClasses.get(i).number);
        }
        Spinner classes = findViewById(R.id.classes_spinner);
        ArrayAdapter<String> adapter_classes = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nameOfClasses);
        adapter_classes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classes.setAdapter(adapter_classes);


        ArrayList<String> nameOfweeks = new ArrayList<>(0);
        for(int i = 1;i<=52;i++){
            nameOfweeks.add(Integer.toString(i));
        }
        Spinner weeks = findViewById(R.id.weeks_spinner);
        ArrayAdapter<String> adapter_weeks = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nameOfweeks);
        adapter_weeks.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weeks.setAdapter(adapter_weeks);


        ArrayList<String> subjects =new ArrayList<>(Arrays.asList("математика","русский язык","физика","предмет №4","предмет №5","предмет №6","предмет №7","предмет №8","предмет №9","предмет №10"));
        Spinner sub= findViewById(R.id.subjects_spinner);
        ArrayAdapter<String> adapter_subjects= new ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects);
        adapter_subjects.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub.setAdapter(adapter_subjects);

        Button Show = findViewById(R.id.show);
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nOFc = classes.getSelectedItem().toString();
                int week = Integer.parseInt(weeks.getSelectedItem().toString());
                String subject = sub.getSelectedItem().toString();
                ArrayList<Learner> pupil = new ArrayList<>(0);

                for(int i = 0;i<allClasses.size();i++){
                    if(allClasses.get(i).number == nOFc){
                        pupil = allClasses.get(i).learners;
                        break;
                    }
                }
                ArrayList<Learner> new_learns = new ArrayList<>(0);
                for(int i =0; i<pupil.size();i++){
                    new_learns.add(new Learner(pupil.get(i),subject,week));
                }
                adapter_ejournal adapter_marks = new adapter_ejournal(com.example.ejournal.Ejournal.this,new_learns);
                ListView lv = findViewById(R.id.listOfMarks);
                lv.setAdapter(adapter_marks);

            }
        });



        Button button_back = findViewById(R.id.go_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ejournal.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
