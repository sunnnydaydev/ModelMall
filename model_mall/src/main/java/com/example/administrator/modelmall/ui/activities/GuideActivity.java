package com.example.administrator.modelmall.ui.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.loader.ModelImageLoader;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;

public class GuideActivity extends BaseActivity {
    @BindView(R.id.banner)
    public Banner banner;
    @BindView(R.id.btn_start)
    public AppCompatTextView btnStart;
    private List<Integer> images;

    @Override
    public Object offerLayout() {
        return R.layout.activity_guide;
    }

    @Override
    public void onBindView() {
        setNoTitleBarAndFullScreen();
        initBannerData();
        initViews();
    }

    private void initViews() {
        banner.setImageLoader(new ModelImageLoader())
                .setImages(images)
                .isAutoPlay(false)
                .start();
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                if (i == images.size() - 1) {
                    btnStart.setVisibility(View.VISIBLE);
                    btnStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(GuideActivity.this, LoginActivity.class));
                            finish();
                        }
                    });
                } else {
                    btnStart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

    }

    /**
     * 初始化banner数据
     */
    private void initBannerData() {
        images = new ArrayList<>();
        images.add(R.drawable.launcher_01);
        images.add(R.drawable.launcher_02);
        images.add(R.drawable.launcher_03);
        images.add(R.drawable.launcher_04);
        images.add(R.drawable.launcher_05);
    }

    @Override
    public void destory() {
    }
}
