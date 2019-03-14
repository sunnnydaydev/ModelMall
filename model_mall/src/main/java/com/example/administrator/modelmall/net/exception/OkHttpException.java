package com.example.administrator.modelmall.net.exception;

/**
 * Create by SunnyDay on 2019/03/05
 */
public class OkHttpException extends Exception {

    private int ecode;// 服务端返回码
    private Object emsg;// 服务端返回信息

    public OkHttpException(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public void setEcode(int ecode) {
        this.ecode = ecode;
    }

    public Object getEmsg() {
        return emsg;
    }

    public void setEmsg(Object emsg) {
        this.emsg = emsg;
    }
}
