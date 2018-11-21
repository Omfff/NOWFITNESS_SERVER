package com.example.demo1.service;

import com.example.demo1.mapper.FollowingMapper;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.response.FollowingConstReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowingService {
    @Autowired
    FollowingMapper followingMapper;
    @Autowired
    UserMapper userMapper;

    public int following(int userId,int followId){
        if(userId>0&&followId>0) {
            followingMapper.following(userId, followId);
            return FollowingConstReponse.FOLLOWING_SUCCEED;
        }else{
            return FollowingConstReponse.FOLLOWING_FAILED;
        }
    }

    public int cancelFollow(int userId,int followId){
        if(userId>0&&followId>0) {
            followingMapper.notFollowing(userId, followId);
            return FollowingConstReponse.FOLLOWING_SUCCEED;
        }else{
            return FollowingConstReponse.CANCEL_FOLLOWING_FAILED;
        }
    }

    public int[] findUserFollowingId(int userId){
        return followingMapper.findUserFollowingIds(userId);
    }

    public List<UserModel> getFollowinguUser(int userId){
        int [] followingIds = followingMapper.findUserFollowingIds(userId);
        List<UserModel> followingUsers = new ArrayList<>();
        for(int id:followingIds){
            followingUsers.add(userMapper.findById(id));
        }
        return followingUsers;
    }
}
