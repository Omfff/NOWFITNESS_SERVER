package com.example.demo1.mapper;

import com.example.demo1.model.CommentsModel;
import com.example.demo1.model.MomentsModel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentsMapper {
    @Insert({"INSERT INTO `nowfitness`.`comments` (momentsId,content,commentUserId,commentTime) value(#{momentsId},#{content},#{commentUserId},#{commentTime})"})
    void insertComment(CommentsModel commentsModel);

    @Delete("DELETE FROM `nowfitness`.`comments` WHERE id = #{commentsId}")
    void deleteById(@Param("commentsId") int commentsId);

    @Delete("DELETE FROM `nowfitness`.`comments` WHERE momentsId = #{momentsId}")
    void deleteByMoments(@Param("momentsId") int momentsId);

    @Select("SELECT * FROM `nowfitness`.`comments` WHERE momentsId = #{momentsId} ORDER BY `commentTime` DESC")
    List<CommentsModel> selectComments(int momentsId );

    @Select("SELECT * FROM `nowfitness`.`comments` WHERE id = #{id} ")
    CommentsModel findCommentById(int id );

}
