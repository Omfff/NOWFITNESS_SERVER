package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.service.PhotoService;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;

    // /user/login?userName=xxx&password=xxxx
    @RequestMapping("/user/login")
    public ConstResponseModel login(UserModel userModel) {
        ConstResponseModel userReponse = new ConstResponseModel();
        userReponse.setResult(userService.login(userModel));
        return userReponse;
    }
    // /user/register?userName=xxx&password=xxxx
    @RequestMapping("/user/register")
    public ConstResponseModel register(UserModel userModel){
        userModel.setAge(0);
        userModel.setHeight(0);
        userModel.setPicture("");
        userModel.setWeight(0);
        userModel.setSex("");
        ConstResponseModel userReponse = new ConstResponseModel();
        userReponse.setResult(userService.register(userModel));
         return userReponse;
    }

    @RequestMapping("/user/update")
    public ConstResponseModel updateUserDate(UserModel userModel){
        ConstResponseModel userReponse = new ConstResponseModel();
        userReponse.setResult(userService.updateUserDate(userModel));
        return userReponse;
    }

    // /user/information?userName=xxx&password=xxx
    @RequestMapping("/user/information")
    public UserModel getUserInformation(String userName,String password){
        return userService.getUserInformation(userName,password);
    }

    @RequestMapping(value = "/user/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    ConstResponseModel upload(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        ConstResponseModel userReponse = new ConstResponseModel();
        userReponse.setResult(photoService.upLoadUserPhoto(file,id));
        return userReponse;
    }
}
