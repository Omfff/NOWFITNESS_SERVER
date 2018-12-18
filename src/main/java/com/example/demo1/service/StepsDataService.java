package com.example.demo1.service;

import com.example.demo1.mapper.StepsDataMapper;
import com.example.demo1.model.StepsDataModel;
import com.example.demo1.model.constValue.StepsDataConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepsDataService {
    @Autowired
    private StepsDataMapper stepsDataMapper;

    public String  insertStepsData(StepsDataModel stepsDataModel){
        if(stepsDataMapper.checkStepsDataExisted(stepsDataModel.getId())==false) {
            stepsDataMapper.insertStepsData(stepsDataModel);
            return StepsDataConst.STEPS_UPDATE_SUCCEED;
        }else{
            return StepsDataConst.STEPS_DATA_EXISTED;
        }
    }

    public String updateStepsData(StepsDataModel stepsDataModel){
        if(stepsDataMapper.checkStepsDataExisted(stepsDataModel.getId())==false) {
            stepsDataMapper.insertStepsData(stepsDataModel);
        }else {
            stepsDataMapper.updateStepsData(stepsDataModel);;
        }
        return StepsDataConst.STEPS_UPDATE_SUCCEED;
    }

    public List<StepsDataModel> getAllStepsData(int id){
       return  stepsDataMapper.findUserAllStepsData(id);
    }
}
