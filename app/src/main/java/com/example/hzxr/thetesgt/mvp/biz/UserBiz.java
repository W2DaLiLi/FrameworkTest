package com.example.hzxr.thetesgt.mvp.biz;

import android.util.Log;

import com.example.hzxr.thetesgt.mvp.bean.User;
import com.example.hzxr.thetesgt.mvp.net.UserService;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hzxr on 2017/8/9.
 */

public class UserBiz implements IUserBiz{

    //model层完成与服务器连接等好书操作逻辑，放在子线程中操作
    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        String baseUrl = "http://10.0.3.2:8080/IMServer/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);
        userService.getUser(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {


                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(User mUser) {
                        if (mUser.getUserName().equals("ok")){
                            User user = new User();
                            user.setUserName(username);
                            user.setPassWord(password);
                            listener.loginSucess(user);
                        }else{
                            listener.loginFailed("Error");
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        listener.loginFailed(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                Log.d("TAG",response.body().getUserName());
//                if (response.code()== 200){
//                    User user = new User();
//                    user.setUserName(username);
//                    user.setPassWord(password);
//                    listener.loginSucess(user);
//                }else{
//                    listener.loginFailed(String.valueOf(response.code()));
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                t.printStackTrace();
//                listener.loginFailed(t.getMessage().toString());
//            }
//        });
    }
}
