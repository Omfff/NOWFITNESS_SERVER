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




    public enum ErrorCode{
        /**
         * 用户不存在
         */
        USER_NOT_FOUND(40401),

        /**
         * 用户已存在
         */
        USER_ALREADY_EXIST(40001),
        ;

        private int code;
        public int getCode()
        {
            return code;
        }

        ErrorCode(int code)
        {
            this.code = code;
        }

    }
}