package com.example.administrator.modelmall.net.https;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Create by SunnyDay on 2019/03/05
 * <p>
 * https 相关知识 参考  张鸿洋 Android Https相关完全解析 当OkHttp遇到Https
 * 友情链接：https://blog.csdn.net/lmj623565791/article/details/48129405
 */
public class HttpsUtils {
    /**
     * trust all https point
     */
    public static SSLSocketFactory getSslSorcetFactory(){
        // 1 生成信任管理器类
        X509TrustManager manager = new X509TrustManager() {
            //  所有的重写方法空实现即可
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        // 2 创建加密上下文
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");// 协议类型与服务器保持一致
            X509TrustManager[] xTrustArray = new X509TrustManager[]{manager};
            sslContext.init(null, xTrustArray, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslContext.getSocketFactory();
    }
}
