package com.jarchie.yue.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.common.widget.RefreshInitView;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.contract.NewsListContract;
import com.jarchie.yue.mvp.model.NewsBean;
import com.jarchie.yue.mvp.presenter.NewsListPresenter;
import com.jarchie.yue.ui.adapter.NewsListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\31.
 * 新闻列表页
 */

public class NewsListFragment extends BaseFragment<NewsListContract.presenter> implements NewsListContract.View, OnRefreshListener, OnLoadmoreListener {

    @Bind(R.id.mNewsRecycle)
    RecyclerView mNewsRecycle;
    @Bind(R.id.mRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.mLoadedTip)
    LoadingTip mLoadedTip;
    @Bind(R.id.mHeader)
    ClassicsHeader mHeader;
    @Bind(R.id.mFooter)
    ClassicsFooter mFooter;

    private String channel;
    private List<NewsBean.ResultBean.ListBean> mList = new ArrayList<>();
    private NewsListAdapter mAdapter;
    private int pageNum = 0;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_list_layout;
    }

    @Override
    public NewsListContract.presenter initPresenter() {
        return new NewsListPresenter(this);
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
            channel = getArguments().getString(Constant.CHANNEL);
        }
        RefreshInitView.initDataView(mRefreshLayout, getActivity());
        mNewsRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsRecycle.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new NewsListAdapter(getContext(), mList);
        mNewsRecycle.setAdapter(mAdapter);
        mPresenter.requestNewsListData(getContext(), channel, Constant.PAGE_START, Constant.PAGE_SIZE, Constant.NEWS_KEY);
    }

    @Override
    public void setData(NewsBean bean) {
        mList.addAll(bean.getResult().getList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mList.clear();
        mPresenter.requestNewsListData(getContext(), channel, Constant.PAGE_START, Constant.PAGE_SIZE, Constant.NEWS_KEY);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.requestNewsListData(getContext(), channel, ++pageNum, Constant.PAGE_SIZE, Constant.NEWS_KEY);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
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

    //新建Fragment的实例,供外部调用
    public static NewsListFragment newInstance(String channel) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.CHANNEL, channel);
        fragment.setArguments(bundle);
        return fragment;
    }

}
