package com.example.demo1.model.response;

import lombok.Data;

@Data
public class SaltResponseModel {
    private String salt;
    public SaltResponseModel(String salt){
        this.salt = salt;
    }
}
