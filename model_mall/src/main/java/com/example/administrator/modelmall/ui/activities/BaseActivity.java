package com.example.administrator.modelmall.ui.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by SunnyDay on 2019/03/14
 * <p>
 * 此app activity的基类
 * （抽象类的设计，深入理解面向对象的核心思想）
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    private View mConvertView;
    private Unbinder mBinder;

    /**
     * 加 final 不让子类 重写 onCreate，让其实现我们想要让他实现的方法
     */
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConvertView = convertView();
        if (mConvertView == null) {
            // 传其他资源id 时的处理（只能传布局资源id ）
            throw new ClassCastException("view convert fail，check your resource id  be layout resource");
        } else {
            setContentView(mConvertView);
            mBinder = ButterKnife.bind(this);
            onBindView();

        }

    }

    /**
     * 提供布局
     * 可以为 资源id
     * 可以为 view
     */
    public abstract Object offerLayout();

    /**
     * 处理view。 用户做自己的工作
     */
    public abstract void onBindView();

    public abstract void destory();

    /**
     * view的处理
     * 实现类 传布局资源ID 或者传view
     * 此处进行统一处理
     */
    private View convertView() {
        View view = null;
        if (offerLayout() instanceof Integer) {
            view = LayoutInflater.from(this).inflate((Integer) offerLayout(), null, false);
        } else if (offerLayout() instanceof View) {
            view = (View) offerLayout();
        } else {
            throw new IllegalArgumentException("offerLayout only be View or be Resource Id");
        }
        return view;
    }

    /**
     * ButterKnife的解绑
     */
    @Override
    public void onDestroy() {
        // 解绑
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
        mConvertView = null; // call gc
        super.onDestroy();
        destory();
    }

    /**
     * 全屏 且隐藏标题栏
     * （子类需要直接使用）
     */
    public void setNoTitleBarAndFullScreen() {
        // requestWindowFeature(Window.FEATURE_NO_TITLE); 此句必须在setContent之前
        getSupportActionBar().hide();// 标题栏的隐藏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //全屏处理
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 沉浸式状态栏
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setImmersionStatusBar() {
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * 隐藏actionbar
     * */
    public void hideActionBar(){
        getSupportActionBar().hide();
    }

}
