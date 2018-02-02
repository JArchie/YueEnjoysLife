package com.jarchie.yue.mvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jarchie.common.base.impl.BasePresenterImpl;
import com.jarchie.yue.R;
import com.jarchie.yue.api.Api;
import com.jarchie.yue.constant.HostType;
import com.jarchie.yue.mvp.contract.VideoContract;
import com.jarchie.yue.mvp.model.VideoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2018\1\31.
 * 视频列表的处理类
 */

public class VideoListPresenter extends BasePresenterImpl<VideoContract.View> implements VideoContract.presenter {

    public VideoListPresenter(VideoContract.View view) {
        super(view);
    }

    @Override
    public void requestNewsListData(Context mContext, String type, int count) {
        view.showLoading(mContext.getString(R.string.loading));
        Api.getDefault(HostType.NEIHAN_VIDEO).requestVideoListData(type, count).enqueue(new Callback<VideoBean>() {
            @Override
            public void onResponse(@NonNull Call<VideoBean> call, @NonNull Response<VideoBean> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        view.setData(response.body());
                        view.stopLoading();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<VideoBean> call, @NonNull Throwable t) {
                view.stopLoading();
                Log.e("错误是啥---", t.getMessage());
                view.showErrorTip(t.getMessage());
            }
        });
    }
}
