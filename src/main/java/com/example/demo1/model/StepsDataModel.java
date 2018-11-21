package com.example.demo1.model;

import lombok.Data;

import java.util.Date;

@Data
public class StepsDataModel {
    private int id;
    private Date date;
    private int steps;
    private int calories;
}
