package com.jarchie.yue.mvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.jarchie.common.base.impl.BasePresenterImpl;
import com.jarchie.yue.R;
import com.jarchie.yue.api.Api;
import com.jarchie.yue.constant.HostType;
import com.jarchie.yue.mvp.contract.JokesContract;
import com.jarchie.yue.mvp.model.JokesBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2018\2\2.
 * 段子模块的处理类
 */

public class JokesPresenter extends BasePresenterImpl<JokesContract.View> implements JokesContract.presenter {

    public JokesPresenter(JokesContract.View view) {
        super(view);
    }

    @Override
    public void requestJokesListData(Context mContext, String contentType, int count) {
        view.showLoading(mContext.getString(R.string.loading));
        Api.getDefault(HostType.NEIHAN_VIDEO).requestJokesListData(contentType,count).enqueue(new Callback<JokesBean>() {
            @Override
            public void onResponse(@NonNull Call<JokesBean> call, @NonNull Response<JokesBean> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        view.setData(response.body());
                        view.stopLoading();
                    }else {
                        view.stopLoading();
                        view.showErrorTip("当前暂无数据，请稍后再试");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<JokesBean> call, @NonNull Throwable t) {
                view.stopLoading();
                view.showErrorTip(t.getMessage());
            }
        });
    }
}
