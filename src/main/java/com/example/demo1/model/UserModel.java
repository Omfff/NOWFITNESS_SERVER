package com.example.demo1.model;

import lombok.Data;

@Data
public class UserModel {


    private int id;
    private String userName;
    private String password;
    private double height;
    private double weight;
    private String sex;
    private  int age;
    private String picture;
    private String salt;
    private String token;
    private boolean states;
    private String nickName;

    public UserModel(){
        this.id = 0;
        this.userName = "";
        this.password = "";
        this.height = 0;
        this.weight = 0;
        this.sex = "无";
        this.age = 0;
        this.picture = "";
        this.nickName = "";
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age
                + ", height=" + height + ", weight=" +  weight + ", sex =" + sex
                + ", age =" + age + ", picture =" + picture + "]";
    }

}
