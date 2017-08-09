package com.example.hzxr.thetesgt.mvp.net;

import com.example.hzxr.thetesgt.mvp.bean.User;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hzxr on 2017/8/9.
 */

public interface UserService {
    @POST("login")
    @FormUrlEncoded
    Observable<User> getUser(@Field("username") String name , @Field("password") String passwd);
}
