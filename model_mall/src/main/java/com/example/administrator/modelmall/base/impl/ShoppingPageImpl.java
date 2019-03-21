package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;

/**
 * Create by SunnyDay on 2019/03/15
 * 购物车模块
 */
public class ShoppingPageImpl extends BasePage {

    private RecyclerView recyclerView;

    public ShoppingPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_shopping;
    }

    @Override
    public void init() {
        recyclerView = view.findViewById(R.id.shop_cart);
        recyclerView.setAdapter(null);
    }

}
