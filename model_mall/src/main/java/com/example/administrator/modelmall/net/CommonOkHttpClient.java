package com.example.administrator.modelmall.net;


import com.example.administrator.modelmall.net.https.HttpsUtils;
import com.example.administrator.modelmall.net.response.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Create by SunnyDay on 2019/03/04
 *
 * @function 请求的发送 请求参数的配置  https的支持
 */
public class CommonOkHttpClient {
    private static final int TIME_OUT = 30;// 超时
    private static OkHttpClient okHttpClient;

    // client的一些参数配置   在类第一次加载时完成
    static {
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);//连接超时
        okhttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);//读超时
        okhttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);//写超时
        okhttpBuilder.followRedirects(true);// 允许重定向

        // 添加对所有https的支持
        okhttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true; //true: 支持任意类型的https（无论官方购买的https，或者是自己生成的https请求）
            }
        });
        okhttpBuilder.sslSocketFactory(HttpsUtils.getSslSorcetFactory());
        // 生成client对象
        okHttpClient = okhttpBuilder.build();
    }

    /**
     * 发送具体的http/https请求
     * @param request
     * @param commCallback
     * @return call
     *
     * */
    public static Call sendRequest(Request request, CommonJsonCallback commCallback) {
        Call call = okHttpClient.newCall(request);
        call.enqueue((Callback) commCallback);
        return call;
    }
}
