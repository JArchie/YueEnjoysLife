package com.jarchie.yue.mvp.model;

import com.jarchie.common.constant.HostType;
import com.jarchie.yue.api.Api;
import com.jarchie.yue.bean.GirlBean;
import com.jarchie.yue.mvp.contract.GirlContract;

import retrofit2.Call;

/**
 * Created by Jarchie on 2018\1\26.
 * 妹子模块请求数据
 */

public class GirlModel implements GirlContract.Model {

    @Override
    public Call<GirlBean> requestGirlData(int pageSize, int pageNum) {
        return Api.getInstance(HostType.GANK_GIRL_PHOTO).requestGirlData(pageSize, pageNum);
    }

}
