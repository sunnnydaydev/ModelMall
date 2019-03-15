package com.example.administrator.modelmall.utils;
import android.os.CountDownTimer;
/**
 * Create by SunnyDay on 2019/03/15
 * 倒计时工具封装
 */
public class TimeCount extends CountDownTimer {

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimeCount(long millisInFuture, long countDownInterval) {
        super(millisInFuture,countDownInterval);
    }

    /**
     * 处理倒计时期间逻辑
     *
     * */
    @Override
    public void onTick(long millisUntilFinished) {
       // TODO
    }

    /**
     * 倒计时结束处理
     * */
    @Override
    public void onFinish() {
     // TODO
    }

}
