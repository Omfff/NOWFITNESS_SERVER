package com.example.demo1.service;

import com.example.demo1.mapper.MomentsMapper;
import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.constValue.MomentsConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class MomentsService {
    @Autowired
    private MomentsMapper momentsMapper;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private CommentsService commentsService;

    public String  insertMoments(MomentsModel momentsModel){
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
        MomentsModel momentsModel = momentsMapper.findMomentsById(momentsId);
        if(momentsModel!=null) {
            if (momentsModel.getImage() != null)
                try {
                    photoService.deleteImage(momentsModel.getImage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int id  =momentsModel.getMomentsId();
            commentsService.deleteCommentByMomentsId(id);
            momentsMapper.deleteUserMoments(momentsId);
        }
    }

    public List<MomentsModel> getAllFollowingMoments(int userId){
        return momentsMapper.findAllFollowingMoments(userId);
    }

    public String  upLoadImage(int momentsId,String imageUrl){
        String image = null;
        MomentsModel momentsModel = momentsMapper.findMomentsById(momentsId);
        if(momentsModel.getImage()==null) {
            momentsMapper.storeImage(imageUrl, momentsId);
            return image;
        }else{
            image=momentsModel.getImage();
            momentsMapper.storeImage(imageUrl, momentsId);
            return image;
        }
    }
    public int addLikes(int momentsId,int num){
        momentsMapper.addLikes(momentsId);
        return 1;
    }

}
