package com.example.demo1.model.response;

import com.example.demo1.model.CommentsModel;
import lombok.Data;

import java.util.List;

@Data
public class CommentsResponseModel {
    private int commentsNum ;
    private List<CommentsModel> commentsList;
}
