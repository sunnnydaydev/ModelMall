package com.example.administrator.modelmall.ui.activities;


import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.net.CommonOkHttpClient;
import com.example.administrator.modelmall.net.listener.DisposeDataHandle;
import com.example.administrator.modelmall.net.listener.DisposeDataListener;
import com.example.administrator.modelmall.net.request.CommonRequest;
import com.example.administrator.modelmall.net.response.CommonJsonCallback;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_bottom_navigation)
    public BottomNavigationBar buttonBottom;

    @Override
    public Object offerLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView() {

        handleBottomButton();
    }

    /**
     * 底部导航处理
     */
    private void handleBottomButton() {
        buttonBottom.addItem(new BottomNavigationItem(R.drawable.zhuye, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.fenlei, "分类"))
                .addItem(new BottomNavigationItem(R.drawable.faxian, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.gouwuche, "购物车"))
                .addItem(new BottomNavigationItem(R.drawable.wode, "我的"))
                .initialise();
    }

        @Override
        public void destory () {

        }

        private void testNet () {
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
