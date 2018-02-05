package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.mvp.model.JokesBean;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\29.
 * 创建新闻列表的适配器
 */

public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.ViewHolder> {

    private Context mContext;
    private List<JokesBean.DataBeanX.DataBean> mList;

    public JokesListAdapter(Context context, List<JokesBean.DataBeanX.DataBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_jokes_list_layout, parent, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mContent.setText(mList.get(position).getGroup().getContent());
        holder.ivLogo.loadCircleImage(mList.get(position).getGroup().getUser().getAvatar_url(), R.color.placeholder_color);
        holder.tvFrom.setText(mList.get(position).getGroup().getUser().getName());
        holder.tvPlayTime.setText(mList.get(position).getGroup().getCategory_name());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //文本模式的ViewHolder
    @SuppressWarnings("WeakerAccess")
    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.mContent)
        TextView mContent;
        @Bind(R.id.iv_logo)
        GlideImageView ivLogo;
        @Bind(R.id.tv_from)
        TextView tvFrom;
        @Bind(R.id.tv_play_time)
        TextView tvPlayTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
