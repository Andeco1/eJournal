package com.example.ejournal;

import java.io.Serializable;

public class Person implements Serializable {
    String fullname;
    int phone;

    public Person(String fullname, int phone) {
        this.fullname = fullname;
        this.phone = phone;
    }


}
