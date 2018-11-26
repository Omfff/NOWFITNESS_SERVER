package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.service.DailyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyCheckController {
    @Autowired
    private DailyCheckService dailyCheckService;

    @RequestMapping("/dailycheck/update")
    public ConstResponseModel insertDailyCheck(int userId){
        ConstResponseModel constResponseModel = new ConstResponseModel();
        constResponseModel.setResult(dailyCheckService.insertDailyCheck(userId));
        return constResponseModel;
    }
}
