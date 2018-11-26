package com.example.demo1.service;

import com.example.demo1.mapper.DailyCheckMapper;
import com.example.demo1.model.DailyCheckModel;
import com.example.demo1.model.constValue.DailyCheckConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyCheckService {
    @Autowired
    private DailyCheckMapper dailyCheckMapper;

    public String insertDailyCheck(int userId){
        java.util.Date now = new java.util.Date();
        java.sql.Date date=new java.sql.Date(now.getTime());
        System.out.println(date);
        DailyCheckModel dailyCheckModel = dailyCheckMapper.recordIsExisted(userId,date);
        if(dailyCheckModel==null){
            dailyCheckMapper.insertDailyCheck(userId);
            return DailyCheckConstResponse.DAILY_CHECK_INSERT_SUCCESS;
        }else{
            return DailyCheckConstResponse.DAILY_CHECK_EXISTED;
        }
    }

    public List<DailyCheckModel> getUserAllDailyCheck(int userId){
        return dailyCheckMapper.findUserDailyCheck(userId);
    }
}
