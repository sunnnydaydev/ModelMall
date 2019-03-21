package com.example.administrator.modelmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.entity.EntityMainPage;
import com.example.administrator.modelmall.loader.ModelImageLoader;
import com.example.administrator.modelmall.ui.customview.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Create by SunnyDay on 2019/03/19
 *
 * 首页的banner 展示
 */
public class MainPageBannerAdapter extends DelegateAdapter.Adapter<MainPageBannerAdapter.MainViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private EntityMainPage entityMainPage;
    private List<String> urlList;

    public MainPageBannerAdapter(Context context, LayoutHelper layoutHelper, EntityMainPage entityMainPage) {
        this.context = context;
        this.entityMainPage = entityMainPage;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        initBannerData();
        holder.banner.setImageLoader(new ModelImageLoader())
                .setImages(urlList)
                .start();

        holder.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtils.showToast(context,"程序员小哥正在路上",ToastUtils.LENGTH_LONG);
            }
        });

    }

    /**
     * 服务器获得的banner 广告url拿来 装入集合
     */
    private void initBannerData() {

        urlList = new ArrayList<>();
        for (int i = 0; i < entityMainPage.getBanners().size(); i++) {
            urlList.add(entityMainPage.getBanners().get(i).getBanner_url());
        }

    }

    /**
     * 本类型就一个Banner 不在动态的填充size
     */
    @Override
    public int getItemCount() {

        return entityMainPage == null ? 0 : 1;//容错处理
    }

    /**
     * holder
     */
    static class MainViewHolder extends RecyclerView.ViewHolder {

        public Banner banner;

        public MainViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
}
