package com.example.demo1.service;

import com.example.demo1.mapper.FollowingMapper;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.FollowingConstResponse;
import com.example.demo1.util.FilterUtils;
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

    public String following(int userId,int followId){
        if(followingMapper.checkFollowExisted(userId,followId)==false) {
            followingMapper.following(userId, followId);
            return FollowingConstResponse.FOLLOWING_SUCCEED;
        }else{
            return FollowingConstResponse.FOLLOWING_EXISTED;
        }
    }

    public String cancelFollow(int userId,int followId){
        if(followingMapper.checkFollowExisted(userId,followId)==true) {
            followingMapper.notFollowing(userId, followId);
            return FollowingConstResponse.CANCEL_FOLLOWING_SUCCEED;
        }else{
            return FollowingConstResponse.CANCEL_FOLLOWING_FAILED;
        }
    }


    public int[] findUserFansId(int userId){return followingMapper.findUserFans(userId);}
    public List<UserModel> getFollowinguUser(int userId){
        int [] followingIds = followingMapper.findUserFollowingIds(userId);
        List<UserModel> followingUsers = new ArrayList<>();
        for(int id:followingIds){
            followingUsers.add(FilterUtils.filterUserPrivateInfo(userMapper.findById(id)));
        }
        return followingUsers;
    }
    public List<UserModel> findUserFans(int userId){
        int [] fansIdList = followingMapper.findUserFans(userId);
        List<UserModel> fansList = new ArrayList<>();
        for(int i=0;i<fansIdList.length;i++){
            fansList.add(FilterUtils.filterUserPrivateInfo(userMapper.findById(fansIdList[i])));
            fansList.get(i).setStates(followingMapper.checkFollowExisted(userId,fansIdList[i]));
        }
        return fansList;
    }
    public boolean checkFollowingStates(int userId,int followId){
        return followingMapper.checkFollowExisted(userId,followId);
    }
}
