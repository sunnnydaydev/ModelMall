package com.example.administrator.modelmall.ui.activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.modelmall.R;

public class AboutActivity extends BaseActivity {


    @Override
    public Object offerLayout() {
        return R.layout.activity_about;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindView() {
       setImmersionStatusBar();
    }

    @Override
    public void destory() {

    }
}
