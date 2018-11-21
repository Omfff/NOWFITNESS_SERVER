package com.example.demo1.service;

import com.example.demo1.mapper.MomentsMapper;
import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.response.MomentsConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class MomentsService {
    @Autowired
    private MomentsMapper momentsMapper;

    public int insertMoments(MomentsModel momentsModel){
        if(momentsModel.getUserId()!=0&&momentsModel.getContent()!=null) {
            if(momentsModel.getReleaseTime()==null) {
                TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
                TimeZone.setDefault(time);
                momentsModel.setReleaseTime(new Date());
                //时间差8小时，未解决
            }
            momentsMapper.insertMoments(momentsModel);
            return MomentsConstResponse.MOMENTS_RELEASE_SUCCESS;
        }
        else
            return MomentsConstResponse.MOMENTS_RELEASE_FAILED;
    }

    public List<MomentsModel> selectUserAllMoments(int userId){
       return momentsMapper.selectUserAllMoments(userId);
    }

    public void deleteUserMoments(int momentsId){

        momentsMapper.deleteUserMoments(momentsId);
    }

    public List<MomentsModel> getAllFollowingMoments(int userId){
        return momentsMapper.findAllFollowingMoments(userId);
    }

    public int addLikes(int momentsId,int num){
        momentsMapper.addLikes(momentsId);
        return 1;
    }

}
