package com.jarchie.yue.mvp.contract;

import android.content.Context;

import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;
import com.jarchie.yue.mvp.model.VideoBean;

import java.util.List;

/**
 * Created by Jarchie on 2018\1\31.
 * 视频列表契约类
 */

public interface VideoContract {

    interface View extends BaseView { //将数据返回到View
        void setData(VideoBean list);
    }

    interface presenter extends BasePresenter { //取数据
        void requestNewsListData(Context mContext, String type, int count);
    }
}
