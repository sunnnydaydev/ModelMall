package com.example.administrator.modelmall.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.entity.EntityMainPage;
import com.example.administrator.modelmall.ui.activities.GoodsInfoActivity;


/**
 * Create by SunnyDay on 2019/03/19
 * <p>
 * 首页的10个item下的一个图片展示
 */
public class MainPageRecommentAdapter extends DelegateAdapter.Adapter<MainPageRecommentAdapter.MainViewHolder> implements View.OnClickListener {
    private Context context;
    private LayoutHelper layoutHelper;
    private EntityMainPage entityMainPage;

    public MainPageRecommentAdapter(Context context, LayoutHelper layoutHelper, EntityMainPage entityMainPage) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.page_recomment, parent, false);
        return new MainViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Glide.with(context)
                .load(entityMainPage.getRecommends_goods().get(position).getImageUrl())
                .placeholder(R.drawable.img_small)
                .into(holder.img);
        holder.tvDesc.setText(entityMainPage.getRecommends_goods().get(position).getDesc());
        holder.tvSinglePrice.setText("￥" + entityMainPage.getRecommends_goods().get(position).getSinglePrice());
        holder.tvTotalPrice.setText("￥" + entityMainPage.getRecommends_goods().get(position).getTotalPrice());
        holder.tvGood.setText(" 好评率：" + entityMainPage.getRecommends_goods().get(position).getRate() + "%");

        holder.cardView.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {

        return entityMainPage == null ? 0 : entityMainPage.getRecommends_goods().size();//容错处理
    }


    /**
     * holder
     */
    static class MainViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView img;
        TextView tvDesc;
        TextView tvSinglePrice;
        TextView tvTotalPrice;
        TextView tvGood;
        private CardView cardView;


        public MainViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvSinglePrice = itemView.findViewById(R.id.tv_single_price);
            tvTotalPrice = itemView.findViewById(R.id.tv_total_price);
            tvGood = itemView.findViewById(R.id.tv_good);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cardview:
                context.startActivity(new Intent(context,GoodsInfoActivity.class));
                break;
        }
    }
}
