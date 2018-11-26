package com.example.demo1.controller;

import com.example.demo1.model.DailyCheckModel;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.response.UserInfoResponseModel;
import com.example.demo1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private FollowingService followingService;
    @Autowired
    private DailyCheckService dailyCheckService;
    @Autowired
    private MomentsService  momentsService;

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
    public UserInfoResponseModel getUserInformation(String userName,String password){
       UserModel userModel = userService.getUserInformation(userName,password);
        UserInfoResponseModel userInfoResponseModel = new UserInfoResponseModel();
       if(userModel!=null) {
           int userId = userModel.getId();
           userInfoResponseModel.setId(userId);
           userInfoResponseModel.setAge(userModel.getAge());
           userInfoResponseModel.setUserName(userModel.getUserName());
           userInfoResponseModel.setPassword(userModel.getPassword());
           userInfoResponseModel.setHeight(userModel.getHeight());
           userInfoResponseModel.setWeight(userModel.getWeight());
           userInfoResponseModel.setSex(userModel.getSex());
           userInfoResponseModel.setAge(userModel.getAge());
           userInfoResponseModel.setPicture(userModel.getPicture());

           userInfoResponseModel.setFollowing(followingService
                   .getFollowinguUser(userId)
                   .size());
           userInfoResponseModel.setFans(followingService.findUserFansId(userId).length);
           userInfoResponseModel.setMomentsNum(momentsService.selectUserAllMoments(userId).size());
           List<DailyCheckModel> dailyCheckModelList = dailyCheckService.getUserAllDailyCheck(userModel.getId());
           List<Date> dailyCheckList = new ArrayList<>();
           for(DailyCheckModel dailyCheckModel :dailyCheckModelList){
               dailyCheckList.add(dailyCheckModel.getDate());
           }
           userInfoResponseModel.setDailyCheckList(dailyCheckList);
       }
        return userInfoResponseModel;
    }

    @RequestMapping(value = "/user/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    ConstResponseModel upload(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        ConstResponseModel userReponse = new ConstResponseModel();
        userReponse.setResult(photoService.upLoadUserPhoto(file,id));
        return userReponse;
    }
}
