package com.example.demo1.util;

import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.BaseUrl;

 /**
  * @Description:  过滤用户个人隐私信息的工具类
  */
public class FilterUtils {
    public static UserModel filterUserPrivateInfo(UserModel userModel){
        userModel.setToken("");
        userModel.setPassword("");
        userModel.setSalt("");
        userModel.setPicture(BaseUrl.URL+userModel.getPicture());
        return userModel;
    }
}
