package com.example.demo1.service;

import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.UserConstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String  login(UserModel userModel) {
        UserModel exisedUser = userMapper.findUserByName(userModel.getUserName());
        System.out.println("userName="+userModel.getUserName()+" password="+userModel.getPassword());
        if(userModel.getUserName()==null||userModel.getPassword()==null){
            return UserConstResponse.PARAM_ERROR;
        }
        if(exisedUser==null){
            return UserConstResponse.USER_NOT_EXISTED;
        }
        if(exisedUser.getPassword().equals(userModel.getPassword())){
            return UserConstResponse.LOGIN_SUCCESS;
        }else{
            return UserConstResponse.ERROR_PASSWORD;
        }
    }

    public String register(UserModel userModel){
        if(userModel.getUserName()==null||userModel.getPassword()==null){
            return UserConstResponse.PARAM_ERROR;
        }
        if(userMapper.findUserByName(userModel.getUserName())!=null){
            return UserConstResponse.RESGITER_EXISTED;
        }
        userMapper.register(userModel.getUserName(),userModel.getPassword());
        if(userMapper.findUserByName(userModel.getUserName())!=null) {
            return UserConstResponse.REGISTER_SUCCESS;
        }
        else
            return UserConstResponse.REGISTER_FAIL;
    }

    public String updateUserDate(UserModel userModel){
        UserModel exsitedUser =userMapper.findUserByName(userModel.getUserName());
        if(exsitedUser.getPassword().equals(userModel.getPassword())) {
           if(userModel.getSex()!=null)
               exsitedUser.setSex(userModel.getSex());
           if(userModel.getWeight()!=0.0)
               exsitedUser.setWeight(userModel.getWeight());
           if (userModel.getHeight()!=0)
               exsitedUser.setHeight(userModel.getHeight());
           if(userModel.getAge()!=0)
               exsitedUser.setAge(userModel.getAge());
           if(userModel.getPicture()!=null)
               exsitedUser.setPicture(userModel.getPicture());
            System.out.println(exsitedUser.toString());
            userMapper.updateUserData(exsitedUser);
            return UserConstResponse.UPDATE_USER_INFORMATION_SUCCESS;
        }else{
            return UserConstResponse.ERROR_PASSWORD;
        }
    }

    public UserModel getUserInformation(String name,String password){
        UserModel userModel = userMapper.findUserByName(name);
        if(userModel.getPassword().equals(password))
             return userMapper.findUserByName(name);
        else
            return null;
    }

    public UserModel getUserInformationById(int userId){
        return userMapper.findById(userId);
    }

    public int findUserId(String name){
        if(name!=null)
            return userMapper.findUserId(name);
        else
            return -1;
    }

    public String updateUserPhoto(int id,String name){
        String image=null;
        UserModel userModel = userMapper.findById(id);
        if(userModel.getPicture()==null) {
            userMapper.updateUserPhoto(id, name);
            return image;
        }
        else{
                image = userModel.getPicture();
                userMapper.updateUserPhoto(id,name);
                return image;
        }

    }
}
