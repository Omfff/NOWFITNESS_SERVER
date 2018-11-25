package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.response.MomentsConstResponse;
import com.example.demo1.model.response.MomentsResponseModel;
import com.example.demo1.service.CommentsService;
import com.example.demo1.service.MomentsService;
import com.example.demo1.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MomentsController {
    @Autowired
    private MomentsService momentsService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/moments/release")
    public ConstResponseModel releaseMoments(MomentsModel momentsModel){
        ConstResponseModel momentsResponse = new ConstResponseModel();
        momentsResponse.setResult(momentsService.insertMoments(momentsModel));
        return momentsResponse;
    }

    @RequestMapping("/moments/delete")
    public void deleteMoments(int momentsId){
        momentsService.deleteUserMoments(momentsId);
    }

    @RequestMapping("/moments/getUser")
    public MomentsResponseModel getUserMoments(int userId){
        List<MomentsModel> momentsModelList =momentsService.selectUserAllMoments(userId);
        MomentsResponseModel momentsResponseModel = new MomentsResponseModel();
        momentsResponseModel.setMomentsModelsList(momentsModelList);
        return momentsResponseModel;
    }

    @RequestMapping("/moments/getFollowing")
    public MomentsResponseModel getAllFollowingMoments(int userId){
       List<MomentsModel> momentsModelList = momentsService.getAllFollowingMoments(userId);
       MomentsResponseModel momentsResponseModel = new MomentsResponseModel();
       momentsResponseModel.setMomentsNum(momentsModelList.size());
       for(int i =0;i<momentsModelList.size();i++){
           int commentsNum = commentsService.selectAllCommentsUnderMoments(momentsModelList.get(i).getMomentsId()).size();
           momentsModelList.get(i).setCommentsNum(commentsNum);
       }
       momentsResponseModel.setMomentsModelsList(momentsModelList);
       return momentsResponseModel;
    }

    @RequestMapping(value = "/moments/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    ConstResponseModel uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("momentsId") int momentsId) {
        ConstResponseModel momentsResponse = new ConstResponseModel();
        momentsResponse.setResult(photoService.upLoadMomentsImage(file, momentsId));
        return momentsResponse;
    }
}
