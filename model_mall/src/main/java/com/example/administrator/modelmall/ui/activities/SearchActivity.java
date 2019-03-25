package com.example.administrator.modelmall.ui.activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.ui.customview.ToastUtils;

import butterknife.BindView;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.search_view)
     SearchView searchView;

    @Override
    public Object offerLayout() {
        return R.layout.activity_search;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindView() {
      setImmersionStatusBar();

       initSearchView();
    }

    private void initSearchView() {

        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                // 框架源码弹吐司 不友好 这里为了实现功能临时使用
                ToastUtils.showToast(SearchActivity.this,"后台小哥的数据库正在搭建",ToastUtils.LENGTH_LONG);
            }
        });
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }

    @Override
    public void destory() {

    }
}
