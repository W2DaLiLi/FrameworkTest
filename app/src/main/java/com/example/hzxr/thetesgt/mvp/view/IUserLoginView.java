package com.example.hzxr.thetesgt.mvp.view;

import com.example.hzxr.thetesgt.mvp.bean.User;

/**
 * Created by hzxr on 2017/8/9.
 */

public interface IUserLoginView {
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError(String info);
}
