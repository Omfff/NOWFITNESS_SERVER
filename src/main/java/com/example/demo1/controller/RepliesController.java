package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.RepliesModel;
import com.example.demo1.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepliesController {
    @Autowired
    private RepliesService repliesService;

    @RequestMapping("/reply/make")
    public ConstResponseModel makeReply(RepliesModel repliesModel){
        ConstResponseModel constResponseModel = new ConstResponseModel();
        constResponseModel.setResult(repliesService.makeReply(repliesModel));
        return constResponseModel;
    }

    @RequestMapping("/reply/delete")
    public ConstResponseModel deleteReply(int id){
        ConstResponseModel constResponseModel = new ConstResponseModel();
        constResponseModel.setResult(repliesService.deleteReply(id));
        return constResponseModel;
    }
}
