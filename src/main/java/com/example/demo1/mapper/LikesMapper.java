package com.example.demo1.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface LikesMapper {

    @Insert({"INSERT INTO `nowfitness`.`likes` (momentsId,likesId) value(#{momentsId},#{likesId})"})
    void addLikes(@Param("momentsId")int momentsId,@Param("likesId") int likesId );

    @Delete("DELETE FROM `nowfitness`.`likes` WHERE likesId = #{likesId} and momentsId =#{momentsId} ")
    void removeLikes(@Param("momentsId")int momentsId,@Param("likesId") int likesId );

    @Select("SELECT likesId FROM `nowfitness`.`likes` where momentsId = #{momentsId}" )
    int [] getLikeUsersIds(@Param("momentsId")int momentsId);

    @Select( "SELECT EXISTS(SELECT * FROM `nowfitness`.`likes` WHERE  momentsId=#{momentsId} and likesId=#{likesId})")//select isnull((select top(1) 1 from `nowfitness`.`likes` where momentsId=#{momentsId} and likesId=#{likesId} ), 0)")
    boolean checkLikesExisted(@Param("momentsId")int momentsId,@Param("likesId")int likesId);
}
