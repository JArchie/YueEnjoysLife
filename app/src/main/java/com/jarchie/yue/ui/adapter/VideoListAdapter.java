package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jarchie.yue.R;
import com.jarchie.yue.mvp.model.VideoBean;
import com.jarchie.yue.ui.videohelper.VideoNormalHolder;
import java.util.List;

/**
 * Created by Jarchie on 2018\2\1.
 * 视频列表的适配器
 */

public class VideoListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<VideoBean.DataBeanX.DataBean> mList;

    public VideoListAdapter(Context context, List<VideoBean.DataBeanX.DataBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_list_layout, parent, false);
        return new VideoNormalHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoNormalHolder mHolder = (VideoNormalHolder) holder;
        mHolder.setRecyclerBaseAdapter(this);
        mHolder.onBind(position, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }
}
