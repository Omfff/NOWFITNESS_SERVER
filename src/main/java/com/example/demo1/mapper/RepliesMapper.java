package com.example.demo1.mapper;

import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.RepliesModel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

 /**
  * @Description:  数据库中replies表对应的操作接口
  */
@Mapper
public interface RepliesMapper {

    @Insert({"INSERT INTO `nowfitness`.`replies` (commentId,fromUserId,toUserId,replyType,content,replyTime,replyId) value(#{commentId},#{fromUserId},#{toUserId},#{replyType},#{content},#{replyTime},#{replyId})"})
    void insertReply(RepliesModel repliessModel);

    @Delete("DELETE FROM `nowfitness`.`replies` WHERE id = #{id} ")
    void deleteReplyById(int id);

    @Delete("DELETE FROM `nowfitness`.`replies` WHERE commentId = #{commentId} ")
    void deleteRepliesByCommentId(@Param("commentId")int commentId);


    @Select("SELECT * FROM  `nowfitness`.`replies` WHERE commentId =#{commentId} ORDER BY `replyTime` ")
    List<RepliesModel> selectRepliesUnderComment(int commentId);

    @Select("SELECT * FROM  `nowfitness`.`replies` WHERE id = #{id}")
    RepliesModel selectReplyById(int id);

}
