package com.example.demo1.service;

import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.constValue.UserConstResponse;
import com.example.demo1.util.JblogUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
/**
 * @Description:  用户个人信息的业务逻辑处理层，为controller层提供服务，调用mapper进行数据库的相关操作
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String  login(UserModel userModel) {
        String userName = userModel.getUserName();
        String password = userModel.getPassword();
        UserModel exisedUser = userMapper.findUserByName(userName);
        System.out.println("userName="+userName+" password="+password);
        if(userName==null||password==null){
            return UserConstResponse.PARAM_ERROR;
        }
        if(exisedUser==null){
            return UserConstResponse.USER_NOT_EXISTED;
        }
        if(JblogUtil.MD5(password+exisedUser.getSalt()).equals(exisedUser.getPassword())){
            if(true){//exisedUser.getToken().equals("")||exisedUser.getToken()==null) {
                String newToken = JblogUtil.MD5(userName+ UUID.randomUUID().toString().substring(0,5)+password);
                userMapper.updateUserToken(exisedUser.getId(),newToken);
                userModel.setToken(newToken);
                return UserConstResponse.LOGIN_SUCCESS;
            }
            else
                return UserConstResponse.USER_ALREADY_LOGIN;
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
        userMapper.register(userModel);
        if(userMapper.findUserByName(userModel.getUserName())!=null) {
            return UserConstResponse.REGISTER_SUCCESS;
        }
        else
            return UserConstResponse.REGISTER_FAIL;
    }

    public String updateUserDate(UserModel userModel){
        UserModel exsitedUser =userMapper.findUserByName(userModel.getUserName());
        if(exsitedUser.getPassword().equals(userModel.getPassword())) {
           if(userModel.getSex()!=null&&userModel.getSex()!="")
               exsitedUser.setSex(userModel.getSex());
           if(userModel.getWeight()!=0.0)
               exsitedUser.setWeight(userModel.getWeight());
           if (userModel.getHeight()!=0)
               exsitedUser.setHeight(userModel.getHeight());
           if(userModel.getAge()!=0)
               exsitedUser.setAge(userModel.getAge());
           if(userModel.getNickName()!="")
               exsitedUser.setNickName(userModel.getNickName());
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
    public UserModel changeUserPassword(int id, String password){
        UserModel userModel = userMapper.findById(id);
        if(userModel!=null) {
            String salt = UUID.randomUUID().toString().substring(0, 5);
            String realPassword = JblogUtil.MD5(password + salt);
            userMapper.updateUserPassword(id,realPassword,salt);
            userModel.setSalt(salt);
            return userModel;
        }else{
            return userModel;
        }
    }
}
