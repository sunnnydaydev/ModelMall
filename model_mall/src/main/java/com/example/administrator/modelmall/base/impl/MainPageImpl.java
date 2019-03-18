package com.example.administrator.modelmall.base.impl;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;


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

    }

    /**
     * 初始化下拉刷新布局
     */
    private void initRefreshLayout() {
        // 刷新进度条颜色
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        // 刷新进度条位置设置
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
        // 下拉刷新事件监听
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

    }

    /**
     * 下拉刷新数据模拟
     */
    private void refreshData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "没有更多数据了", Toast.LENGTH_LONG).show();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}
