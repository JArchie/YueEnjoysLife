package com.jarchie.yue.ui.videohelper;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jarchie on 2018\2\1.
 * 视频播放器的基础Holder类
 */

public class RecyclerItemBaseHolder extends RecyclerView.ViewHolder {
    RecyclerView.Adapter recyclerBaseAdapter;

    public RecyclerItemBaseHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView.Adapter getRecyclerBaseAdapter() {
        return recyclerBaseAdapter;
    }

    public void setRecyclerBaseAdapter(RecyclerView.Adapter recyclerBaseAdapter) {
        this.recyclerBaseAdapter = recyclerBaseAdapter;
    }
}
