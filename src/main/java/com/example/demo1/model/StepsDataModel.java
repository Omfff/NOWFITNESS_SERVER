package com.example.demo1.model;

import lombok.Data;

import java.util.Date;

@Data
public class StepsDataModel {
    private int id;
    private Date date;
    private int steps;
    private int calories;
    public StepsDataModel(int userId,int steps,int calories){
        this.id =userId;
        this.steps = steps;
        this.calories =calories;
    }
    public StepsDataModel(){}
}
