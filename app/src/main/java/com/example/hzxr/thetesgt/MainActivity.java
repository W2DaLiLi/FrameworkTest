package com.example.hzxr.thetesgt;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hzxr.thetesgt.mvp.LoginActivity;
import com.example.hzxr.thetesgt.mvp.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.test_button)
    public FloatingActionButton mButton;

    @BindView(R.id.imageView)
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }
    @OnClick(R.id.test_button)
    public void click(){
        //Snackbar.make(mButton,"Hello",Snackbar.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().unregister(LoginActivity.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvnet(MessageEvent messageEvent){
        String url = messageEvent.getMessage();
        RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher);
        Glide.with(this)
                .load(url)
                .apply(options)
                .into(imageView);
    }
}
