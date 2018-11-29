package com.example.demo1.controller;

import com.example.demo1.model.CommentsModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.response.MomentsResponseModel;
import com.example.demo1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MomentsController {
    @Autowired
    private MomentsService momentsService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private UserService userService;
    @Autowired
    private LikesService likesService;

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
           MomentsModel momentsModel =momentsModelList.get(i);
           int commentsNum = commentsService.selectAllCommentsUnderMoments(momentsModel.getMomentsId()).size();
           momentsModel.setCommentsNum(commentsNum);
           //List<CommentsModel> commentsModelList = new ArrayList<>();
           //momentsModel.setCommentsModelList( commentsModelList);
           UserModel userModel = userService.getUserInformationById(momentsModel.getUserId());
           momentsModel.setUserName(userModel.getUserName());
           momentsModel.setUserPhoto(userModel.getPicture());
           momentsModel.setLiked(likesService.checkMomentsIsLikedByUserId(momentsModel.getMomentsId(),userId));
       }
       momentsResponseModel.setMomentsModelsList(momentsModelList);
       return momentsResponseModel;
    }

    @RequestMapping(value = "/moments/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    ConstResponseModel uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("momentsId") String momentsId) {
        ConstResponseModel momentsResponse = new ConstResponseModel();
        int realMomentid = Integer.parseInt(momentsId);
        momentsResponse.setResult(photoService.upLoadMomentsImage(file, realMomentid));
        return momentsResponse;
    }
}
