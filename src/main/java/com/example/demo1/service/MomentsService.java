package com.example.demo1.service;

import com.example.demo1.mapper.MomentsMapper;
import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.constValue.MomentsConstResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @Description:  动态的业务逻辑处理层，为controller层提供服务，调用mapper进行数据库的相关操作
 */
@Service
public class MomentsService {
    @Autowired
    private MomentsMapper momentsMapper;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private LikesService likesService;

    public int  insertMoments(MomentsModel momentsModel){
        if(momentsModel.getUserId()!=0&&momentsModel.getContent()!=null) {
            if(momentsModel.getReleaseTime()==null) {
                TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
                TimeZone.setDefault(time);
                momentsModel.setReleaseTime(new Date());
                //时间差8小时，未解决
            }
            return momentsMapper.insertMoments(momentsModel);
        }
        else
            return -1;
    }

    public Page<MomentsModel> selectUserAllMoments(int userId){
       return momentsMapper.selectUserAllMoments(userId);
    }

    public String deleteUserMoments(int momentsId){
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
            likesService.removeAllLikes(id);
            momentsMapper.deleteUserMoments(momentsId);
            return MomentsConstResponse.MOMENTS_DELETE_SUCCESS;
        }
       return MomentsConstResponse.MOMENTS_NOT_EXISTED;
    }

    public Page<MomentsModel> getAllFollowingMoments(int userId){
        return momentsMapper.findAllFollowingMoments(userId);

    }

    public Page<MomentsModel> getNearByMoments(int userId){
        return momentsMapper.findNearByMoments(userId);
    }

    public String  upLoadImage(int momentsId,String imageUrl){
        String image = null;
        momentsMapper.storeImage(imageUrl, momentsId);
        System.out.println(imageUrl);
        return image;
    }
    public int addLikes(int momentsId,int num){
        momentsMapper.addLikes(momentsId);
        return 1;
    }



}
