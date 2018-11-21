package com.example.demo1.controller;

import com.example.demo1.model.StepsDataModel;
import com.example.demo1.service.StepsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StepsDataController {
    @Autowired
    private StepsDataService stepsDataService;

    @RequestMapping("/user/stepsdata/insert")
    public StepsDataModel insertStepsData(StepsDataModel stepsDataModel){
        return stepsDataService.insertStepsData(stepsDataModel);
    }

    @RequestMapping("/user/stepsdata/update")
    public StepsDataModel updateStepsData(StepsDataModel stepsDataModel){
        return stepsDataService.updateStepsData(stepsDataModel);
    }

    @RequestMapping("user/stepsdata/get")
    public List<StepsDataModel> getStepsData(int id){
        return stepsDataService.getAllStepsData(id);
    }

}
