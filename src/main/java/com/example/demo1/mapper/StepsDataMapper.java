package com.example.demo1.mapper;

import com.example.demo1.model.StepsDataModel;
import com.example.demo1.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface StepsDataMapper {
    @Insert({"INSERT INTO `nowfitness`.`steps_data` (id,date,steps,calories) value(#{id},CURRENT_DATE(),#{steps},#{calories})"})
    //void insertStepsData(@Param("id")int id, @Param("date") Date date,@Param("steps")int steps);
    void insertStepsData(StepsDataModel stepsDataModel);

    @Select("SELECT * FROM `nowfitness`.`steps_data` where `id` = #{userId} AND DATEDIFF(`date`,NOW())<0 AND DATEDIFF(`date`,NOW())>= #{days}")
    List<StepsDataModel> findUserAllStepsData(@Param("userId") int userId,@Param("days") int days);

    @Update("UPDATE `nowfitness`.`steps_data` SET `steps` = #{steps},`calories` = #{calories} WHERE `id` = #{id} AND `date` = CURRENT_DATE() ;")
    int updateStepsData(StepsDataModel stepsDataModel);

    @Select( "SELECT EXISTS(SELECT * FROM `nowfitness`.`steps_data` WHERE  `id` = #{id} AND `date` = CURRENT_DATE())")//select isnull((select top(1) 1 from `nowfitness`.`likes` where momentsId=#{momentsId} and likesId=#{likesId} ), 0)")
    boolean checkStepsDataExisted(@Param("id")int userId);

}
