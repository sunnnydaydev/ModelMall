package com.example.administrator.modelmall.base.impl;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.airbnb.lottie.LottieAnimationView;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.adapter.SortLeftAdapter;
import com.example.administrator.modelmall.base.BasePage;
import com.example.administrator.modelmall.events.GoodInfoMsg;
import com.example.administrator.modelmall.ui.activities.GoodsInfoActivity;
import com.example.administrator.modelmall.ui.customview.ToastUtils;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Create by SunnyDay on 2019/03/15
 * <p>
 * 此界面只是简单的模拟  实际开发中 rv+viewpager（fragment的adapter）解决
 */
public class SortPageImpl extends BasePage implements View.OnClickListener {

    private RecyclerView rvLeft;
    private ImageView imgSort;
    private LinearLayout llRecomment;
    private LinearLayout llHotSort;
    private LottieAnimationView lavLoading;


    public SortPageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_sort;
    }

    @Override
    public void init() {
        EventBus.getDefault().register(this);
        rvLeft = view.findViewById(R.id.rv_left);

        imgSort = view.findViewById(R.id.img_sort);
        llRecomment = view.findViewById(R.id.ll_recomment);
        llHotSort = view.findViewById(R.id.ll_hot_sort);
        lavLoading = view.findViewById(R.id.lav_loading);

        imgSort.setOnClickListener(this);
        llRecomment.setOnClickListener(this);
        llHotSort.setOnClickListener(this);


        rvLeft.setLayoutManager(new LinearLayoutManager(context));
        rvLeft.setAdapter(new SortLeftAdapter(context));

        lavLoading.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                imgSort.setVisibility(View.GONE);
                llHotSort.setVisibility(View.GONE);
                llRecomment.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                lavLoading.setVisibility(View.GONE);
                imgSort.setVisibility(View.VISIBLE);
                llHotSort.setVisibility(View.VISIBLE);
                llRecomment.setVisibility(View.VISIBLE);
                ToastUtils.showToast(context, "数据更新完毕", ToastUtils.LENGTH_LONG);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_sort:
            case R.id.ll_recomment:
            case R.id.ll_hot_sort:
                context.startActivity(new Intent(context, GoodsInfoActivity.class));
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String string) {
        // 播放动画

        lavLoading.setVisibility(View.VISIBLE);
        lavLoading.setRepeatCount(3);
        lavLoading.playAnimation();

    }
}
