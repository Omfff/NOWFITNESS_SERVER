package com.example.demo1.service;

import com.example.demo1.mapper.StepsDataMapper;
import com.example.demo1.model.StepsDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepsDataService {
    @Autowired
    private StepsDataMapper stepsDataMapper;

    public StepsDataModel insertStepsData(StepsDataModel stepsDataModel){
        stepsDataMapper.insertStepsData(stepsDataModel);
        return stepsDataModel;
    }

    public StepsDataModel updateStepsData(StepsDataModel stepsDataModel){
        stepsDataMapper.updateStepsData(stepsDataModel);
        return stepsDataModel;
    }

    public List<StepsDataModel> getAllStepsData(int id){
       return  stepsDataMapper.findUserAllStepsData(id);
    }
}
