package com.example.demo1.model.response;

import com.example.demo1.model.StepsDataModel;
import lombok.Data;

import java.util.List;

@Data
public class StepsResponseModel {
    private List<StepsDataModel> stepsDataModelList;
}
