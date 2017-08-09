package com.example.hzxr.thetesgt.mvp.bean;

/**
 * Created by hzxr on 2017/8/8.
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
