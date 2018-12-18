package com.example.demo1.service;

import com.example.demo1.mapper.RepliesMapper;
import com.example.demo1.model.RepliesModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.CommentConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class RepliesService {
    @Autowired
    private RepliesMapper repliesMapper;
    @Autowired
    private UserService userService;

    public String makeReply(RepliesModel repliesModel){
        if(repliesModel.getCommentId()!=0
                &&repliesModel.getFromUserId()!=0
                &&repliesModel.getToUserId()!=0
               // &&repliesModel.getReplyType()!=null//待定
                &&repliesModel.getContent()!=null
                //&&repliesModel.getReplyId()!=0 //待定
         ){
            if(repliesModel.getReplyTime()==null){
                TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
                TimeZone.setDefault(time);
                repliesModel.setReplyTime(new Date());
            }
            repliesMapper.insertReply(repliesModel);
            return CommentConstResponse.MAKE_REPLY_SUCCESS;

        }else{
            return CommentConstResponse.REPLY_IMFORMATION_LACK;
        }
    }

    public String deleteReply(int id){
        if(repliesMapper.selectReplyById(id)!=null){
            repliesMapper.deleteReplyById(id);
            return CommentConstResponse.REPLY_DELETE_SUCCESS;
        }else{
            return  CommentConstResponse.REPLY_NOT_EXIST;
        }
    }

    public void deleteRelies(int commentId){
        repliesMapper.deleteRepliesByCommentId(commentId);
    }

    public List<RepliesModel> selectAllRepliseUnderComment(int commentId){
        return repliesMapper.selectRepliesUnderComment(commentId);
    }
    public List<RepliesModel> completeRepliesInformation(List<RepliesModel>repliesModelList){
        if(repliesModelList!=null){
            for (RepliesModel repliesModel :repliesModelList) {
                UserModel u1 = userService
                        .getUserInformationById(repliesModel.getFromUserId());
                UserModel u2 = userService
                        .getUserInformationById(repliesModel.getToUserId());
                repliesModel.setFromUserName(u1.getUserName());
                repliesModel.setToUserName(u2.getUserName());
                repliesModel.setToUserNickName(u2.getNickName());
                repliesModel.setFromUserNickName(u1.getNickName());
            }
        }
        return repliesModelList;
    }
}
