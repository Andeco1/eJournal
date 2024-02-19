package com.example.ejournal;

import java.io.Serializable;
import java.util.ArrayList;

public class School implements Serializable {
    public School(String name, String address) {
        this.address = address;
        this.name = name;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setLearners(ArrayList<Learner> learners) {
        this.learners = learners;
    }

    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Learner> learners = new ArrayList<>();
    String address;
    String name;
    ArrayList<Class> classes = new ArrayList<>();
    ArrayList<Elective> electives = new ArrayList<>();
    ArrayList<Section> sections = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Learner> getLearners() {
        return learners;
    }

}
