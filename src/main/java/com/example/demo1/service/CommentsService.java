package com.example.demo1.service;

import com.example.demo1.mapper.CommentsMapper;
import com.example.demo1.model.CommentsModel;
import com.example.demo1.model.response.CommentConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private RepliesService repliesService;

    public String makeComment(CommentsModel commentsModel){
        if(commentsModel.getCommentUserId()!=0
        &&commentsModel.getContent()!=null
        &&commentsModel.getMomentsId()!=0
        ){
            if(commentsModel.getCommentTime()==null){
                TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
                TimeZone.setDefault(time);
                commentsModel.setCommentTime(new Date());
            }
            commentsMapper.insertComment(commentsModel);
            return CommentConstResponse.MAKE_COMMENT_SUCCESS;
        }else{
            return CommentConstResponse.COMMENT_IMFORMATION_LACK;
        }
    }

    public String deleteCommentById(int id){
        if(commentsMapper.findCommentById(id)!=null){
            commentsMapper.deleteById(id);
            repliesService.deleteRelies(id);
            return CommentConstResponse.COMMENT_DELETE_SUCCESS;
        }else{
            return  CommentConstResponse.COMMENT_NOT_EXIST;
        }
    }

    public void deleteCommentByMomentsId(int momentsId){
       commentsMapper.deleteByMoments(momentsId);
    }

    public List<CommentsModel> selectAllCommentsUnderMoments(int momensId){
        return commentsMapper.selectComments(momensId);
    }



}
