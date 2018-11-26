package com.example.demo1.model.response;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class UserInfoResponseModel {
    private int id;
    private String userName;
    private String password;
    private double height;
    private double weight;
    private String sex;
    private  int age;
    private String picture;

    private int following;
    private int fans;
    private int momentsNum;

    private List<Date> dailyCheckList;

}