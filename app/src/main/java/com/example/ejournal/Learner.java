package com.example.ejournal;

import java.io.Serializable;
import java.util.ArrayList;

public class Learner extends Participant implements Serializable {
    ArrayList<Parent> parents = new ArrayList<>();
    ArrayList<Marks> marks = new ArrayList<>();

    String subject;
    int week;

    int age;

    public Learner(String fullname, int phone, int CardID, ArrayList<Parent> parents,ArrayList<Marks> marks,int age) {
        super(fullname, phone, CardID);
        this.parents = parents;
        this.marks = marks;
        this.age = age;
    }

    public Learner(Learner lerner,String subject,int week) {
        super(lerner.fullname,lerner.phone,lerner.CardID);
        this.parents = lerner.parents;
        this.marks = lerner.marks;
        this.age = lerner.age;
        this.subject = subject;
        this.week = week;

    }

    public String getLearner() {
        return fullname+" Возраст: "+ age;
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public String getName() {
        return fullname;
    }
}
