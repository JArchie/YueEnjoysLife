package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.bean.GirlBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\26.
 * 妹子模块的适配器
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {

    private Context mContext;
    private List<GirlBean.ResultsBean> mList;

    public GirlAdapter(Context context, List<GirlBean.ResultsBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_girl_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mGirlImage.loadImage(mList.get(position).getUrl(), R.color.placeholder_color);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.girl_image)
        GlideImageView mGirlImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
