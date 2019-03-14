package com.example.administrator.modelmall.ui.activities;


import android.widget.Toast;

import com.example.administrator.modelmall.R;

public class MainActivity extends BaseActivity {


    @Override
    public Object offerLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindview() {
        Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
    }
}
