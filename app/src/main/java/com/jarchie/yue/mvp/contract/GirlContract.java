package com.jarchie.yue.mvp.contract;

import com.jarchie.common.base.BaseModel;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;
import com.jarchie.yue.bean.GirlBean;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Jarchie on 2018\1\25.
 * 妹纸模块契约类
 */

public interface GirlContract {

    interface Model extends BaseModel { //请求数据
        Call<GirlBean> requestGirlData(int pageSize, int pageNum);
    }

    interface View extends BaseView { //将数据返回到View
        void returnGirlData(GirlBean girlBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> { //绑定View和Model
        public abstract void getGirlData(int pageSize, int pageNum);
    }

}
