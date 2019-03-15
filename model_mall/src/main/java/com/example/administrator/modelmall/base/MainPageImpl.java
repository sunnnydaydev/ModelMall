package com.example.administrator.modelmall.base;

import android.content.Context;

import com.example.administrator.modelmall.R;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class MainPageImpl extends BasePage {
    public MainPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_main;
    }

    @Override
    public void init() {

    }
}
