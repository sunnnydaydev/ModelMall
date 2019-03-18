package com.example.administrator.modelmall.base.impl;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;
import com.orhanobut.logger.Logger;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class MainPageImpl extends BasePage {
    private Activity context;
    private SwipeRefreshLayout mRefreshLayout;

    public MainPageImpl(Context context) {
        super(context);
        this.context = (Activity) context;
    }

    @Override
    public Object setContentView() {
        return R.layout.page_main;
    }

    @Override
    public void init() {
        mRefreshLayout = view.findViewById(R.id.srl_refresh);
        initRefreshLayout();
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
    }

    /**
     * 初始化下拉刷新布局
     */
    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
        Logger.d("测试1");

    }

    /**
     * 下拉刷新数据（测试使用）
     */
    private void refreshData() {
        Toast.makeText(context, "没有更多数据", Toast.LENGTH_LONG).show();
        mRefreshLayout.setRefreshing(false);
    }

}
