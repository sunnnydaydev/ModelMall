package com.example.administrator.modelmall.net.listener;

/**
 * Create by SunnyDay on 2019/03/05
 */
public class DisposeDataHandle {
    public DisposeDataListener listener = null;
    public Class<?> mClass = null;

    public DisposeDataHandle(DisposeDataListener listener) {
        this.listener = listener;
    }


    public DisposeDataHandle(Class<?> mClass ,DisposeDataListener listener ) {
        this.listener = listener;
        this.mClass = mClass;

    }
}
