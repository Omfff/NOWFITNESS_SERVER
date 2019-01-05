package com.example.demo1.controller;

import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.service.DailyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

 /**
  * @Description:    接收前端传来的关于用户打卡的请求数据，调用Service进行相应的业务处理
  */
@RestController
public class DailyCheckController {
    @Autowired
    private DailyCheckService dailyCheckService;

    @RequestMapping(value = "/dailycheck/user/{userId}",method = RequestMethod.POST)
    public BaseResponse insertDailyCheck(@PathVariable("userId") int userId){
        String result = dailyCheckService.insertDailyCheck(userId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/dailycheck/user/"+String.valueOf(userId)
                ,null);
        return baseResponse;

    }
}
