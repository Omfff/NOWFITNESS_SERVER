package com.example.demo1.controller;

import com.example.demo1.model.MomentsModel;
import com.example.demo1.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class MomentsController {
    @Autowired
    private MomentsService momentsService;

    @RequestMapping("/moments/release")
    public int releaseMoments(MomentsModel momentsModel){
        return momentsService.insertMoments(momentsModel);
    }

    @RequestMapping("/moments/delete")
    public void deleteMoments(int momentsId){
        momentsService.deleteUserMoments(momentsId);
    }

    @RequestMapping("/moments/getUser")
    public List<MomentsModel> getUserMoments(int userId){
        return momentsService.selectUserAllMoments(userId);
    }

    @RequestMapping("/moments/getFollowing")
    public List<MomentsModel> getAllFollowingMoments(int userId){
        return momentsService.getAllFollowingMoments(userId);
    }

}
