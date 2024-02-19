package com.example.ejournal;

public class Employee extends Participant{
    String position;

    public Employee(String fullname, int phone, int CardID,String position) {
        super(fullname, phone, CardID);
        this.position = position;
    }
    public String getName() {
        return fullname;
    }
}
