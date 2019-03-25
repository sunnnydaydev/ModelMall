package com.example.administrator.modelmall.base.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import com.example.administrator.modelmall.Constant.ModelConstant;
import com.example.administrator.modelmall.R;

import com.example.administrator.modelmall.adapter.MainPageBannerAdapter;
import com.example.administrator.modelmall.adapter.MainPageClassifyGridItemAdapter;
import com.example.administrator.modelmall.adapter.MainPageHotSortAdapter;
import com.example.administrator.modelmall.adapter.MainPageMoreImageAdapter;
import com.example.administrator.modelmall.adapter.MainPageRecommentAdapter;
import com.example.administrator.modelmall.adapter.MainPageSingleImageAdapter;
import com.example.administrator.modelmall.base.BasePage;
import com.example.administrator.modelmall.entity.EntityMainPage;
import com.example.administrator.modelmall.net.CommonOkHttpClient;
import com.example.administrator.modelmall.net.listener.DisposeDataHandle;
import com.example.administrator.modelmall.net.listener.DisposeDataListener;
import com.example.administrator.modelmall.net.request.CommonRequest;
import com.example.administrator.modelmall.net.response.CommonJsonCallback;

import com.example.administrator.modelmall.ui.activities.MainActivity;
import com.example.administrator.modelmall.ui.activities.MsgActivity;
import com.example.administrator.modelmall.ui.activities.SearchActivity;
import com.example.administrator.modelmall.ui.customview.ToastUtils;
import com.google.zxing.integration.android.IntentIntegrator;
import com.joanzapata.iconify.widget.IconTextView;
import com.orhanobut.logger.Logger;


/**
 * Create by SunnyDay on 2019/03/15
 */
public class MainPageImpl extends BasePage implements View.OnClickListener{
    private Activity context;
    private SwipeRefreshLayout mRefreshLayout;
    private IconTextView scan;
    private IconTextView msg;
    private RecyclerView recyclerView;
    private FloatingActionButton recomment;
    private DelegateAdapter adapter;
    private EntityMainPage entity;
    private AppCompatEditText etSearch;

    public MainPageImpl(Context context) {
        super(context);
        this.context = (Activity) context;
    }

    @Override
    public Object setContentView() {
        return R.layout.page_main;
    }

    @Override
    public void init() {
        mRefreshLayout = view.findViewById(R.id.srl_refresh);
        scan = view.findViewById(R.id.tv_scan);
        msg = view.findViewById(R.id.tv_msg);
        recyclerView = view.findViewById(R.id.recycler_view);
        recomment = view.findViewById(R.id.recomment);
        etSearch = view.findViewById(R.id.et_search);

        initRefreshLayout();
        getDataFromSever();

        recomment.setOnClickListener(this);
        msg.setOnClickListener(this);
        scan.setOnClickListener(this);
        etSearch.setOnClickListener(this);

    }


    /**
     * 从服务器获得数据
     */
    private void getDataFromSever() {

        CommonOkHttpClient.sendRequest(CommonRequest.createGetRequest(ModelConstant.URL_MAINPAGE, null), new CommonJsonCallback(new DisposeDataHandle(EntityMainPage.class, new DisposeDataListener() {

            @Override
            public void onSuccess(Object responseObj) {
                handleRecyclerViewInfo((EntityMainPage) responseObj);
            }

            @Override
            public void onFailure(Object reasonObj) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();

            }
        })));


    }

    /**
     * recyclerView 的界面处理
     * 采用 vlayout 搭建
     */
    private void handleRecyclerViewInfo(EntityMainPage entityMainPage) {
        entity = entityMainPage;
        // 1 设置布局管理器
        VirtualLayoutManager manager = new VirtualLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        // 设置缓存（非必须）
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        //2 设置adapter
        adapter = new DelegateAdapter(manager, true);
        recyclerView.setAdapter(adapter);
        // 3 添加不同的种类

        // 首页 banner
        adapter.addAdapter(new MainPageBannerAdapter(context, new LinearLayoutHelper(), entityMainPage));
        // 首页 ClassifyGridItem（10个item）
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5, 10);//每行的显示数目
        gridLayoutHelper.setVGap(30);
        gridLayoutHelper.setMarginTop(20);
        gridLayoutHelper.setMarginBottom(20);
        adapter.addAdapter(new MainPageClassifyGridItemAdapter(context, gridLayoutHelper, entityMainPage));
        // 首页 10个item 下的单张图片
        adapter.addAdapter(new MainPageSingleImageAdapter(context, new LinearLayoutHelper(), entityMainPage));
        // 首页 单张图片下的四个大图（个数由服务器配置）
        adapter.addAdapter(new MainPageMoreImageAdapter(context, new GridLayoutHelper(2), entityMainPage));
        //首页 热搜
        adapter.addAdapter(new MainPageHotSortAdapter(context, new LinearLayoutHelper(), entityMainPage));

    }

    private void recommentData(DelegateAdapter adapter, EntityMainPage entityMainPage) {
        //  首页 推荐
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setDividerHeight(50);
        linearLayoutHelper.setMarginBottom(10);
        adapter.addAdapter(new MainPageRecommentAdapter(context, linearLayoutHelper, entityMainPage));
    }

    /**
     * 初始化下拉刷新布局
     */
    private void initRefreshLayout() {
        // 刷新进度条颜色
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        // 刷新进度条位置设置
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
        // 下拉刷新事件监听
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

    }

    /**
     * 下拉刷新数据模拟
     */
    private void refreshData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showToast(context, "没有更多数据了", ToastUtils.LENGTH_LONG);
                        mRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


    /**
     * 各种点击事件处理
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recomment:
                ToastUtils.showToast(context, "推荐成功，请继续往下浏览", ToastUtils.LENGTH_LONG);
                recommentData(adapter, entity);
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_msg:
                context.startActivity(new Intent(context, MsgActivity.class));
                break;
            case R.id.tv_scan:
                scan_code();
                break;
            case R.id.et_search:
                context.startActivity(new Intent(context, SearchActivity.class));
                break;
        }
    }

    /**
     * 扫码
     * <p>
     * 结果见activity回调
     */
    private void scan_code() {
        IntentIntegrator integrator = new IntentIntegrator(context);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Model Scanner");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

    }

}
