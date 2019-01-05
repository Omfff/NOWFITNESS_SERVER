package com.example.demo1.mapper;

import com.example.demo1.model.DailyCheckModel;
import com.example.demo1.model.StepsDataModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

 /**
  * @Description:  数据库中daily_check表对应的操作接口
  */
@Mapper
public interface DailyCheckMapper {
    @Insert({"INSERT INTO `nowfitness`.`daily_check` (userId,date) value(#{userId},CURRENT_DATE())"})
        //void insertStepsData(@Param("id")int id, @Param("date") Date date,@Param("steps")int steps);
    void insertDailyCheck(@Param("userId")int userId);

    @Select("SELECT * FROM `nowfitness`.`daily_check` where userId = #{userId} ")
    List<DailyCheckModel> findUserDailyCheck(int userId);

    @Select("SELECT * FROM `nowfitness`.`daily_check` where userId = #{userId} and date=#{date}")
    DailyCheckModel recordIsExisted(@Param("userId")int userId,@Param("date")java.sql.Date date );

}
