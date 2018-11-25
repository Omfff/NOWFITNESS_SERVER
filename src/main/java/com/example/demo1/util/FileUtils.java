package com.example.demo1.util;

import com.example.demo1.model.ImageStoreModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    /**
     * @param file     文件
     * @param filePath 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static ImageStoreModel upload(MultipartFile file, String filePath, String fileName) throws Exception {

        ImageStoreModel imageStoreModel = new ImageStoreModel();
        String realName = FileNameUtils.getFileName(fileName);
        String realPath = filePath + "/" + realName;
        imageStoreModel.setRealPhotoName(realName);
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(dest);
            imageStoreModel.setResult(true);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            imageStoreModel.setResult(false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            imageStoreModel.setResult(false);
        }
        return imageStoreModel;
    }
}

