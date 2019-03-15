package com.example.administrator.modelmall.ui.activities;


import android.widget.Toast;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.net.CommonOkHttpClient;
import com.example.administrator.modelmall.net.listener.DisposeDataHandle;
import com.example.administrator.modelmall.net.listener.DisposeDataListener;
import com.example.administrator.modelmall.net.request.CommonRequest;
import com.example.administrator.modelmall.net.response.CommonJsonCallback;

public class MainActivity extends BaseActivity {


    @Override
    public Object offerLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView() {
        // test net
       testNet();

    }

    @Override
    public void destory() {

    }

    private void testNet() {
        String url = "https://www.wanandroid.com/tools/mockapi/7751/mall_mainpage_goods";
        CommonOkHttpClient
                .sendRequest(new CommonRequest().createGetRequest(url,null),new CommonJsonCallback(new DisposeDataHandle(new DisposeDataListener() {
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
