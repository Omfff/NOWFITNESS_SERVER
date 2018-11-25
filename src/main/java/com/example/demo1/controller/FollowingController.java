package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.service.FollowingService;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowingController {
    @Autowired
    FollowingService followingService;
    @Autowired
    UserService userService;

    @RequestMapping("/user/followingByName")
    public ConstResponseModel follow(String userName, String followingName){
        ConstResponseModel followingResponse = new ConstResponseModel();
        followingResponse.setResult(followingService.following(userService.findUserId(userName),userService.findUserId(followingName)));
        return followingResponse;
    }

    @RequestMapping("/user/followingById")
    public ConstResponseModel follow(int userId, int followId){
        ConstResponseModel followingResponse = new ConstResponseModel();
        followingResponse.setResult(followingService.following(userId,followId));
        return followingResponse;
    }

    @RequestMapping("/user/cancelFollowingByName")
    public ConstResponseModel cancelFollowing(String userName, String followingName){
        ConstResponseModel followingResponse = new ConstResponseModel();
        followingResponse.setResult(followingService.cancelFollow(userService.findUserId(userName),userService.findUserId(followingName)));
        return followingResponse;
    }

    //还没修改
    @RequestMapping("/user/getAllFollowingIds")
    public int[] getAllFollowing(int userId){
        return followingService.findUserFollowingId(userId);
    }

    @RequestMapping("/user/getAllFollowingUsers")
    public List<UserModel> getAllFollowingUsers(int userId){
        return followingService.getFollowinguUser(userId);
    }

}
