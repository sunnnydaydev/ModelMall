package com.example.administrator.modelmall.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


/**
 * Create by SunnyDay on 2019/03/15
 *
 * 五个界面的基类
 */
public abstract class BasePage {
    public Context context;
    public View view;

    public BasePage(Context context) {
        this.context = context;
        if (convertView() == null) {
            throw new ClassCastException("resource id just can be type of layout");
        }
        this.view = convertView();
        init();
    }

    /**
     * 实现类提供  资源id ，或者view
     */
    public abstract Object setContentView();

    /**
     * 具体子实现
     */
    public abstract void init();


    /**
     * view的同一转换处理
     * */
    private View convertView() {
        View view = null;
        if (setContentView() instanceof Integer) {
            view = LayoutInflater.from(context).inflate((Integer) setContentView(), null, false);
        } else if (setContentView() instanceof View) {
            view = (View) setContentView();
        } else {
            throw new IllegalArgumentException("offerLayout only be View or be Resource Id");
        }
        return view;
    }

}
