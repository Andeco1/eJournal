package com.example.ejournal;

import java.io.Serializable;

public class Parent extends Person implements Serializable {
    public Parent(String fullname, int phone) {
        super(fullname,phone);
    }
}
