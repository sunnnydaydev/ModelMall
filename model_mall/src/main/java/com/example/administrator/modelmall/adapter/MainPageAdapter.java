package com.example.administrator.modelmall.adapter;


import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.modelmall.base.BasePage;

import java.util.List;

/**
 * Create by SunnyDay on 2019/03/15
 * <p>
 * 主界面 viewpager的 adapter
 */
public class MainPageAdapter extends PagerAdapter {
    private List<BasePage> mList;

    public MainPageAdapter(List<BasePage> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mList.get(position).view);

        return mList.get(position).view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
