package com.example.hzxr.thetesgt.mvp.presenter;

import android.util.Log;

import com.example.hzxr.thetesgt.mvp.bean.User;
import com.example.hzxr.thetesgt.mvp.biz.IUserBiz;
import com.example.hzxr.thetesgt.mvp.biz.OnLoginListener;
import com.example.hzxr.thetesgt.mvp.biz.UserBiz;
import com.example.hzxr.thetesgt.mvp.view.IUserLoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by hzxr on 2017/8/9.
 */

public class UserLoginPresenter {

    private IUserBiz mIUserBiz;
    private IUserLoginView mIUserLoginView;

    public UserLoginPresenter(IUserLoginView iUserLoginView){
        this.mIUserLoginView = iUserLoginView;
        this.mIUserBiz = new UserBiz();
        EventBus.getDefault().register(this);
    }

    public void login(){
        mIUserLoginView.showLoading();
        mIUserBiz.login(mIUserLoginView.getUsername(), mIUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSucess(User user) {
                EventBus.getDefault().post(user);
            }

            @Override
            public void loginFailed(String info) {
                EventBus.getDefault().post(info);
            }
        });
    }

    public void clear(){
        mIUserLoginView.clearUsername();
        mIUserLoginView.clearPassword();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleMessage(User user){
        mIUserLoginView.toMainActivity(user);
        mIUserLoginView.hideLoading();
        Log.d("Sucesess:","working");
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String info){
        mIUserLoginView.showFailedError(info);
        mIUserLoginView.hideLoading();
        Log.d("failed","working");
    }

}
