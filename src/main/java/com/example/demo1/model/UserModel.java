package com.example.demo1.model;

import lombok.Data;

@Data
public class UserModel {
    private int id;
    private String userName;
    private String password;
    private int height;
    private double weight;
    private String sex;
    private  int age;
    private String picture;

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age
                + ", height=" + height + ", weight=" +  weight + ", sex =" + sex
                + ", age =" + age + ", picture =" + picture + "]";
    }

}
