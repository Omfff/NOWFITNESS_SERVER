package com.example.demo1.controller;

import com.example.demo1.model.constValue.FollowingConstResponse;
import com.example.demo1.model.response.*;
import com.example.demo1.model.UserModel;
import com.example.demo1.service.FollowingService;
import com.example.demo1.service.UserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class FollowingController {
    @Autowired
    FollowingService followingService;
    @Autowired
    UserService userService;

    /*@RequestMapping(value = "/user/{userName}/following/{followingName}",method = RequestMethod.POST)
    public BaseResponse follow(@PathVariable("userName") String userName, @PathVariable("followingName")String followingName){
        String result = followingService.following(userService.findUserId(userName),userService.findUserId(followingName));
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.CREATED
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/"+userName+"/following/"+followingName
                ,null);
        if(!result.equals(FollowingConstResponse.FOLLOWING_SUCCEED)){
            baseResponse.setStatus(Code.OK);
        }
        return baseResponse;
    }*/

    @RequestMapping(value = "/user/{userId}/following/{followId}",method = RequestMethod.POST)
    public BaseResponse follow(@PathVariable("userId")int userId, @PathVariable("followId") int followId){
        String result = followingService.following(userId,followId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.CREATED
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/"+String.valueOf(userId)+"/following/"+String.valueOf(followId)
                ,null);
        if(!result.equals(FollowingConstResponse.FOLLOWING_SUCCEED))
            baseResponse.setStatus(Code.OK);
        return baseResponse;
    }

    @RequestMapping(value = "/user/{userId}/following/{followId}",method = RequestMethod.DELETE)
    public BaseResponse cancelFollowing(@PathVariable("userId")int userId, @PathVariable("followId") int followId){
       String result = followingService.cancelFollow(userId,followId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.NO_CONTENT
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/"+String.valueOf(userId)+"/following/"+String.valueOf(followId)
                ,null);
        return baseResponse;
    }

    //还没修改
    /*@RequestMapping(value = "/user/{userId}/following",method = RequestMethod.GET)
    public BaseResponse getAllFollowing(@PathVariable("userId") int userId){
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(userId)+"/following"
                ,followingService.findUserFollowingId(userId));
        return baseResponse;
    }*/

    @RequestMapping(value = "/user/{userId}/following",method = RequestMethod.GET)
    public BaseResponse getAllFollowingUsers(@PathVariable("userId") int userId){
        FollowingResposnseModel followingResposnseModel = new FollowingResposnseModel();
        followingResposnseModel.setUsers(followingService.getFollowinguUser(userId));
        if(followingResposnseModel.getUsers()!=null)
            followingResposnseModel.setTotalNum(followingResposnseModel.getUsers().size());
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(userId)+"/following"
                ,followingResposnseModel);
        return baseResponse;
    }

    @RequestMapping(value = "/user/{userId}/fans",method = RequestMethod.GET)
    public BaseResponse getFans(@PathVariable("userId")int userId){
        FollowingResposnseModel fansResposnseModel = new FollowingResposnseModel();
        fansResposnseModel.setUsers(followingService.findUserFans(userId));
        if(fansResposnseModel.getUsers()!=null)
            fansResposnseModel.setTotalNum(fansResposnseModel.getUsers().size());
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(userId)+"/fans"
                ,fansResposnseModel);
        return baseResponse;
    }
    @RequestMapping(value = "/user/{userId}/anotherUser/{anotherUserId}",method = RequestMethod.GET)
    public BaseResponse isFollowing(@PathVariable("userId")int userId,@PathVariable("anotherUserId")int anotherUserId){
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(userId)+"/anotherUser/"+String.valueOf(anotherUserId)
                ,new IsFollowingResponseModel(followingService.checkFollowingStates(userId,anotherUserId)));
        return baseResponse;
    }


}
