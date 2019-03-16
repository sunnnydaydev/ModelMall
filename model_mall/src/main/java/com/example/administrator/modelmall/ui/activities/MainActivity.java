package com.example.administrator.modelmall.ui.activities;


import android.support.v4.view.ViewPager;
import android.widget.Toast;

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
import com.example.administrator.modelmall.net.CommonOkHttpClient;
import com.example.administrator.modelmall.net.listener.DisposeDataHandle;
import com.example.administrator.modelmall.net.listener.DisposeDataListener;
import com.example.administrator.modelmall.net.request.CommonRequest;
import com.example.administrator.modelmall.net.response.CommonJsonCallback;

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

    @Override
    public Object offerLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView() {
        handleBottomButton();
        initViewpager();
    }

    private void initViewpager() {
        initViewpagerData();
        viewPager.setAdapter(new MainPageAdapter(mList));
    }

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

    @Override
    public void destory() {

    }

    private void testNet() {
        String url = "https://www.wanandroid.com/tools/mockapi/7751/mall_mainpage_goods";
        CommonOkHttpClient
                .sendRequest(new CommonRequest().createGetRequest(url, null), new CommonJsonCallback(new DisposeDataHandle(new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        Toast.makeText(MainActivity.this, responseObj.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Object reasonObj) {

                    }
                })));
    }
}
