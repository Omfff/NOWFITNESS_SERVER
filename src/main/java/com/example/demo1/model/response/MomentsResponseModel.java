package com.example.demo1.model.response;

import com.example.demo1.model.MomentsModel;
import lombok.Data;

import java.util.List;

@Data
public class MomentsResponseModel {
    private int momentsNum;
    private List<MomentsModel> momentsModelsList;
}
