package com.example.demo1.model;

import lombok.Data;

import java.sql.Date;


@Data
public class DailyCheckModel {
    private int id;
    private int userId;
    private String date;
}
