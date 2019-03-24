package com.example.administrator.modelmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.events.GoodInfoMsg;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Create by SunnyDay on 2019/03/21
 * <p>
 * 购物车界面的adapter
 */
public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.MyHolder> {
    private Context context;
    public List<Integer> mList;
    public boolean isChecked;


    public ShopCartAdapter(Context context, List<Integer> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        isChecked = holder.cb_select.isChecked();
    }

    @Override
    public int getItemCount() {

        return mList.size() == 0 ? 1 : mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public CheckBox cb_select;

        public MyHolder(View itemView) {
            super(itemView);
            cb_select = itemView.findViewById(R.id.cb_select);
        }
    }
}
