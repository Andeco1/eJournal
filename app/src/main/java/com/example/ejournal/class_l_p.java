package com.example.ejournal;

import android.content.Intent;
import android.os.Bundle;
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

public class class_l_p extends AppCompatActivity implements Serializable {
    ArrayList<Class> class_l_p = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes);

        for(int i = 0; i<getIntent().getIntExtra("size",0);i++){
            class_l_p.add(((Class) getIntent().getExtras().getSerializable(Integer.toString(i))));
        }

        ArrayList<String> nameOfClasses = new ArrayList<>(0);
        for(int i = 0; i<class_l_p.size();i++){
            nameOfClasses.add(class_l_p.get(i).number);
        }
        Spinner classes = findViewById(R.id.class_check);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nameOfClasses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classes.setAdapter(adapter);


        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                for(int i = 0;i<class_l_p.size();i++){
                    if(class_l_p.get(i).number == item){
                        adapter_learnres_and_parents adapt = new adapter_learnres_and_parents(com.example.ejournal.class_l_p.this,class_l_p.get(i).learners);
                        ListView lv = findViewById(R.id.classes_list);
                        lv.setAdapter(adapt);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        classes.setOnItemSelectedListener(itemSelectedListener);

        Button button_back = findViewById(R.id.go_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(class_l_p.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
