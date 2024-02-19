package com.example.ejournal;

import java.io.Serializable;

public class Teacher extends Participant implements Serializable {
    String position;
    String qualification;

    public Teacher(String fullname, int phone, int CardID,String position,String qualification) {
        super(fullname, phone, CardID);
        this.position = position;
        this.qualification = qualification;
    }

    public String getTeacher() {
        return fullname+" "+qualification;
    }
    public String getName() {
        return fullname;
    }

}
