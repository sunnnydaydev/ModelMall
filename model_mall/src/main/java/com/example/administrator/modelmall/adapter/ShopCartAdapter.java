package com.example.administrator.modelmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.modelmall.R;

/**
 * Create by SunnyDay on 2019/03/21
 * <p>
 * 购物车界面的adapter
 */
public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.MyHolder> {
    public Context context;
    public ShopCartAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.goods_item,null,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
