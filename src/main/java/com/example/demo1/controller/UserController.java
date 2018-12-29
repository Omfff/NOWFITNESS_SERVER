package com.example.demo1.controller;


import com.example.demo1.Exception.NotFoundException;
import com.example.demo1.Exception.Result;
import com.example.demo1.model.DailyCheckModel;
import com.example.demo1.model.constValue.BaseUrl;
import com.example.demo1.model.constValue.PhotoConstResponse;
import com.example.demo1.model.constValue.UserConstResponse;
import com.example.demo1.model.response.BaseResponse;
import com.example.demo1.model.response.Code;
import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.UserModel;
import com.example.demo1.model.response.UserInfoResponseModel;
import com.example.demo1.service.*;
import com.example.demo1.util.JblogUtil;
import com.example.demo1.util.PairUtils;
import com.example.demo1.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private FollowingService followingService;
    @Autowired
    private DailyCheckService dailyCheckService;
    @Autowired
    private MomentsService  momentsService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/user/login",method =RequestMethod.POST)
    public BaseResponse login( @RequestParam("userName") String userName, @RequestParam("password") String password ){
        UserModel userModel = new UserModel();
        userModel.setToken("");
        userModel.setPassword(password);
        userModel.setUserName(userName);
        String result = userService.login(userModel);
        BaseResponse baseResponse =new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                    ,Code.OK
                    ,Code.NO_ERROR_MESSAGE
                    ,result
                    ,"/user/login"
                    ,new Token(userModel.getToken()));
        if(!result.equals(UserConstResponse.LOGIN_SUCCESS)) {
            baseResponse.setStatus(Code.BAD_REQUEST);
            baseResponse.setError(result);
        }
        return baseResponse;
    }
    // /user/register?userName=xxx&password=xxxx
    @RequestMapping(value="/user/register",method = RequestMethod.POST)
    public BaseResponse register(@RequestParam("userName") String userName, @RequestParam("password") String password){
        UserModel userModel = new UserModel();
        userModel.setUserName(userName);
        userModel.setSalt(UUID.randomUUID().toString().substring(0,5));
        userModel.setPassword(JblogUtil.MD5(password+userModel.getSalt()));
        userModel.setToken(JblogUtil.MD5(userName+UUID.randomUUID().toString().substring(0,5)+password));
        userModel.setPicture("60528.png");///默认照片
        String result = userService.register(userModel);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.CREATED
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/register"
                ,new Token(userModel.getToken()));
        if(!result.equals(UserConstResponse.REGISTER_SUCCESS)) {
           baseResponse.setStatus(Code.BAD_REQUEST);
           baseResponse.setError(result);
        }
        return baseResponse;
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.PUT)
    public BaseResponse updateUserDate(@RequestBody UserModel userModel) {
        String result = userService.updateUserDate(userModel);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                    ,Code.OK
                    ,Code.NO_ERROR_MESSAGE
                    ,result
                    ,"/user/update"
                    ,null);
        if(!result.equals(UserConstResponse.UPDATE_USER_INFORMATION_SUCCESS)) {
            baseResponse.setStatus(Code.BAD_REQUEST);
            baseResponse.setError(result);
        }
        return baseResponse;
    }

    // /user/information?userName=xxx&password=xxx
    @RequestMapping(value = "/user/information/{userName}",method = RequestMethod.GET)
    public BaseResponse getUserInformation(@PathVariable("userName")String userName) {
        int id = userService.findUserId(userName);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                , Code.OK
                , Code.NO_ERROR_MESSAGE
                , Code.NO_MESSAGE_AVAIABLE
                , "/user/information/"
                , null);
        if (id != -1) {
            UserModel userModel = userService.getUserInformationById(id);
            UserInfoResponseModel userInfoResponseModel = new UserInfoResponseModel();
            if (userModel != null) {
                int userId = userModel.getId();
                userInfoResponseModel.setId(userId);
                userInfoResponseModel.setAge(userModel.getAge());
                userInfoResponseModel.setUserName(userModel.getUserName());
                userInfoResponseModel.setPassword(userModel.getPassword());
                userInfoResponseModel.setHeight(userModel.getHeight());
                userInfoResponseModel.setWeight(userModel.getWeight());
                userInfoResponseModel.setSex(userModel.getSex());
                userInfoResponseModel.setAge(userModel.getAge());
                userInfoResponseModel.setPicture(BaseUrl.URL + userModel.getPicture());
                userInfoResponseModel.setNickName(userModel.getNickName());
                userInfoResponseModel.setFollowing(followingService
                        .getFollowinguUser(userId)
                        .size());
                userInfoResponseModel.setFans(followingService.findUserFansId(userId).length);
                userInfoResponseModel.setMomentsNum(momentsService.selectUserAllMoments(userId).size());
                List<DailyCheckModel> dailyCheckModelList = dailyCheckService.getUserAllDailyCheck(userModel.getId());
                List<Date> dailyCheckList = new ArrayList<>();
                for (DailyCheckModel dailyCheckModel : dailyCheckModelList) {
                    dailyCheckList.add(dailyCheckModel.getDate());
                }
                userInfoResponseModel.setDailyCheckList(dailyCheckList);
            }
        if (userInfoResponseModel != null)
            baseResponse.setData(userInfoResponseModel);
        else
            baseResponse.setStatus(Code.NOT_FOUND);
    }else{
            baseResponse.setStatus(Code.NOT_FOUND);
        }
       return baseResponse;
    }

    @RequestMapping(value = "/user/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse upload(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        int realId = Integer.parseInt(id);
        ConstResponseModel userReponse = new ConstResponseModel();
        String result = photoService.upLoadUserPhoto(file,realId);
        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.OK
                ,Code.NO_ERROR_MESSAGE
                ,result
                ,"/user/uploadPhoto/"
                ,null);
        if(!result.equals(PhotoConstResponse.PIC_UPLOAD_SUCCEED)) {
            baseResponse.setError(result);
            baseResponse.setStatus(Code.NOT_ACCEPTABLE);
        }
        return baseResponse;
    }
    @RequestMapping(value="/user/password",method = RequestMethod.POST)
    public BaseResponse changePassword(@RequestParam("userId") int userId, @RequestParam("password") String password){

        BaseResponse baseResponse = new BaseResponse((new Timestamp(System.currentTimeMillis())).toString()
                ,Code.CREATED
                ,Code.NO_ERROR_MESSAGE
                , userService.changeUserPassword(userId,password)
                ,"/user/password"
                ,null);
        return baseResponse;
    }



}
