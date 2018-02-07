package com.jarchie.yue.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.common.widget.RefreshInitView;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.contract.JokesContract;
import com.jarchie.yue.mvp.model.JokesBean;
import com.jarchie.yue.mvp.presenter.JokesPresenter;
import com.jarchie.yue.ui.adapter.JokesListAdapter;
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
 * Created by Jarchie on 2018\1\24.
 * 段子模块的Fragment
 */

public class JokesFragment extends BaseFragment<JokesContract.presenter> implements JokesContract.View, OnRefreshListener, OnLoadmoreListener {

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

    private List<JokesBean.DataBeanX.DataBean> mList = new ArrayList<>();
    private JokesListAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_list_layout;
    }

    @Override
    public JokesContract.presenter initPresenter() {
        return new JokesPresenter(this);
    }

    @Override
    public void initListener() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        RefreshInitView.initView(mRefreshLayout);
    }

    @Override
    public void initData() {
        RefreshInitView.initDataView(mRefreshLayout, getActivity());
        mNewsRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsRecycle.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new JokesListAdapter(getContext(), mList);
        mNewsRecycle.setAdapter(mAdapter);
        if (mPresenter != null)
            mPresenter.requestJokesListData(getContext(), Constant.VIDEO_JOKES, Constant.PAGE_COUNT);
    }

    @Override
    public void setData(JokesBean bean) {
        mList.addAll(bean.getData().getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) { //刷新数据
        mList.clear();
        if (mPresenter == null){
            mPresenter = new JokesPresenter(this);
        }
        mPresenter.requestJokesListData(getContext(), Constant.VIDEO_JOKES, Constant.PAGE_COUNT);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) { //加载数据
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

}
