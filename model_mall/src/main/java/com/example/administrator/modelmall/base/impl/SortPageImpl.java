package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.widget.TextView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class SortPageImpl extends BasePage {
    @BindView(R.id.sort)
   public  TextView textView;

    public SortPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_sort;
    }

    @Override
    public void init() {
        ButterKnife.bind(view);
             textView.setText("这是分类界面");

    }

}
