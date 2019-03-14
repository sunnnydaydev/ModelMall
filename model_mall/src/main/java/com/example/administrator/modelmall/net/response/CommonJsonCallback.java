package com.example.administrator.modelmall.net.response;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.modelmall.net.exception.OkHttpException;
import com.example.administrator.modelmall.net.listener.DisposeDataHandle;
import com.example.administrator.modelmall.net.listener.DisposeDataListener;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Create by SunnyDay on 2019/03/05
 */
public class CommonJsonCallback implements Callback {

    /**
     * 自定义类型异常
     * 网络异常
     * json异常
     * 其他异常
     */
    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;


    private Handler mDeliveryHandler; //进行消息转发
    private DisposeDataListener mlistener;
    private Class<?> mClass;

    public CommonJsonCallback(DisposeDataHandle handle) {
        this.mlistener = handle.listener;
        this.mClass = handle.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 请求失败处理
     */
    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mlistener.onFailure(new OkHttpException(NETWORK_ERROR, e.getMessage()));
            }
        });
    }

    /**
     * 请求成功回调
     */
    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();// json 类型 为String就行
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    /**
     * 处理json数据
     *
     * @param responseObj json字符串
     *
     *                   返回数据 默认json  或者实体
     */
    private void handleResponse(String responseObj) {
        // 判空处理
        if (responseObj == null && responseObj.trim().equals("")) {
            mlistener.onFailure(new OkHttpException(NETWORK_ERROR, "net work error"));
            return;
        }
        try {
            if (mClass == null) {
                // 用户不想让我们处理json，直接回传给用户
                mlistener.onSuccess(responseObj);
            } else {
                // 我们处理把json转化为实体
                Gson gson = new Gson();
                Object obj = gson.fromJson(responseObj, mClass);
                if (obj != null) {
                    mlistener.onSuccess(obj);
                } else {
                    // 不是合法的json
                    mlistener.onFailure(new OkHttpException(JSON_ERROR, "illegal json"));
                }
            }
        } catch (Exception e) {
            mlistener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
        }
    }
}
