package com.example.ejournal;

import java.io.Serializable;
import java.util.ArrayList;

public class Elective implements Serializable {
    String academicSubject;
    ArrayList<Learner> learners = new ArrayList<>();
    Teacher ClassTeacher;
    public ArrayList<Learner> getList() {
        return learners;
    }
    public ArrayList<Person> getListParents(){
        ArrayList<Person> people = new ArrayList<>();
        for(Learner learner: learners){
            people.add(learner);
            people.add(learner.getParents().get(0));
            people.add(learner.getParents().get(1));
        }
        return people;
    }
}
