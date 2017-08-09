package com.example.hzxr.thetesgt.mvp.biz;

import com.example.hzxr.thetesgt.mvp.bean.User;

/**
 * Created by hzxr on 2017/8/9.
 */

public interface OnLoginListener {
    void loginSucess(User user);
    void loginFailed(String info);
}
