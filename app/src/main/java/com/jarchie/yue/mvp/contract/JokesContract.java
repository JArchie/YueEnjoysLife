package com.jarchie.yue.mvp.contract;

import android.content.Context;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;
import com.jarchie.yue.mvp.model.JokesBean;

/**
 * Created by Jarchie on 2018\2\2.
 * 段子Fragment的契约类
 */

public interface JokesContract {

    interface View extends BaseView { //将数据返回到View
        void setData(JokesBean bean);
    }

    interface presenter extends BasePresenter { //取数据
        void requestJokesListData(Context mContext, String contentType, int count);
    }

}
