package com.example.demo1.mapper;

import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.StepsDataModel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
@Mapper
public interface MomentsMapper {
    @Insert({"INSERT INTO `nowfitness`.`moments` (userId,content,releaseTime,image,likes) value(#{userId},#{content},#{releaseTime},#{image},#{likes})"})
        //void insertStepsData(@Param("id")int id, @Param("date") Date date,@Param("steps")int steps);
    void insertMoments(MomentsModel momentsModel);

    @Select("SELECT * FROM `nowfitness`.`moments` where userId = #{userId} ")
    List<MomentsModel> selectUserAllMoments(int userId);

    @Delete("DELETE FROM `nowfitness`.`moments` WHERE momentsId = #{momentsId} ")
    void deleteUserMoments(int momentsId);

    @Select("SELECT momentsId FROM `nowfitness`.`moments` where userId = #{userId} and releaseTime = #{releaseTime} ")
    int findMomentsId(int userId, Date releaseTime);

    @Select("SELECT * FROM `nowfitness`.`moments` WHERE userId IN ( SELECT followId FROM `nowfitness`.`following` where userId = #{userId}) ORDER BY `releaseTime` DESC")
    List<MomentsModel> findAllFollowingMoments(@Param("userId") int userId);

    @Update("UPDATE `nowfitness`.`moments` SET `likes` = `likes`+1 WHERE `momentsId` = #{momentsId} ;")
    void addLikes(@Param("momentsId")int momentsId);

    @Update("UPDATE `nowfitness`.`moments` SET `likes` = `likes`-1 WHERE `momentsId` = #{momentsId} ;")
    void removeLikes(@Param("momentsId")int momentsId);

    @Update("UPDATE `nowfitness`.`moments` SET `image` = #{image} WHERE `momentsId` = #{momentsId} ;")
    void storeImage(@Param("image")String image,@Param("momentsId")int momentsId);

    @Select("SELECT * FROM `nowfitness`.`moments` where momentsId = #{momentsId} ")
    MomentsModel findMomentsById(int momentsId);


}
