package com.example.administrator.modelmall.base.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.base.BasePage;
import com.example.administrator.modelmall.ui.activities.AboutActivity;
import com.example.administrator.modelmall.ui.customview.ToastUtils;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class MinePageImpl extends BasePage implements View.OnClickListener {

    public MinePageImpl(Context context) {
        super(context);
    }

    @Override
    public Object setContentView() {
        return R.layout.page_mine;
    }

    @Override
    public void init() {
        RelativeLayout myGoods = view.findViewById(R.id.rl_my_goods);
        RelativeLayout myGoodsAddr = view.findViewById(R.id.rl_goods_addr);
        RelativeLayout setting = view.findViewById(R.id.rl_setting);
        myGoods.setOnClickListener(this);
        myGoodsAddr.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_my_goods:
                ToastUtils.showToast(context,"待续",ToastUtils.LENGTH_SHORT);
                break;
            case R.id.rl_goods_addr:
                ToastUtils.showToast(context,"待续",ToastUtils.LENGTH_SHORT);
                break;
            case R.id.rl_setting:
                context.startActivity(new Intent(context,AboutActivity.class));
                break;
        }
    }
}
