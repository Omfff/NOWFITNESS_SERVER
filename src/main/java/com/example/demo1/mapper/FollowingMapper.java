package com.example.demo1.mapper;


import org.apache.ibatis.annotations.*;

import java.lang.reflect.Array;
import java.util.List;

 /**
  * @Description:  数据库中following表对应的操作接口
  */
@Mapper
public interface FollowingMapper {
    @Insert({"INSERT INTO `nowfitness`.`following` (userId,followId) value(#{userId},#{followId})"})
    void following(@Param("userId") int userId, @Param("followId") int followId);

    @Select("SELECT followId FROM `nowfitness`.`following` where userId = #{userId} ")
    int[] findUserFollowingIds(@Param("userId") int userId);

    @Delete("DELETE FROM `nowfitness`.`following` WHERE userId=#{userId} and followId=#{followId}")
    void notFollowing(@Param("userId")int userId ,@Param("followId")int followId);

    @Select("SELECT userId FROM `nowfitness`.`following` where followId = #{followId}")
    int [] findUserFans(@Param("followId")int followId);

    @Select( "SELECT EXISTS(SELECT * FROM `nowfitness`.`following` WHERE  userId=#{userId} and followId=#{followId})")//select isnull((select top(1) 1 from `nowfitness`.`likes` where momentsId=#{momentsId} and likesId=#{likesId} ), 0)")
    boolean checkFollowExisted(@Param("userId")int userId,@Param("followId")int followId);
}
