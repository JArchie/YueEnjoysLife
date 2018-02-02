package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jarchie.yue.R;
import com.jarchie.yue.mvp.model.VideoBean;
import com.jarchie.yue.ui.videohelper.SmallVideoHelper;
import com.jarchie.yue.ui.videohelper.VideoItemHolder;
import com.jarchie.yue.ui.videohelper.VideoNormalHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\2\1.
 * 视频列表的基础适配器
 */

public class VideoBaseAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<VideoBean.DataBeanX.DataBean> mList;
    private SmallVideoHelper smallVideoHelper;

    private SmallVideoHelper.GSYSmallVideoHelperBuilder gsySmallVideoHelperBuilder;

    public VideoBaseAdapter(Context context, List<VideoBean.DataBeanX.DataBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_video_item, parent, false);
        return new VideoItemHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoItemHolder mHolder = (VideoItemHolder) holder;
        mHolder.setVideoHelper(smallVideoHelper, gsySmallVideoHelperBuilder);
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

    public void setVideoHelper(SmallVideoHelper smallVideoHelper, SmallVideoHelper.GSYSmallVideoHelperBuilder gsySmallVideoHelperBuilder) {
        this.smallVideoHelper = smallVideoHelper;
        this.gsySmallVideoHelperBuilder = gsySmallVideoHelperBuilder;
    }
}
