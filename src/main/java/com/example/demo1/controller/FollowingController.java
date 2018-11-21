package com.example.demo1.controller;

import com.example.demo1.mapper.FollowingMapper;
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
    public int follow(String userName,String followingName){
        return followingService.following(userService.findUserId(userName),userService.findUserId(followingName));
    }

    @RequestMapping("/user/followingById")
    public int follow(int userId,int followId){
        return followingService.following(userId,followId);
    }

    @RequestMapping("/user/cancelFollowingByName")
    public int cancelFollowing(String userName,String followingName){
        return followingService.cancelFollow(userService.findUserId(userName),userService.findUserId(followingName));
    }

    @RequestMapping("/user/getAllFollowingIds")
    public int[] getAllFollowing(int userId){
        return followingService.findUserFollowingId(userId);
    }

    @RequestMapping("/user/getAllFollowingUsers")
    public List<UserModel> getAllFollowingUsers(int userId){
        return followingService.getFollowinguUser(userId);
    }

}
