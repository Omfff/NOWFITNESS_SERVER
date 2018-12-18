package com.example.demo1.model;

import lombok.Data;

import java.util.Date;

@Data
public class RepliesModel {
    private int id;
    private int commentId;
    private int fromUserId;
    private int toUserId;
    private String replyType;
    private String content;
    private Date replyTime;
    private int replyId;

    private String fromUserName;
    private String toUserName;

    private String fromUserNickName;
    private String toUserNickName;
}
