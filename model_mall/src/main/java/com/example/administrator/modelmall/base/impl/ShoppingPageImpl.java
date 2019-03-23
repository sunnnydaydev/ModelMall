package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;
import com.example.administrator.modelmall.events.GoodInfoMsg;
import com.example.administrator.modelmall.ui.activities.MainActivity;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Create by SunnyDay on 2019/03/15
 * 购物车模块
 */
public class ShoppingPageImpl extends BasePage {

    private RecyclerView recyclerView;
    public GoodInfoMsg goodInfo;

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

        // 传this  传 context 报错
        EventBus.getDefault().register(this);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(GoodInfoMsg goodInfoMsg) {
        goodInfo = goodInfoMsg;
        Logger.d("收到消息：通知显示商品"+goodInfoMsg.getGoodCount());

    }

}
