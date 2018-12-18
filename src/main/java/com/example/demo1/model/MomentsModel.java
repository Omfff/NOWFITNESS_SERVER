package com.example.demo1.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MomentsModel {
    private int momentsId;
    private int userId;

    private String userPhoto;
    private String userName;
    private String nickName;

    private String content;
    private Date releaseTime;
    private String image;
    private int likes;

    private int commentsNum;
    private boolean isLiked;
    private List<String> likesName;
    //private List<CommentsModel> commentsModelList;


}
