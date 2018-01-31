package com.jarchie.yue.mvp.contract;

import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;

/**
 * Created by Jarchie on 2018\1\31.
 * 视频列表契约类
 */

public interface VideoContract {
    interface View extends BaseView { //将数据返回到View

    }

    interface presenter extends BasePresenter { //取数据

    }
}
