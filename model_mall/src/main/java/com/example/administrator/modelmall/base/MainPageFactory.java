package com.example.administrator.modelmall.base;

import android.content.Context;

import com.example.administrator.modelmall.base.impl.MainPageImpl;

/**
 * Create by SunnyDay on 2019/03/16
 */
public class MainPageFactory implements Provider {

    Context context;

    public MainPageFactory(Context context) {
        this.context = context;
    }

    @Override
    public BasePage produce() {
        return new MainPageImpl(context);
    }
}
