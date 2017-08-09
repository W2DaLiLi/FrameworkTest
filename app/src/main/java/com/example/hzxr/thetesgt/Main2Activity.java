package com.example.hzxr.thetesgt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.hzxr.thetesgt.mvp.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.bt_send)
    public Button mSendButton;

    @BindView(R.id.tv_show)
    public TextView mShowTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_send)
    public void click(){
        EventBus.getDefault().post(new MessageEvent("http://dynamic-image.yesky.com/740x-/uploadImages/2016/337/31/52T7EZF70G1Z.jpg"));
        finish();
    }
}
