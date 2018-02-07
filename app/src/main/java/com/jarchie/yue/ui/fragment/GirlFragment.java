package com.jarchie.yue.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.utils.BackHandlerHelper;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.common.widget.RefreshInitView;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.contract.GirlContract;
import com.jarchie.yue.mvp.model.GirlBean;
import com.jarchie.yue.mvp.presenter.GirlPresenter;
import com.jarchie.yue.ui.adapter.GirlAdapter;
import com.jarchie.yue.ui.widget.CommonDialog;
import com.jarchie.yue.ui.widget.CustomToolBar;
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
 * 妹子Fragment
 */

public class GirlFragment extends BaseFragment<GirlContract.presenter> implements GirlContract.View, OnRefreshListener, OnLoadmoreListener {

    @Bind(R.id.loadedTip)
    LoadingTip mLoadedTip;
    @Bind(R.id.girl_recycle)
    RecyclerView mGirlRecycle;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.mHeader)
    ClassicsHeader mHeader;
    @Bind(R.id.mFooter)
    ClassicsFooter mFooter;
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    private List<GirlBean.ResultsBean> mList = new ArrayList<>();
    private GirlAdapter mAdapter;
    private int pageNum = 1;
    //弹出框
    private CommonDialog mCommonDialog;
    private PhotoView mPhotoView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_girl_layout;
    }

    @Override
    public GirlContract.presenter initPresenter() {
        return new GirlPresenter(this);
    }

    @Override
    public void initListener() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    public void initData() { //初始化数据
        RefreshInitView.initView(mRefreshLayout);
        mToolbar.hideBack();
        mToolbar.setTitle("漂亮妹纸");
        RefreshInitView.initDataView(mRefreshLayout, getActivity());
        mGirlRecycle.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mGirlRecycle.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new GirlAdapter(getContext(), mList);
        mGirlRecycle.setAdapter(mAdapter);
        if (mPresenter != null)
            mPresenter.requestGirlData(getContext(), Constant.PAGE_SIZE, pageNum);
        mCommonDialog = new CommonDialog(getContext(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, R.layout.dialog_girl, Gravity.CENTER);
        mPhotoView = mCommonDialog.findViewById(R.id.dialog_photo);
    }

    @Override
    public void setData(GirlBean girlBean) {
        mList.addAll(girlBean.getResults());
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(new GirlAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mCommonDialog.show();
                Glide.with(getContext()).load(mList.get(position).getUrl()).into(mPhotoView);
            }
        });
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) { //刷新数据
        mList.clear();
        if (mPresenter == null)
            mPresenter = new GirlPresenter(this);
        mPresenter.requestGirlData(getContext(), Constant.PAGE_SIZE, Constant.PAGE_NUM);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) { //加载数据
        if (mPresenter == null)
            mPresenter = new GirlPresenter(this);
        mPresenter.requestGirlData(getContext(), Constant.PAGE_SIZE, ++pageNum);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public boolean onBackPressed() {
        if (mCommonDialog.isShowing()) {
            mCommonDialog.cancel();
            return true;
        } else {
            return BackHandlerHelper.handleBackPress(this);
        }
    }

    @Override
    public void showLoading(String title) {
        mGirlRecycle.setVisibility(View.GONE);
        mHeader.setVisibility(View.GONE);
        mFooter.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
    }

    @Override
    public void stopLoading() {
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        mGirlRecycle.setVisibility(View.VISIBLE);
        mHeader.setVisibility(View.VISIBLE);
        mFooter.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorTip(String msg) {
        mGirlRecycle.setVisibility(View.GONE);
        mHeader.setVisibility(View.GONE);
        mFooter.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
    }
}
