package com.example.hzxr.thetesgt.mvp.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hzxr on 2017/8/9.
 */

@Entity
public class User {
    @Id
    private String userName;
    private String passWord;

    @Generated(hash = 2134531238)
    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
