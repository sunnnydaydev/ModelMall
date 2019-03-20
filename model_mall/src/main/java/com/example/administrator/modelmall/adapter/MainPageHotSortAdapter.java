package com.example.administrator.modelmall.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
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
import com.orhanobut.logger.Logger;


/**
 * Create by SunnyDay on 2019/03/19
 * <p>
 * 首页的热搜adapter   大图+3小图的界面
 */
public class MainPageHotSortAdapter extends DelegateAdapter.Adapter<MainPageHotSortAdapter.MainViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private EntityMainPage entityMainPage;

    public MainPageHotSortAdapter(Context context, LayoutHelper layoutHelper, EntityMainPage entityMainPage) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_hotsort, parent, false);
        return new MainViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        // 每个条目大图
        Glide
                .with(context)
                .load(entityMainPage.getHotSort().get(position).getHeaderBigImage())
                .placeholder(R.drawable.img_big)
                .into(holder.imgBigHead);

        // 每个条目的 左中右小图
        Glide
                .with(context)
                .load(entityMainPage.getHotSort().get(position).getThreeGoods().get(0).getGoodsItemImage())
                .placeholder(R.drawable.img_small)
                .into(holder.imgSmallLeft);

        Glide
                .with(context)
                .load(entityMainPage.getHotSort().get(position).getThreeGoods().get(1).getGoodsItemImage())
                .placeholder(R.drawable.img_small)
                .into(holder.imgSmallMiddle);
        Glide
                .with(context)
                .load(entityMainPage.getHotSort().get(position).getThreeGoods().get(2).getGoodsItemImage())
                .placeholder(R.drawable.img_small)
                .into(holder.imgSmallRight);


        // 左面描述 、左面单价 、 左面总价
        holder.tvDescLeft.setText(entityMainPage.getHotSort().get(position).getThreeGoods().get(0).getDesc());
        holder.singlePriceLeft.setText("￥" + entityMainPage.getHotSort().get(position).getThreeGoods().get(0).getSingePrice());
        holder.totalPriceLeft.setText("￥" + entityMainPage.getHotSort().get(position).getThreeGoods().get(0).getSingePrice());


        // 中间
        holder.tvDescMiddle.setText(entityMainPage.getHotSort().get(position).getThreeGoods().get(1).getDesc());
        holder.singlePriceMiddle.setText("￥" + entityMainPage.getHotSort().get(position).getThreeGoods().get(1).getSingePrice());
        holder.totalPriceMiddle.setText("￥" + entityMainPage.getHotSort().get(position).getThreeGoods().get(1).getSingePrice());

       // 右面
        holder.tvDescRight.setText(entityMainPage.getHotSort().get(position).getThreeGoods().get(2).getDesc());
        holder.singlePriceRight.setText("￥" + entityMainPage.getHotSort().get(position).getThreeGoods().get(2).getSingePrice());
        holder.totalPriceRight.setText("￥" + entityMainPage.getHotSort().get(position).getThreeGoods().get(2).getSingePrice());

    }


    @Override
    public int getItemCount() {
        return entityMainPage == null ? 0 : entityMainPage.getHotSort().size();//容错处理
    }

    /**
     * holder
     */
    static class MainViewHolder extends RecyclerView.ViewHolder {


        private AppCompatImageView imgBigHead;
        private AppCompatImageView imgSmallLeft;
        private TextView tvDescLeft;
        private TextView singlePriceLeft;
        private TextView totalPriceLeft;
        private AppCompatImageView imgSmallMiddle;
        private TextView tvDescMiddle;
        private TextView singlePriceMiddle;
        private TextView totalPriceMiddle;
        private AppCompatImageView imgSmallRight;
        private TextView tvDescRight;
        private TextView singlePriceRight;
        private TextView totalPriceRight;

        public MainViewHolder(View itemView) {
            super(itemView);
            // 大图
            imgBigHead = itemView.findViewById(R.id.img_big_head);

            // left
            imgSmallLeft = itemView.findViewById(R.id.img_small_left);
            tvDescLeft = itemView.findViewById(R.id.tv_desc_left);
            singlePriceLeft = itemView.findViewById(R.id.single_price_left);
            totalPriceLeft = itemView.findViewById(R.id.total_price_left);

            // middle
            imgSmallMiddle = itemView.findViewById(R.id.img_small_middle);
            tvDescMiddle = itemView.findViewById(R.id.tv_desc_middle);
            singlePriceMiddle = itemView.findViewById(R.id.single_price_middle);
            totalPriceMiddle = itemView.findViewById(R.id.total__price_middle);

            // right
            imgSmallRight = itemView.findViewById(R.id.img_small_right);
            tvDescRight = itemView.findViewById(R.id.tv_desc_right);
            singlePriceRight = itemView.findViewById(R.id.single_price_right);
            totalPriceRight = itemView.findViewById(R.id.total__price_right);


        }
    }
}
