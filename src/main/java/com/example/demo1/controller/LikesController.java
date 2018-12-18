package com.example.demo1.controller;

import com.example.demo1.model.constValue.MomentsConstResponse;
import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class LikesController {
    @Autowired
    private LikesService likesService;
    //还没同步更新moments中的likes
    @RequestMapping(value = "/moments/{momentsId}/likes/{likesId}" ,method = RequestMethod.POST)
    public BaseResponse addLikes(@PathVariable("momentsId")int momentsId,@PathVariable("likesId")int likesId){
        String result= likesService.addLikes(momentsId,likesId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/moments/"+String.valueOf(momentsId)+"/likes/"+String.valueOf(likesId)
                ,null);
       return baseResponse;
    }

    @RequestMapping(value = "/moments/{momentsId}/likes/{likesId}",method = RequestMethod.DELETE)
    public BaseResponse remove(@PathVariable("momentsId")int momentsId,@PathVariable("likesId")int likesId){
        String result = likesService.removeLikes(momentsId, likesId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.NO_CONTENT
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/moments/"+String.valueOf(momentsId)+"/likes/"+String.valueOf(likesId)
                ,null);
        return baseResponse;
    }

    @RequestMapping(value = "/moments/{momentsId}/likes",method = RequestMethod.GET)
    public BaseResponse getLikesUsers(@PathVariable("momentsId")int momentsId){
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/moments/"+String.valueOf(momentsId)+"/likes"
                ,null);
        List<UserModel> likeUsers = likesService.getLikesUsers(momentsId);
        if(likeUsers!=null&&likeUsers.size()>0)
            baseResponse.setData(likeUsers);
        else
            baseResponse.setStatus(Code.NOT_FOUND);
       return baseResponse;
    }
}
