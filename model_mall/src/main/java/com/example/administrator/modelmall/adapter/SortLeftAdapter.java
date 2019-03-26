package com.example.administrator.modelmall.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.ui.customview.ToastUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Create by SunnyDay on 2019/03/26
 */
public class SortLeftAdapter extends RecyclerView.Adapter<SortLeftAdapter.MyViewHolder> {
    private Context context;

    public SortLeftAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sortpage_left, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.tvSort.setText("商品类别" + position);
        holder.rlLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ToastUtils.showToast(context,"点击"+position,ToastUtils.LENGTH_LONG);
                //  发送通知更新消息
                EventBus.getDefault().post("update");
            }
        });

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvSort;
        RelativeLayout rlLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvSort = itemView.findViewById(R.id.tv_sort);
            rlLayout = itemView.findViewById(R.id.rl_layout);
        }
    }
}
