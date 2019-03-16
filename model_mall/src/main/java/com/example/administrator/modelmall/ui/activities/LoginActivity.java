package com.example.administrator.modelmall.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.db.UserRegisterBean;
import com.orhanobut.logger.Logger;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends BaseActivity {


    @Override
    public Object offerLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onBindView() {
        hideActionBar();
        List<UserRegisterBean> user = DataSupport.findAll(UserRegisterBean.class);
        for (UserRegisterBean userInfo:user){
            Logger.d(userInfo.getName());
            Logger.d(userInfo.getEmail());
            Logger.d(userInfo.getPhone());
            Logger.d(userInfo.getPwd());
        }
    }

    @Override
    public void destory() {

    }
}
