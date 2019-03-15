package com.example.administrator.modelmall.application;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Create by SunnyDay on 2019/03/14
 */
public class LatteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());// Logger初始化
    }
}
