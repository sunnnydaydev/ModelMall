package com.example.administrator.modelmall.ui.activities;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.adapter.MainPageAdapter;
import com.example.administrator.modelmall.base.BasePage;
import com.example.administrator.modelmall.base.FindPageFactory;
import com.example.administrator.modelmall.base.MainPageFactory;
import com.example.administrator.modelmall.base.MinePageFactory;
import com.example.administrator.modelmall.base.ShoppingPageFactory;
import com.example.administrator.modelmall.base.SortPageFactory;
import com.example.administrator.modelmall.events.GoodInfoMsg;
import com.example.administrator.modelmall.net.CommonOkHttpClient;
import com.example.administrator.modelmall.net.listener.DisposeDataHandle;
import com.example.administrator.modelmall.net.listener.DisposeDataListener;
import com.example.administrator.modelmall.net.request.CommonRequest;
import com.example.administrator.modelmall.net.response.CommonJsonCallback;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_bottom_navigation)
    public BottomNavigationBar buttonBottom;
    @BindView(R.id.viewpager)
    public ViewPager viewPager;
    private List<BasePage> mList;
    public GoodInfoMsg goodInfo;

    @Override
    public Object offerLayout() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindView() {
       // EventBus.getDefault().register(this);
        setImmersionStatusBar();
        handleBottomButton();
        initViewpager();
        initListener();


    }

    /**
     * viewpager  与BottomNavigationBar 的事件监听
     */
    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                buttonBottom.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        buttonBottom.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    /**
     * viewpager的操作
     */
    private void initViewpager() {
        initViewpagerData();
        viewPager.setAdapter(new MainPageAdapter(mList));
    }

    /**
     * viewpager 的数据源
     */
    private void initViewpagerData() {
        mList = new ArrayList<>();
        mList.add(new MainPageFactory(MainActivity.this).produce());
        mList.add(new SortPageFactory(MainActivity.this).produce());
        mList.add(new FindPageFactory(MainActivity.this).produce());
        mList.add(new ShoppingPageFactory(MainActivity.this).produce());
        mList.add(new MinePageFactory(MainActivity.this).produce());
    }

    /**
     * 底部导航处理
     */
    private void handleBottomButton() {
        buttonBottom
                .setBackgroundStyle(BACKGROUND_STYLE_RIPPLE)  // 点击样式
                .setBarBackgroundColor(R.color.orange) // 字体 、图标 背景颜色
                .setInActiveColor(R.color.gray) // 未选中状态颜色
                .setActiveColor(R.color.white) // 条目背景色
                .addItem(new BottomNavigationItem(R.drawable.zhuye, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.fenlei, "分类"))
                .addItem(new BottomNavigationItem(R.drawable.faxian, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.gouwuche, "购物车"))
                .addItem(new BottomNavigationItem(R.drawable.wode, "我的"))
                .initialise();
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void Event(GoodInfoMsg goodInfoMsg) {
//        goodInfo = goodInfoMsg;
//        Logger.d(goodInfoMsg.getGoodCount());
//    }

    @Override
    public void destory() {
//        if (EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().unregister(this);
//        }
    }
}

