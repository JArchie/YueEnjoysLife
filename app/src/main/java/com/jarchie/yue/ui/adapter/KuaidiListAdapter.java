package com.jarchie.yue.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jarchie.yue.R;
import com.jarchie.yue.bean.CourierBean;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\2\8.
 * 快递查询的适配器
 */

public class KuaidiListAdapter extends RecyclerView.Adapter<KuaidiListAdapter.ViewHolder> {

    private Context mContext;
    private List<CourierBean.ResultBean.ListBean> mList;

    public KuaidiListAdapter(Context context, List<CourierBean.ResultBean.ListBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_kuaidi_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvRemark.setText(mList.get(position).getRemark());
        holder.tvTime.setText(mList.get(position).getDatetime());
        holder.tvZong.setText(mList.get(position).getZone());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_remark)
        TextView tvRemark;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_zong)
        TextView tvZong;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
