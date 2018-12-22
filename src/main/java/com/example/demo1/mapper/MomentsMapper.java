package com.example.demo1.mapper;

import com.example.demo1.model.MomentsModel;
import com.example.demo1.model.StepsDataModel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
@Mapper
public interface MomentsMapper {
    @Insert({"INSERT INTO `nowfitness`.`moments` (momentsId,userId,content,releaseTime,image,likes) value(#{momentsId},#{userId},#{content},#{releaseTime},#{image},#{likes}) "})
    @SelectKey(statement = "select LAST_INSERT_ID() as momentsId",keyProperty = "momentsId",before = false,resultType = int.class)
        //void insertStepsData(@Param("id")int id, @Param("date") Date date,@Param("steps")int steps);
    //@Options(useGeneratedKeys = true, keyProperty = "momentsId", keyColumn = "momentsId")
        int insertMoments(MomentsModel momentsModel);

    @Select("SELECT * FROM `nowfitness`.`moments` where userId = #{userId} ORDER BY `releaseTime` DESC")
    Page<MomentsModel> selectUserAllMoments(int userId);

    @Delete("DELETE FROM `nowfitness`.`moments` WHERE momentsId = #{momentsId} ")
    void deleteUserMoments(int momentsId);

    @Select("SELECT momentsId FROM `nowfitness`.`moments` where userId = #{userId} and releaseTime = #{releaseTime} ")
    int findMomentsId(int userId, Date releaseTime);

    @Select("SELECT * FROM `nowfitness`.`moments` WHERE userId IN ( SELECT followId FROM `nowfitness`.`following` where userId = #{userId} AND followId IS NOT NULL) ORDER BY `releaseTime` DESC")
    Page<MomentsModel> findAllFollowingMoments(@Param("userId") int userId);

    @Select("SELECT * FROM `nowfitness`.`moments` WHERE userId  NOT IN ( SELECT followId FROM `nowfitness`.`following` where userId = #{userId} AND followId IS NOT NULL) AND userId != #{userId} ORDER BY `releaseTime` DESC")
    Page<MomentsModel> findNearByMoments(@Param("userId") int userId);

    @Update("UPDATE `nowfitness`.`moments` SET `likes` = `likes`+1 WHERE `momentsId` = #{momentsId} ;")
    void addLikes(@Param("momentsId")int momentsId);

    @Update("UPDATE `nowfitness`.`moments` SET `likes` = `likes`-1 WHERE `momentsId` = #{momentsId} ;")
    void removeLikes(@Param("momentsId")int momentsId);

    @Update("UPDATE `nowfitness`.`moments` SET `image` = #{image} WHERE `momentsId` = #{momentsId} ;")
    void storeImage(@Param("image")String image,@Param("momentsId")int momentsId);

    @Select("SELECT * FROM `nowfitness`.`moments` where momentsId = #{momentsId} ")
    MomentsModel findMomentsById(int momentsId);


}
