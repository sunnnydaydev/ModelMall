package com.example.administrator.modelmall.base.impl;

import android.content.Context;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class MinePageImpl extends BasePage {

    public MinePageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_mine;
    }

    @Override
    public void init() {

    }

}
