package com.example.demo1.controller;

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
    public int addLikes(int momentsId,int likesId){
       return likesService.addLikes(momentsId,likesId);
    }

    @RequestMapping("moments/removeLikes")
    public int remove(int momentsId,int likesId){
        return likesService.removeLikes(momentsId, likesId);
    }

    @RequestMapping("moments/getLikesUsers")
    public List<UserModel> getLikesUsers(int momentsId){
        return likesService.getLikesUsers(momentsId);
    }
}
