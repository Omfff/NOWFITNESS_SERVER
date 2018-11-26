package com.example.demo1.controller;

import com.example.demo1.model.CommentsModel;
import com.example.demo1.model.response.CommentsResponseModel;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.RepliesModel;
import com.example.demo1.service.CommentsService;
import com.example.demo1.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentsController {
    @Autowired
    private  RepliesService repliesService;
     @Autowired
    private CommentsService commentsService;

     @RequestMapping("/comment/make")
     public ConstResponseModel makeComment(CommentsModel commentsModel){
         ConstResponseModel constResponseModel = new ConstResponseModel();
         constResponseModel.setResult(commentsService.makeComment(commentsModel));
         return constResponseModel;
     }
     @RequestMapping("/comments/delete")
     public ConstResponseModel deleteComment(int id){
         ConstResponseModel constResponseModel = new ConstResponseModel();
         constResponseModel.setResult(commentsService.deleteCommentById(id));
         return constResponseModel;
     }
     @RequestMapping("/comment")
    public CommentsResponseModel getAllCommentsAndReplies(int momentsId){
         CommentsResponseModel commentsResponseModel = new CommentsResponseModel();
         List<CommentsModel> commentsModelsList =  commentsService.selectAllCommentsUnderMoments(momentsId);
         commentsResponseModel.setCommentsNum(commentsModelsList.size());
         commentsResponseModel.setCommentsList( commentsService.completeCommentsInformation(commentsModelsList));
         return commentsResponseModel;
     }
}
