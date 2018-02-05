package com.jarchie.yue.ui.fragment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.utils.BackHandlerHelper;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.common.widget.RefreshInitView;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.model.VideoBean;
import com.jarchie.yue.ui.adapter.VideoBaseAdapter;
import com.jarchie.yue.ui.adapter.VideoListAdapter;
import com.jarchie.yue.ui.videohelper.VideoNormalHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\31.
 * 视频列表Fragment
 */

@SuppressWarnings({"RedundantIfStatement", "SimplifiableIfStatement"})
public class VideoListFragment extends BaseFragment implements OnRefreshListener, OnLoadmoreListener {

    @Bind(R.id.mHeader)
    ClassicsHeader mHeader;
    @Bind(R.id.mLoadedTip)
    LoadingTip mLoadedTip;
    @Bind(R.id.mNewsRecycle)
    RecyclerView mNewsRecycle;
    @Bind(R.id.mFooter)
    ClassicsFooter mFooter;
    @Bind(R.id.mRefreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private String videoType;
    private List<VideoBean> mList = new ArrayList<>();
    private VideoListAdapter mAdapter;
    private boolean mFull = false;
    private LinearLayoutManager linearLayoutManager;
    VideoBaseAdapter recyclerBaseAdapter;
    private boolean flag = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置一个exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getActivity().getWindow().setEnterTransition(new Explode());
            getActivity().getWindow().setExitTransition(new Explode());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_list_layout;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        RefreshInitView.initView(mRefreshLayout);
    }

    @Override
    public void initData() {
        if (getArguments() != null) {
            videoType = getArguments().getString(Constant.VIDEO_TYPE);
        }
        RefreshInitView.initDataView(mRefreshLayout, getActivity());

        resolveData(0,10);

        linearLayoutManager = new LinearLayoutManager(getContext());
        mNewsRecycle.setLayoutManager(linearLayoutManager);
        mNewsRecycle.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new VideoListAdapter(getContext(), mList, videoType);
        mNewsRecycle.setAdapter(mAdapter);

        mNewsRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int firstVisibleItem, lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(VideoNormalHolder.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        //是否全屏
                        if (!mFull) {
                            GSYVideoPlayer.releaseAllVideos();
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        flag = true;
        mList.clear();
        resolveData(0,10);
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        resolveData(10,20);
        flag = false;
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            mFull = false;
        } else {
            mFull = true;
        }
    }

    @Override
    public boolean onBackPressed() {
        SmartToast.showInCenter("监听到了");
        if (StandardGSYVideoPlayer.backFromWindowFull(getContext())) {
            return true;
        } else {
            return BackHandlerHelper.handleBackPress(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }

    @Override
    public void showLoading(String title) {
        mNewsRecycle.setVisibility(View.GONE);
        mHeader.setVisibility(View.GONE);
        mFooter.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
    }

    @Override
    public void stopLoading() {
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        mNewsRecycle.setVisibility(View.VISIBLE);
        mHeader.setVisibility(View.VISIBLE);
        mFooter.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorTip(String msg) {
        mNewsRecycle.setVisibility(View.GONE);
        mHeader.setVisibility(View.GONE);
        mFooter.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
    }

    private void resolveData(int start,int size) {
        if (flag){
            for (int i = start; i < size; i++) {
                VideoBean videoBean = new VideoBean();
                mList.add(videoBean);
            }
            if (recyclerBaseAdapter != null)
                recyclerBaseAdapter.notifyDataSetChanged();
        }
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
