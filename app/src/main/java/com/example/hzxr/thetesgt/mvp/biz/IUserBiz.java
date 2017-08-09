package com.example.hzxr.thetesgt.mvp.biz;

/**
 * Created by hzxr on 2017/8/9.
 */

public interface IUserBiz {
    public void login(String username , String password , OnLoginListener listener);
}
