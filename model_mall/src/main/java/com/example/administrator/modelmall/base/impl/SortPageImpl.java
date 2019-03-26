package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.adapter.SortLeftAdapter;
import com.example.administrator.modelmall.base.BasePage;


/**
 * Create by SunnyDay on 2019/03/15
 */
public class SortPageImpl extends BasePage {

    private RecyclerView rvLeft;


    public SortPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_sort;
    }

    @Override
    public void init() {
        rvLeft = view.findViewById(R.id.rv_left);
        rvLeft.setLayoutManager(new LinearLayoutManager(context));
        rvLeft.setAdapter(new SortLeftAdapter(context));



    }

}
