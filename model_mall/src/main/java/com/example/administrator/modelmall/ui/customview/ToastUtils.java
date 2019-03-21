package com.example.administrator.modelmall.ui.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.modelmall.R;

/**
 * Create by SunnyDay on 2019/03/21
 * 吐司简单 定制 （我们 app的专有吐司）
 *
 * ps：只展示较短的字符串
 */
public class ToastUtils {
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;


    public static void showToast(Context context, CharSequence text,int during) {
        Toast toast = null;
        View view = LayoutInflater.from(context).inflate(R.layout.toast, null, false);
        TextView desc = view.findViewById(R.id.desc);
        desc.setText(text);

            toast = new Toast(context);
            toast.setDuration(during);
            toast.setView(view);
            toast.show();



    }

}
