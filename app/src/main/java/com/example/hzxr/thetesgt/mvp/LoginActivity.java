package com.example.hzxr.thetesgt.mvp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.hzxr.thetesgt.MainActivity;
import com.example.hzxr.thetesgt.R;
import com.example.hzxr.thetesgt.mvp.bean.User;
import com.example.hzxr.thetesgt.mvp.presenter.UserLoginPresenter;
import com.example.hzxr.thetesgt.mvp.view.IUserLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IUserLoginView {

    @BindView(R.id.bt_login)
    public Button mLoginButton;
    @BindView(R.id.bt_clear)
    public Button mClearButton;
    @BindView(R.id.et_username)
    public EditText mUsernameEdittext;
    @BindView(R.id.et_password)
    public EditText mPasswordEdittext;
    @BindView(R.id.progressBar)
    public ProgressBar mProgressBar;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_login)
    public void onLogin(){
        userLoginPresenter.login();
    }

    @OnClick(R.id.bt_clear)
    public void onClear(){
        //clear
        userLoginPresenter.clear();
    }

    @Override
    public String getUsername() {
        return mUsernameEdittext.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEdittext.getText().toString();
    }

    @Override
    public void clearUsername() {
        mUsernameEdittext.setText("");

    }

    @Override
    public void clearPassword() {
        mPasswordEdittext.setText("");
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showFailedError(String info) {
        Snackbar.make(getWindow().getDecorView(),""+info,Snackbar.LENGTH_SHORT).show();
    }
}
