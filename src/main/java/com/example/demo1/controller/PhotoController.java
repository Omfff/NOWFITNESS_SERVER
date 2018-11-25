package com.example.demo1.controller;

import com.example.demo1.model.response.ConstResponseModel;
import com.example.demo1.model.response.PhotoConstResponse;
import com.example.demo1.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    /*@GetMapping(value="/user/image/preview")
public ResponseEntity<Resource>preview(String name)throws FileNotFoundException{
    InputStream inputStream = new FileInputStream(new File(name));
    InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(inputStreamResource,headers, HttpStatus.OK);
}*/
    @RequestMapping(value = "/image/get")//?imageName=
    public void getImage(HttpServletRequest request, HttpServletResponse response,String imageName) {
        String path = "C://image/"+imageName;
        response.setContentType("image/jpg");
        photoService.getImage(response,path);
    }

    @RequestMapping(value ="/image/delete")
    public ConstResponseModel deleteImage(String imageName){

        ConstResponseModel photoResponse = new ConstResponseModel();
        try {
            photoService.deleteImage(imageName);
            photoResponse.setResult(PhotoConstResponse.PIC_DELETE_SUCCEED);
        }catch (IOException e){
            e.printStackTrace();
            photoResponse.setResult(PhotoConstResponse.PIC_DELETE_FAILED);
        }
        return photoResponse;
    }
}
