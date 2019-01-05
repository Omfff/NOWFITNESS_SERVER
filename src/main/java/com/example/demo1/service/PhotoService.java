package com.example.demo1.service;

import com.example.demo1.model.ImageStoreModel;
import com.example.demo1.model.constValue.PhotoConstResponse;
import com.example.demo1.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * @Description:  图片各种操作的业务逻辑处理层，为controller层提供服务，调用mapper进行数据库的相关操作
 */
@Service
public class PhotoService {

@Autowired
private UserService userService;
@Autowired
private MomentsService momentsService;

    public String upLoadMomentsImage(MultipartFile file,int momentsId){
        String photoName = upLoad(file);
        if(photoName==null){
            return PhotoConstResponse.PIC_UPLOAD_FAILED;
        }else{
            String imageName = momentsService.upLoadImage(momentsId,photoName);
            System.out.println(  "upLoadMomentsImage: "+photoName);
            return PhotoConstResponse.PIC_UPLOAD_SUCCEED;
        }

    }

    public String upLoadUserPhoto(MultipartFile file,int id){
        String photoName = upLoad(file);
        if(photoName==null){
            return PhotoConstResponse.PIC_UPLOAD_FAILED;
        }else{
            String imageName = userService.updateUserPhoto(id,photoName);
            if(imageName!=null)
                try {
                    deleteImage(imageName);
                }catch (IOException e){
                    e.printStackTrace();
                }
            return PhotoConstResponse.PIC_UPLOAD_SUCCEED;
        }
    }

    public String upLoad(MultipartFile file){
        ImageStoreModel imageStoreModel= new ImageStoreModel();
        imageStoreModel.setResult(false);
        String filePath = "C:\\image";
        try{
            ImageStoreModel temp = FileUtils.upload(file, filePath, file.getOriginalFilename());
            imageStoreModel.setResult(temp.isResult());
            imageStoreModel.setRealPhotoName(temp.getRealPhotoName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (imageStoreModel.isResult()==true) {
            // 上传成功，给出页面提示
            return  imageStoreModel.getRealPhotoName();
        } else {
            return null;
        }
    }

    public void deleteImage(String fileName)throws IOException{
        File foler = new File("C://image");
        File [] files = foler.listFiles();
        if(!fileName.equals("60528.png")) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    file.delete();
                    break;
                }
            }
        }
    }

    public String getImage(HttpServletResponse response, String path){
        FileInputStream fis = null;
        try {
            OutputStream out = response.getOutputStream();
            File file = new File(path);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
            return PhotoConstResponse.PIC_LOAD_SUCCEED;
        } catch (Exception e) {
            e.printStackTrace();
            return PhotoConstResponse.PIC_LOAD_FAILED;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
