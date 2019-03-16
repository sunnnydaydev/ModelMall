package com.example.administrator.modelmall.base;

import android.content.Context;

import com.example.administrator.modelmall.base.impl.MainPageImpl;
import com.example.administrator.modelmall.base.impl.SortPageImpl;

/**
 * Create by SunnyDay on 2019/03/16
 */
public class SortPageFactory implements Provider {

    Context context;

    public SortPageFactory(Context context) {
        this.context = context;
    }

    @Override
    public BasePage produce() {
        return new SortPageImpl(context);
    }
}
