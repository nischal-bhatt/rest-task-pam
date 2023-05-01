package com.anotherproject.marksproject;

import java.io.Serializable;

public class Marks implements Serializable {
    private int marks;
    private String anotherField;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getAnotherField() {
        return anotherField;
    }

    public void setAnotherField(String anotherField) {
        this.anotherField = anotherField;
    }
}
