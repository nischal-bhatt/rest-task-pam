package com.anotherproject.marksproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MarksInformation implements Serializable {

    @JsonProperty("marks")
    Marks marksInformationInner;

    public Marks getMarksInformationInner() {
        return marksInformationInner;
    }

    public void setMarksInformationInner(Marks marksInformationInner) {
        this.marksInformationInner = marksInformationInner;
    }
}
