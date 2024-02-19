package com.example.ejournal;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable {
    String name;
    ArrayList<Learner> learners = new ArrayList<>();
    Teacher classTeacher;
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
