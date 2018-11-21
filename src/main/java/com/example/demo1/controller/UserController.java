package com.example.demo1.controller;

import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.UserModel;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public String  login(UserModel userModel) {
        return userService.login(userModel);

    }

    @RequestMapping("/user/register")
    public String register(UserModel userModel){
        userModel.setAge(0);
        userModel.setHeight(0);
        userModel.setPicture("");
        userModel.setWeight(0);
        userModel.setSex("");
         return userService.register(userModel);
    }

    @RequestMapping("/user/update")
    public String updateUserDate(UserModel userModel){
        return userService.updateUserDate(userModel);
    }

    @RequestMapping("/user/information")
    public UserModel getUserInformation(String userName,String password){
        return userService.getUserInformation(userName,password);
    }
}
