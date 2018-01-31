package com.jarchie.yue.mvp.contract;

import android.content.Context;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;
import com.jarchie.yue.mvp.model.NewsBean;

/**
 * Created by Jarchie on 2018\1\29.
 * 新闻列表的契约类
 */

public interface NewsListContract {

    interface View extends BaseView{ //将数据返回到View
        void setData(NewsBean bean);
    }

    interface presenter extends BasePresenter{ //取数据
        void requestNewsListData(Context mContext,String channel, int pageNum, int pageSize,String appkey);
    }

}
