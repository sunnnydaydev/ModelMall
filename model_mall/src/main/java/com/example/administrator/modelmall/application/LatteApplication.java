package com.example.administrator.modelmall.application;

import android.app.Application;

import com.example.administrator.modelmall.icon.FontModel;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.mob.MobSDK;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.litepal.LitePal;

import cn.sharesdk.framework.ShareSDK;

/**
 * Create by SunnyDay on 2019/03/14
 */
public class LatteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());// Logger
        LitePal.initialize(this);// 数据库
        // 字体图标库
        Iconify.with(new FontAwesomeModule())
                .with(new IoniconsModule())
                .with(new FontModel());

        MobSDK.init(this); // shareSDK
    }
}
