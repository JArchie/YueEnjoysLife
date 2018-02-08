package com.jarchie.yue.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jarchie.yue.R;

import java.util.List;

/**
 * Created by Jarchie on 2018\2\8.
 * 自定义下拉列表控件
 */

public class SpinnerPopWindow<T> extends PopupWindow {
    private LayoutInflater mInflater;
    private List<T> mList;

    public SpinnerPopWindow(Context context, List<T> list, AdapterView.OnItemClickListener clickListener) {
        super(context);
        mInflater = LayoutInflater.from(context);
        this.mList = list;
        init(clickListener);
    }

    //初始化View
    private void init(AdapterView.OnItemClickListener clickListener) {
        View view = mInflater.inflate(R.layout.spinner_window_layout, null);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        ListView mListView = view.findViewById(R.id.spinner_listview);
        mListView.setAdapter(new MyAdapter());
        mListView.setOnItemClickListener(clickListener);
    }

    @SuppressWarnings("unchecked")
    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.spinner_item_layout, null);
                holder.tvName = convertView.findViewById(R.id.tv_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvName.setText(getItem(position).toString());
            return convertView;
        }
    }

    private class ViewHolder {
        private TextView tvName;
    }
}
