package com.example.demo1.util;

import java.util.UUID;

 /**
  * @Description:  生成唯一标识符UUID的工具类
  */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}