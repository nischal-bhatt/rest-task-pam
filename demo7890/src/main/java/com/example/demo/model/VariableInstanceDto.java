package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class VariableInstanceDto implements Serializable {

    @JsonProperty("variable-instance")
    private List<VariableInstance> variableInstanceList;


    public List<VariableInstance> getVariableInstanceList() {
        return variableInstanceList;
    }

    public void setVariableInstanceList(List<VariableInstance> variableInstanceList) {
        this.variableInstanceList = variableInstanceList;
    }
}
