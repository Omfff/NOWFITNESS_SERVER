package com.example.demo1.service;

import com.example.demo1.mapper.LikesMapper;
import com.example.demo1.mapper.MomentsMapper;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.MomentsConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikesService {
    @Autowired
    private LikesMapper likesMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MomentsMapper momentsMapper;

    public String addLikes(int momentsId,int likesId){
        if(likesMapper.checkLikesExisted(momentsId,likesId)==false) {
            likesMapper.addLikes(momentsId, likesId);
            //判断是否插入成功
            momentsMapper.addLikes(momentsId);
            return MomentsConstResponse.MOMENTS_LIKES_ADD_SUCCESS;
        }else
            return MomentsConstResponse.MOMENTS_LIKES_EXISTED;
    }

    public String removeLikes(int momentsId,int likesId) {
        if (likesMapper.checkLikesExisted(momentsId, likesId) == true) {
            likesMapper.removeLikes(momentsId, likesId);
            momentsMapper.removeLikes(momentsId);
            //判断是否删除成功
            return MomentsConstResponse.MOMENTS_LIKES_REMOVE_SUCCESS;
        } else
            return MomentsConstResponse.MOMENTS_LIKES_ALREADY_REMOVED;
    }

    public List<UserModel> getLikesUsers(int momentsId){
        int [] supporterIds = likesMapper.getLikeUsersIds(momentsId);
        List<UserModel> supporters = new ArrayList<>();
        for(int id:supporterIds){
            supporters.add(userMapper.findById(id));
        }
        return supporters;
    }

}
