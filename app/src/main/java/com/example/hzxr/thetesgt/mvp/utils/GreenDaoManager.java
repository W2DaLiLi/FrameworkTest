package com.example.hzxr.thetesgt.mvp.utils;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.example.hzxr.thetesgt.MyApplication;
import com.example.hzxr.thetesgt.mvp.gen.DaoMaster;
import com.example.hzxr.thetesgt.mvp.gen.DaoSession;

/**
 * Created by hzxr on 2017/8/10.
 */

public class GreenDaoManager {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager mInstance;

    private GreenDaoManager(){
        if (mInstance == null){
            DaoMaster.DevOpenHelper devOpenHelper = new
                    DaoMaster.DevOpenHelper(MyApplication.getContext(),"user-db",null);
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance(){
        if (mInstance == null){
            synchronized (GreenDaoManager.class){
                if (mInstance == null){
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getmDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession(){
        return mDaoMaster.newSession();
    }
}
