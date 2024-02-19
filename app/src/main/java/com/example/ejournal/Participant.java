package com.example.ejournal;

import java.io.Serializable;

public class Participant extends Person implements Serializable {
    int CardID;

    public Participant(String fullname, int phone, int CardID) {
        super(fullname, phone);
        this.CardID = CardID;
    }
}
