package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.adapter.FindAdapter;
import com.example.administrator.modelmall.base.BasePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class FindPageImpl extends BasePage {

    private RecyclerView recyclerView;

    public FindPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_find;
    }

    @Override
    public void init() {
        recyclerView = view.findViewById(R.id.recycler_find);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new FindAdapter(context));
    }

}
