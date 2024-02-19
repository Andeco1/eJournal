package com.example.ejournal;

import java.io.Serializable;
import java.util.ArrayList;

public class Marks implements Serializable {
    String subject_name;
    ArrayList<Integer> marks1 = new ArrayList<>();

    public Marks(String subject_name, ArrayList<Integer> marks) {
        this.subject_name = subject_name;
        this.marks1 = marks;
    }
}
