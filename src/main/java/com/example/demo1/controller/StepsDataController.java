package com.example.demo1.controller;

import com.example.demo1.model.StepsDataModel;
import com.example.demo1.model.response.StepsResponseModel;
import com.example.demo1.service.StepsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StepsDataController {
    @Autowired
    private StepsDataService stepsDataService;

    // /user/stepsdata/insert?id=xxx&steps=xxx&calories(calories非必需的)
    @RequestMapping("/user/stepsdata/insert")
    public StepsDataModel insertStepsData(StepsDataModel stepsDataModel){
        return stepsDataService.insertStepsData(stepsDataModel);
    }

    @RequestMapping("/user/stepsdata/update")
    public StepsDataModel updateStepsData(StepsDataModel stepsDataModel){
        return stepsDataService.updateStepsData(stepsDataModel);
    }

    @RequestMapping("user/stepsdata/get")
    public StepsResponseModel getStepsData(int id){
        StepsResponseModel stepsResponseModel = new StepsResponseModel();
        stepsResponseModel.setStepsDataModelList(stepsDataService.getAllStepsData(id));
        return stepsResponseModel;
    }

}
