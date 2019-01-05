package com.example.demo1.Exception;

import lombok.Data;

@Data
public class Result
{
    /**
     * 错误内容
     */
    private String error;

    /**
     * 自定义错误码
     */
    private int code;


    public Result(String error, int code)
    {
        this.error = error;
        this.code = code;
    }
}