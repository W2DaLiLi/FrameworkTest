package com.example.hzxr.thetesgt;

import android.app.Application;
import android.content.Context;

import com.example.hzxr.thetesgt.mvp.utils.GreenDaoManager;

/**
 * Created by hzxr on 2017/8/10.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
