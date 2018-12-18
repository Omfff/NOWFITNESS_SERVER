package com.example.demo1.controller;

import com.example.demo1.model.CommentsModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.BaseUrl;
import com.example.demo1.model.constValue.MomentsConstResponse;
import com.example.demo1.model.constValue.PhotoConstResponse;
import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.response.MomentsResponseModel;
import com.example.demo1.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageSerializable;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
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

    @RequestMapping(value = "/moments",method = RequestMethod.POST)
    public BaseResponse releaseMoments(@RequestParam("userId")int userId,
                                             @RequestParam("content")String content,
                                             @RequestParam(value = "file",required = false) MultipartFile file) {
        MomentsModel momentsModel = new MomentsModel();
        momentsModel.setUserId(userId);
        momentsModel.setContent(content);
        momentsService.insertMoments(momentsModel);
        int momentsId =momentsModel.getMomentsId();
        String result = MomentsConstResponse.MOMENTS_RELEASE_SUCCESS;
        String photoUploadResult;
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.OK
                , Code.NO_ERROR_MESSAGE
                , result
                , "/moments"
                , null);
        if (momentsId != -1) {
            if (file != null) {
                photoUploadResult = photoService.upLoadMomentsImage(file, momentsId);
                if (photoUploadResult.equals(PhotoConstResponse.PIC_UPLOAD_FAILED))
                    result = photoUploadResult;
                baseResponse.setMessage(result);
            }
        } else {
            baseResponse.setMessage(MomentsConstResponse.MOMENTS_RELEASE_FAILED);
        }
        return baseResponse;
    }

    @RequestMapping(value = "/moments/{momentsId}",method = RequestMethod.DELETE)
    public BaseResponse deleteMoments(@PathVariable("momentsId") int momentsId){
        String result =momentsService.deleteUserMoments(momentsId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.NO_CONTENT
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/moments/"+String.valueOf(momentsId)
                ,null);
        return baseResponse;

    }

    @RequestMapping(value = "/user/{userId}/moments/{pageNum}",method = RequestMethod.GET)
    public BaseResponse getUserMoments(@PathVariable("userId") int userId,@PathVariable("pageNum")int pageNo){
        PageHelper.startPage(pageNo,10);
        PageInfo<MomentsModel> momentsModelList =new PageInfo<>(momentsService.selectUserAllMoments(userId));
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(userId)+"/moments"
                ,completeMomentsInfo(momentsModelList,userId));
        return baseResponse;
    }

    @RequestMapping(value = "/user/{userId}/following/moments/{pageNum}",method = RequestMethod.GET)
    public BaseResponse getAllFollowingMoments(@PathVariable("userId") int userId,@PathVariable("pageNum")int pageNo){
        PageHelper.startPage(pageNo,10);
       PageInfo<MomentsModel> momentsModelList = new PageInfo<>(momentsService.getAllFollowingMoments(userId));
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(userId)+"/following/moments"
                ,completeMomentsInfo(momentsModelList,userId));
        return baseResponse;
    }

    @RequestMapping(value = "/moments/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    ConstResponseModel uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("momentsId") String momentsId) {
        ConstResponseModel momentsResponse = new ConstResponseModel();
        int realMomentid = Integer.parseInt(momentsId);
        momentsResponse.setResult(photoService.upLoadMomentsImage(file, realMomentid));
        return momentsResponse;
    }

    public PageInfo<MomentsModel>completeMomentsInfo(PageInfo<MomentsModel> momentsModelListPage,int userId){
        List<MomentsModel > momentsModelList = momentsModelListPage.getList();
        for(int i =0;i<momentsModelList.size();i++){
            MomentsModel momentsModel =momentsModelList.get(i);
            int commentsNum = commentsService.selectAllCommentsUnderMoments(momentsModel.getMomentsId()).size();
            momentsModel.setCommentsNum(commentsNum);
            //List<CommentsModel> commentsModelList = new ArrayList<>();
            //momentsModel.setCommentsModelList( commentsModelList);
            UserModel userModel = userService.getUserInformationById(momentsModel.getUserId());
            momentsModel.setImage(BaseUrl.URL +momentsModel.getImage());
            momentsModel.setNickName(userModel.getNickName());
            momentsModel.setUserName(userModel.getUserName());
            momentsModel.setUserPhoto(BaseUrl.URL+userModel.getPicture());
            momentsModel.setLiked(likesService.checkMomentsIsLikedByUserId(momentsModel.getMomentsId(),userId));
            momentsModel.setLikesName(likesService.getLikesUsersName(momentsModel.getMomentsId()));
        }
        return momentsModelListPage;
    }
}
