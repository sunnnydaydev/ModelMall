package com.example.administrator.modelmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.entity.EntityMainPage;
import com.example.administrator.modelmall.ui.customview.ToastUtils;


/**
 * Create by SunnyDay on 2019/03/19
 * <p>
 * 首页的10个item下的一个图片展示
 */
public class MainPageMoreImageAdapter extends DelegateAdapter.Adapter<MainPageMoreImageAdapter.MainViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private EntityMainPage entityMainPage;

    public MainPageMoreImageAdapter(Context context, LayoutHelper layoutHelper, EntityMainPage entityMainPage) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.image_more, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Glide
                .with(context)
                .load(entityMainPage.getFour_goods_image().get(position).getFour_image_url())
                .placeholder(R.drawable.more)
                .into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast(context,"程序员小哥正在努力加班中",ToastUtils.LENGTH_LONG);
            }
        });


}


    /**
     * 一张图片的显示
     * */
    @Override
    public int getItemCount() {

        return entityMainPage == null ? 0 : entityMainPage.getFour_goods_image().size();//容错处理
    }

    /**
     * holder
     */
    static class MainViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView img;


        public MainViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
