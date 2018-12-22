package com.example.demo1.controller;

import com.example.demo1.model.CommentsModel;
import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.CommentsResponseModel;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.RepliesModel;
import com.example.demo1.service.CommentsService;
import com.example.demo1.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.BaseStream;

@RestController
public class CommentsController {
    @Autowired
    private  RepliesService repliesService;
     @Autowired
    private CommentsService commentsService;

     @RequestMapping(value = "/comment",method = RequestMethod.POST)
     public BaseResponse makeComment(@RequestBody CommentsModel commentsModel){
         String result = commentsService.makeComment(commentsModel);
         BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                 ,Code.OK
                 ,Code.NO_ERROR_MESSAGE
                 ,result
                 ,"/comment"
                 ,null);
         return baseResponse;
     }
     @RequestMapping(value = "/comments/{commentsId}",method = RequestMethod.DELETE)
     public BaseResponse deleteComment(@PathVariable("commentsId") int id){
         String result = commentsService.deleteCommentById(id);
         BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                 ,Code.NO_CONTENT
                 ,Code.NO_ERROR_MESSAGE
                 ,result
                 ,"/comments/"+String.valueOf(id)
                 ,null);
        return baseResponse;
     }
     @RequestMapping(value = "/moments/{momentsId}/comments" ,method = RequestMethod.GET)
    public BaseResponse getAllCommentsAndReplies(@PathVariable("momentsId") int momentsId){
         CommentsResponseModel commentsResponseModel = new CommentsResponseModel();
         List<CommentsModel> commentsModelsList =  commentsService.selectAllCommentsUnderMoments(momentsId);
         List<CommentsModel>  commentsList =commentsService.completeCommentsInformation(commentsModelsList);
         commentsResponseModel.setCommentsList(commentsList);
         if(commentsList!=null)
            commentsResponseModel.setCommentsNum(commentsList.size());
         else
             commentsResponseModel.setCommentsNum(0);
         BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                 ,Code.OK
                 ,Code.NO_ERROR_MESSAGE
                 ,Code.NO_MESSAGE_AVAIABLE
                 ,"/moments/"+String.valueOf(momentsId)+"/comments"
                 ,commentsResponseModel);
         /*if (commentsList==null)
             baseResponse.setStatus(Code.NOT_FOUND);*/
         return baseResponse;
     }
}
