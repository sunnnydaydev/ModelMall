package com.example.administrator.modelmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.ui.customview.ToastUtils;

import java.util.List;

/**
 * Create by SunnyDay on 2019/03/25
 * <p>
 * 发现页面的adapter
 */
public class FindAdapter extends RecyclerView.Adapter<FindAdapter.MyHolder> {


    private Context context;

    public FindAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findpage,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
      holder.card.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              ToastUtils.showToast(context,"后台小哥哥正在努力加班中",ToastUtils.LENGTH_SHORT);
          }
      });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private  CardView card;

        public MyHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardview);
        }
    }
}
