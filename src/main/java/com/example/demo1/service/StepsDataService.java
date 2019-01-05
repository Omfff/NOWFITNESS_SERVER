package com.example.demo1.service;

import com.example.demo1.mapper.StepsDataMapper;
import com.example.demo1.model.StepsDataModel;
import com.example.demo1.model.constValue.StepsDataConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Description:  计步信息的业务逻辑处理层，为controller层提供服务，调用mapper进行数据库的相关操作
 */
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
            stepsDataMapper.updateStepsData(stepsDataModel);
        }
        return StepsDataConst.STEPS_UPDATE_SUCCEED;
    }

    public List<StepsDataModel> getStepsData(int id,int days){

        int queryDays = -1*days;
        return  stepsDataMapper.findUserAllStepsData(id,queryDays);
    }
}
