package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.mvp.model.JokesBean;
import com.jarchie.yue.ui.animator.ExpandableViewHoldersUtil;
import com.jarchie.yue.ui.animator.ExpandableViewHoldersUtil.KeepOneHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jarchie on 2018\1\29.
 * 段子模块列表的适配器
 */

public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.ViewHolder> {
    private KeepOneHolder<ViewHolder> keepOne = new KeepOneHolder<>();
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

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bind(position, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //文本模式的ViewHolder
    @SuppressWarnings("WeakerAccess")
    class ViewHolder extends RecyclerView.ViewHolder implements ExpandableViewHoldersUtil.Expandable {
        @Bind(R.id.mContent)
        TextView mContent;
        @Bind(R.id.iv_logo)
        GlideImageView ivLogo;
        @Bind(R.id.tv_from)
        TextView tvFrom;
        @Bind(R.id.tv_play_time)
        TextView tvPlayTime;
        @Bind(R.id.rotate_view)
        ImageView rotateView;
        @Bind(R.id.img_layout)
        LinearLayout imgLayout;
        @Bind(R.id.comment_logo)
        GlideImageView commentLogo;
        @Bind(R.id.comment_content)
        TextView commentContent;
        @Bind(R.id.comment_uname)
        TextView commentUname;
        @Bind(R.id.under_layout)
        LinearLayout underLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(int pos, JokesBean.DataBeanX.DataBean dataBean) {
            mContent.setText(dataBean.getGroup().getContent());
            ivLogo.loadCircleImage(dataBean.getGroup().getUser().getAvatar_url(), R.color.placeholder_color);
            tvFrom.setText(dataBean.getGroup().getUser().getName());
            tvPlayTime.setText(dataBean.getGroup().getCategory_name());
            if (dataBean.getComments().size() > 0) {
                commentUname.setVisibility(View.VISIBLE);
                commentContent.setText("评论：" + dataBean.getComments().get(0).getText());
                commentUname.setText("用户：" + dataBean.getComments().get(0).getUser_name());
                commentLogo.loadCircleImage(dataBean.getComments().get(0).getAvatar_url(), R.color.placeholder_color);
            } else {
                commentUname.setVisibility(View.GONE);
                commentContent.setText("当前暂无用户评论");
                commentLogo.loadLocalCircleImage(R.drawable.nhtv, R.color.placeholder_color);
            }
            keepOne.bind(this, pos);
        }

        @OnClick(R.id.img_layout)
        public void onClick() {
            keepOne.toggle(this, rotateView);
        }

        @Override
        public View getExpandView() {
            return underLayout;
        }
    }

}
