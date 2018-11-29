package com.example.demo1.model.response;

import com.example.demo1.model.RepliesModel;
import lombok.Data;

import java.util.List;
@Data
public class RepliesResponseModel {
    private List<RepliesModel> repliesModelsList;
}
