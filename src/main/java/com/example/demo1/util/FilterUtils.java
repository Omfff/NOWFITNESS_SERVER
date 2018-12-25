package com.example.demo1.util;

import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.BaseUrl;

public class FilterUtils {
    public static UserModel filterUserPrivateInfo(UserModel userModel){
        userModel.setToken("");
        userModel.setPassword("");
        userModel.setSalt("");
        userModel.setPicture(BaseUrl.URL+userModel.getPicture());
        return userModel;
    }
}
