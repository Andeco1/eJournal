package com.example.ejournal;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
    String number;
    Teacher ClassTeacher;
    ArrayList<Learner> learners = new ArrayList<>();

    public Class(String number, Teacher classTeacher, ArrayList<Learner> learners) {
        this.number = number;
        ClassTeacher = classTeacher;
        this.learners = learners;
    }

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
