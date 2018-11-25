package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikesController {
    @Autowired
    private LikesService likesService;
    //还没同步更新moments中的likes
    @RequestMapping("moments/addLikes")
    public ConstResponseModel addLikes(int momentsId, int likesId){
       ConstResponseModel momentsResponse = new ConstResponseModel();
       momentsResponse.setResult( likesService.addLikes(momentsId,likesId));
       return momentsResponse;
    }

    @RequestMapping("moments/removeLikes")
    public ConstResponseModel remove(int momentsId, int likesId){
        ConstResponseModel momentsResponse = new ConstResponseModel();
        momentsResponse.setResult(likesService.removeLikes(momentsId, likesId));
        return momentsResponse;
    }

    @RequestMapping("moments/getLikesUsers")
    public List<UserModel> getLikesUsers(int momentsId){
        return likesService.getLikesUsers(momentsId);
    }
}
