package com.example.demo1.util;

import com.example.demo1.model.UserModel;

public class FilterUtils {
    public static UserModel filterUserPrivateInfo(UserModel userModel){
        userModel.setToken("");
        userModel.setPassword("");
        userModel.setSalt("");
        return userModel;
    }
}
