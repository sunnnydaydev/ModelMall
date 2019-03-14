package com.example.administrator.modelmall.net.request;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Create by SunnyDay on 2019/03/04
 *
 * @function 接收请求参数 为我们生成Request对象
 */
public class CommonRequest {
    /**
     * @function post 请求
     * @param url    url
     * @param params 请求参数
     *
     */
    public static Request createPostRequest(String url, RequestParams params) {
        FormBody.Builder builder = new FormBody.Builder();
        // 吧请求内容添加到请求体中
        for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        // 构建请求体
        FormBody formBody = builder.build();
         // 返回封装的Request请求
        return new Request.Builder().post(formBody).build();
    }

    /**
     * @function get 请求
     * @param url    url
     * @param params 请求参数
     *     通过url+请求参数的拼接 成我们的get请求url，在生成Request请求
     *
     *               get url 的方式  域名 ？ key = value & key = value ......
     *   有参数就拼接url再请求， 没有参数就使用给的拼接好的url
     */
    public static Request createGetRequest(String url, RequestParams params){
        StringBuilder sb = new StringBuilder(url).append("?");
        if (params!=null){
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
               sb.append(entry.getKey())
                       .append("=")
                       .append(entry.getValue())
                       .append("&");
            }
            String disposedUrl = sb.toString().substring(sb.length()-1);// 去掉最后一个多余的&字符串
            return new Request.Builder()
                    .url(disposedUrl)
                    .get()
                    .build();
        }else{
            return new Request.Builder()
                    .url(url)
                    .get()
                    .build();
        }

    }
}
