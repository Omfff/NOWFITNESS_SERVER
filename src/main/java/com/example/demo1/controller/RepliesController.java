package com.example.demo1.controller;

import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.RepliesModel;
import com.example.demo1.model.response.RepliesResponseModel;
import com.example.demo1.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RepliesController {
    @Autowired
    private RepliesService repliesService;

    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public BaseResponse makeReply(@RequestBody RepliesModel repliesModel){
        String result =  repliesService.makeReply(repliesModel);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/reply/"
                ,null);
        return baseResponse;
    }

    @RequestMapping(value = "/reply/{id}",method = RequestMethod.DELETE)
    public BaseResponse deleteReply(@PathVariable("id") int id){
        String result = repliesService.deleteReply(id);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.NO_CONTENT
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/reply/"+String.valueOf(id)
                ,null);
        return baseResponse;
    }
        @RequestMapping(value = "/comment/{commentsId}/replies",method = RequestMethod.GET)
    public BaseResponse getRepliesByCommentId(@PathVariable("commentsId") int commentId){
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/comment/"+String.valueOf(commentId)+"/replies"
                , repliesService.selectAllRepliseUnderComment(commentId));
        return baseResponse;
    }
}
