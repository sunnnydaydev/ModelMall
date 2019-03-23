package com.example.administrator.modelmall.events;

/**
 * Create by SunnyDay on 2019/03/23
 *
 * 商品消息 事件
 */
public class GoodInfoMsg {
    private Integer goodCount;

    public GoodInfoMsg(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }
}
