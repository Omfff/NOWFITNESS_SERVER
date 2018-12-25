package com.example.demo1.model.response;

import lombok.Data;

@Data
public class IsFollowingResponseModel {
    private boolean states;
    public IsFollowingResponseModel(boolean states){
        this.states = states;
    }
}
