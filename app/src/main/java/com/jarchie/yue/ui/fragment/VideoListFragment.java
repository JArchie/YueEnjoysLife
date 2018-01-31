package com.jarchie.yue.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.contract.VideoContract;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\31.
 * 视频列表Fragment
 */

public class VideoListFragment extends BaseFragment<VideoContract.presenter> implements VideoContract.View {

    @Bind(R.id.mHeader)
    ClassicsHeader mHeader;
    @Bind(R.id.mLoadedTip)
    LoadingTip mLoadedTip;
    @Bind(R.id.mNewsRecycle)
    RecyclerView mNewsRecycle;
    @Bind(R.id.mFooter)
    ClassicsFooter mFooter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_list_layout;
    }

    @Override
    public VideoContract.presenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    //新建Fragment的实例,供外部调用
    public static VideoListFragment newInstance(String type) {
        VideoListFragment fragment = new VideoListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.VIDEO_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

}
