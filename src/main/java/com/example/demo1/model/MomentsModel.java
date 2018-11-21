package com.example.demo1.model;

import lombok.Data;

import java.util.Date;
@Data
public class MomentsModel {
    private int momentsId;
    private int userId;
    private String content;
    private Date releaseTime;
    private String image;
    private int likes;
}
