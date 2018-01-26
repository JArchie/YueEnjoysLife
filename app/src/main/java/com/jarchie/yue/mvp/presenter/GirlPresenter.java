package com.jarchie.yue.mvp.presenter;

import android.support.annotation.NonNull;

import com.jarchie.yue.R;
import com.jarchie.yue.bean.GirlBean;
import com.jarchie.yue.mvp.contract.GirlContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2018\1\26.
 * 妹子模块的中间处理类
 */

public class GirlPresenter extends GirlContract.Presenter {

    @Override
    public void getGirlData(int pageSize, int pageNum) {
        mView.showLoading(mContext.getString(R.string.loading));
        mModel.requestGirlData(pageSize, pageNum).enqueue(new Callback<GirlBean>() {
            @Override
            public void onResponse(@NonNull Call<GirlBean> call, @NonNull Response<GirlBean> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mView.returnGirlData(response.body());
                        mView.stopLoading();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GirlBean> call, @NonNull Throwable t) {
                mView.showErrorTip(t.getMessage());
            }
        });
    }

}
