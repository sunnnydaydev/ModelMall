package com.example.administrator.modelmall.base.impl;

import android.content.Context;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class FindPageImpl extends BasePage {

    public FindPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_find;
    }

    @Override
    public void init() {

    }

}
