package com.example.administrator.modelmall.net.request;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create by SunnyDay on 2019/03/04
 *
 * @function 封装所有的请求参数到hashMap中。
 * 友情链接：
 * 1 map集合遍历参考 https://www.cnblogs.com/blest-future/p/4628871.html
 * 2 匿名内部类，非静态代码块 使用参考 https://blog.csdn.net/luman1991/article/details/53034602#commentBox
 * https://www.cnblogs.com/chenssy/p/3390871.html
 * https://zhangbo-peipei-163-com.iteye.com/blog/2023001
 * (具体参考 查找资料 java 匿名内部类的写法 ，java相关属性参数初始化顺序)
 */
public class RequestParams {
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<>();

    /**
     * @param source map类型参数
     * @function 构造器 吧用户传来map类型的参数存入我们的集合
     */
    public RequestParams(Map<String, String> source) {
        if (source != null) {
            //遍历key value集合
            for (Map.Entry<String, String> entry : source.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * @function 构造器 接收 String类型的key value 请求参数 存入集合
     */
    public RequestParams(final String key, final String value) {
        // 参考 类注释的友情链接
        this(new HashMap<String, String>() {
            {
                put(key, value);
            }
        });


    }

    /**
     * @function 空请求参数
     */
    public RequestParams() {
        this((Map<String, String>) null);
    }

    /**
     * @param key   请求参数key
     * @param value 请求参数value
     * @function key value 放入hashmap
     */
    public void put(String key, String value) {
        if (key != null && value != null) {
            urlParams.put(key, value);
        }
    }

    /**
     * @param key    请求参数key
     * @param object 请求参数obj
     * @function 吧请求参数存入集合
     */
    public void put(String key, Object object) throws FileNotFoundException {
        if (key != null) {
            fileParams.put(key, object);
        }
    }

    /**
     * @funtion 判断是否有请求参数
     */
    public boolean hasParams() {
        if (urlParams.size() > 0 || fileParams.size() > 0) {
            return true;
        }
        return false;
    }

}
