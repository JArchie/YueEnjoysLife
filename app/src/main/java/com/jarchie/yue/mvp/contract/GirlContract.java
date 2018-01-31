package com.jarchie.yue.mvp.contract;

import android.content.Context;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;
import com.jarchie.yue.mvp.model.GirlBean;

/**
 * Created by Jarchie on 2018\1\25.
 * 妹纸模块契约类
 */

public interface GirlContract {

    interface View extends BaseView { //将数据返回到View
        void setData(GirlBean girlBean);
    }

    interface presenter extends BasePresenter{ //获取数据
        void requestGirlData(Context mContext,int pageSize, int pageNum);
    }

}
