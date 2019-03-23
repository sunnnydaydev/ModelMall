package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.adapter.ShopCartAdapter;
import com.example.administrator.modelmall.base.BasePage;
import com.example.administrator.modelmall.events.GoodInfoMsg;
import com.example.administrator.modelmall.ui.activities.MainActivity;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by SunnyDay on 2019/03/15
 * 购物车模块
 */
public class ShoppingPageImpl extends BasePage {

    private RecyclerView recyclerView;
    private ShopCartAdapter adapter;
    private List<Integer> mList;
    private TextView tvEmpty;


    public ShoppingPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_shopping;
    }

    @Override
    public void init() {
        EventBus.getDefault().register(this); // 传this , 传 context 报错
        mList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.shop_cart);
        tvEmpty = view.findViewById(R.id.tv_empty);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new ShopCartAdapter(context, mList);
        recyclerView.setAdapter(adapter);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(GoodInfoMsg goodInfoMsg) {
        tvEmpty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        Logger.d("收到消息：通知显示商品" + goodInfoMsg.getGoodCount());
        int size = goodInfoMsg.getGoodCount();//没啥鸡用  必须写
        mList.add(size);// 没啥鸡用   必须写
        adapter.notifyDataSetChanged();

    }

}
