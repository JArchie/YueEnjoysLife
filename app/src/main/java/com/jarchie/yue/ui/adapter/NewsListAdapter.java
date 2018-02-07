package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.mvp.model.NewsBean;
import com.jarchie.yue.ui.activity.NewsDetailActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\29.
 * 创建新闻列表的适配器
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context mContext;
    private List<NewsBean.ResultBean.ListBean> mList;

    public NewsListAdapter(Context context, List<NewsBean.ResultBean.ListBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_news_list_layout, parent, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvTextTitle.setText(mList.get(position).getTitle() == null ? "暂无数据" : mList.get(position).getTitle()); //标题
        holder.tvTextTime.setText(mList.get(position).getTime()); //时间
        holder.tvTextContent.setText(Html.fromHtml(mList.get(position).getContent())); //内容
        holder.tvTextSrc.setText(TextUtils.isEmpty(mList.get(position).getSrc()) ? "暂无来源" : mList.get(position).getSrc()); //来源
        holder.ivTextPhoto.loadImage(mList.get(position).getPic(), R.color.placeholder_color);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NewsDetailActivity.class);
                intent.putExtra("url", mList.get(position).getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //文本模式的ViewHolder
    @SuppressWarnings("WeakerAccess")
    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_text_photo)
        GlideImageView ivTextPhoto;
        @Bind(R.id.tv_text_title)
        TextView tvTextTitle;
        @Bind(R.id.tv_text_time)
        TextView tvTextTime;
        @Bind(R.id.tv_text_content)
        TextView tvTextContent;
        @Bind(R.id.tv_text_src)
        TextView tvTextSrc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
