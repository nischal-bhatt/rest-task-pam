package com.example.demo.model;

import java.io.Serializable;

public class MarksConverter implements Serializable {

    private String marks;
    private String anotherField;

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getAnotherField() {
        return anotherField;
    }

    public void setAnotherField(String anotherField) {
        this.anotherField = anotherField;
    }
}
