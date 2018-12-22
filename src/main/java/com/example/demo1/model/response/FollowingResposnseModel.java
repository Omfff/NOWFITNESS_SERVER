package com.example.demo1.model.response;

import com.example.demo1.model.UserModel;
import lombok.Data;

import java.util.List;

@Data
public class FollowingResposnseModel {
    int totalNum;
    List<UserModel> users;
}
