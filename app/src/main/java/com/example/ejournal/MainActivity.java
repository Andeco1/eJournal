package com.example.ejournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    School NewSchool = new School("МБОУ Новая школа", "В самом центре Челябинска");
    ArrayList<Employee> employees = new ArrayList<>(0);
    ArrayList<Teacher> teachers = new ArrayList<>(0);
    ArrayList<Learner> lerners = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameOfSchool = findViewById(R.id.scool_name);
        nameOfSchool.setText(NewSchool.name);


        for(int i = 1; i<=10;i++){
            String letter = Integer.toString(i);
            employees.add(new Employee("Работник №"+letter,800+i,i,"Должность №"+letter));
            teachers.add(new Teacher("Учитель №"+letter,900+i,i,"Учитель","Квалификация №"+letter));
            ArrayList<String> subjects =new ArrayList<>(Arrays.asList("математика","русский язык","физика","предмет №4","предмет №5","предмет №6","предмет №7","предмет №8","предмет №9","предмет №10"));
            for(int j = 1; j<=10;j++) {
                ArrayList<Integer> marks = new ArrayList<>();
                for(int q = 0; q<360;q++){
                    marks.add((int) (Math.random()*9));
                }
                ArrayList<Marks> grades = new ArrayList<>();
                for(int p = 0;p<10;p++){
                    grades.add(new Marks(subjects.get(p),marks));
                }

                ArrayList<Parent> parent = new ArrayList<>();
                parent.add(new Parent("Родитель 1 ученика №" + Integer.toString((i-1)*10+j), 100 + i));
                parent.add(new Parent("Родитель 2 ученика №" + Integer.toString((i-1)*10+j), 100 + i));
                lerners.add(new Learner("Ученик №" + Integer.toString((i-1)*10+j),i, i, parent,grades,(int) (Math.random()*10)));

            }


        }
        ArrayList<Class> classes = new ArrayList<>();
        for(int i = 0;i< lerners.size()/10;i++) {
            ArrayList<Learner> learn = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                learn.add(lerners.get(i*10+j));
            }
            classes.add(new Class("Класс №"+Integer.toString(i),teachers.get(i),learn));
        }
//        Log.i("1",Integer.toString(teachers.size()));




        Button button_teachers = findViewById(R.id.teacher);
        button_teachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, teachers.class);
                int h;
                for(h = 0;h<teachers.size();h++){
                    intent.putExtra(Integer.toString((h)), teachers.get(h));
                }
                intent.putExtra("size",teachers.size());
                startActivity(intent);
            }

        });


        Button button_learners = findViewById(R.id.learners);
        button_learners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lerners.class);
                int h;
                for(h = 0;h<lerners.size();h++){
                    intent.putExtra(Integer.toString((h)), lerners.get(h));
                }
                intent.putExtra("size",lerners.size());
                startActivity(intent);
            }
        });

        Button button_participants = findViewById(R.id.participant);
        button_participants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, participants.class);
                int h;
                for(h = 0;h<lerners.size();h++){
                    intent.putExtra("learner " +Integer.toString((h)), lerners.get(h));
                }
                intent.putExtra("size learners",lerners.size());
                for(h = 0;h<teachers.size();h++){
                    intent.putExtra("teacher " +Integer.toString((h)), teachers.get(h));
                }
                intent.putExtra("size teachers",teachers.size());
                for(h = 0;h<employees.size();h++){
                    intent.putExtra("employee " +Integer.toString((h)), employees.get(h));
                }
                intent.putExtra("size employees",employees.size());

                startActivity(intent);
            }
        });

        Button button_classes = findViewById(R.id.classes);
        button_classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, class_l_p.class);
                int h;
                for(h = 0;h<classes.size();h++){
                    intent.putExtra(Integer.toString((h)), classes.get(h));
                }
                intent.putExtra("size",classes.size());
                startActivity(intent);
            }
        });

        Button button_ejournal = findViewById(R.id.ejournal);
        button_ejournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ejournal.class);
                int h;
                for(h = 0;h<classes.size();h++){
                    intent.putExtra(Integer.toString((h)), classes.get(h));
                }
                intent.putExtra("size",classes.size());
                startActivity(intent);
            }
        });








    }
}