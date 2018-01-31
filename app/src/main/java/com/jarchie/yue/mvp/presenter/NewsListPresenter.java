package com.jarchie.yue.mvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.jarchie.common.base.impl.BasePresenterImpl;
import com.jarchie.yue.R;
import com.jarchie.yue.api.Api;
import com.jarchie.yue.constant.HostType;
import com.jarchie.yue.mvp.contract.NewsListContract;
import com.jarchie.yue.mvp.model.NewsBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2018\1\29.
 * 新闻列表的处理类
 */

public class NewsListPresenter extends BasePresenterImpl<NewsListContract.View> implements NewsListContract.presenter {

    public NewsListPresenter(NewsListContract.View view) {
        super(view);
    }

    @Override
    public void requestNewsListData(Context mContext, String channel, int pageNum, int pageSize, String appkey) {
        view.showLoading(mContext.getString(R.string.loading));
        Api.getDefault(HostType.NEWS_LIST).requestNewsListData(channel,pageNum,pageSize,appkey).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(@NonNull Call<NewsBean> call, @NonNull Response<NewsBean> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        view.setData(response.body());
                        view.stopLoading();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsBean> call, @NonNull Throwable t) {
                view.stopLoading();
                view.showErrorTip(t.getMessage());
            }
        });
    }
}
