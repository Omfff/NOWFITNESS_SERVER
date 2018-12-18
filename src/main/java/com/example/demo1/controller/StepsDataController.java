package com.example.demo1.controller;

import com.example.demo1.model.StepsDataModel;
import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.StepsResponseModel;
import com.example.demo1.service.StepsDataService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class StepsDataController {
    @Autowired
    private StepsDataService stepsDataService;

    // /user/stepsdata/insert?id=xxx&steps=xxx&calories(calories非必需的)
    @RequestMapping(value = "/user/stepsData",method = RequestMethod.POST)
    public BaseResponse insertStepsData(@RequestParam("id")int userId, @RequestParam("steps")int steps,
                                        @RequestParam("calories")int calories){
        StepsDataModel stepsDataModel = new StepsDataModel(userId,steps,calories);
        String result = stepsDataService.insertStepsData(stepsDataModel);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/stepsData"
                ,null);
        return baseResponse;
    }

    @RequestMapping(value = "/user/stepsData",method =RequestMethod.PUT)
    public BaseResponse updateStepsData(@RequestParam("id")int userId, @RequestParam("steps")int steps,
                                          @RequestParam("calories")int calories){
        StepsDataModel stepsDataModel = new StepsDataModel(userId,steps,calories);
        String result = stepsDataService.updateStepsData(stepsDataModel);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/stepsData"
                ,null);
        return baseResponse;
    }

    @RequestMapping(value = "user/{id}/stepsData",method = RequestMethod.GET)
    public BaseResponse getStepsData(@PathVariable("id") int id){
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,Code.NO_MESSAGE_AVAIABLE
                ,"/user/"+String.valueOf(id)+"/stepsData"
                , stepsDataService.getAllStepsData(id));
        return baseResponse;
    }

}
