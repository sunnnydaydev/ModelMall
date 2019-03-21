package com.example.administrator.modelmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.entity.EntityMainPage;
import com.example.administrator.modelmall.ui.customview.ToastUtils;


/**
 * Create by SunnyDay on 2019/03/19
 * <p>
 * 首页的banner 展示
 */
public class MainPageClassifyGridItemAdapter extends DelegateAdapter.Adapter<MainPageClassifyGridItemAdapter.MainViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private EntityMainPage entityMainPage;

    public MainPageClassifyGridItemAdapter(Context context, LayoutHelper layoutHelper, EntityMainPage entityMainPage) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_classfiy_grid, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        Glide
                .with(context)
                .load(entityMainPage.getClassifyGridItems().get(position).getGrid_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
        holder.imgDesc.setText(entityMainPage.getClassifyGridItems().get(position).getDesc());
        holder.llLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast(context,"点击了第"+position+"条目",ToastUtils.LENGTH_LONG);
            }
        });

    }


    @Override
    public int getItemCount() {

        return entityMainPage == null ? 0 : entityMainPage.getClassifyGridItems().size();//容错处理
    }

    /**
     * holder
     */
    static class MainViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView img;
        TextView imgDesc;
        LinearLayoutCompat llLayout;


        public MainViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            imgDesc = itemView.findViewById(R.id.img_desc);
            llLayout = itemView.findViewById(R.id.ll_layout);
        }
    }
}
