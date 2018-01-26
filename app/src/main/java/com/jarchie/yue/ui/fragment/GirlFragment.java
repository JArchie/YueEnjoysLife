package com.jarchie.yue.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.common.widget.RefreshInitView;
import com.jarchie.yue.R;
import com.jarchie.yue.bean.GirlBean;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.contract.GirlContract;
import com.jarchie.yue.mvp.model.GirlModel;
import com.jarchie.yue.mvp.presenter.GirlPresenter;
import com.jarchie.yue.ui.adapter.GirlAdapter;
import com.jarchie.yue.ui.widget.CommonDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\24.
 * 妹子Fragment
 */

public class GirlFragment extends BaseFragment<GirlPresenter, GirlModel> implements GirlContract.View, OnRefreshListener, OnLoadmoreListener {

    @Bind(R.id.topbar_back)
    ImageView mTopbarBack;
    @Bind(R.id.topbar_title)
    TextView mTopbarTitle;
    @Bind(R.id.loadedTip)
    LoadingTip mLoadedTip;
    @Bind(R.id.girl_recycle)
    RecyclerView mGirlRecycle;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
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
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        RefreshInitView.initView(mRefreshLayout);
        mPresenter.getGirlData(Constant.PAGE_SIZE, 1);
    }

    @Override
    public void initListener() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    public void initData() { //初始化数据
        mTopbarBack.setVisibility(View.GONE);
        mTopbarTitle.setText("漂亮妹纸");
        RefreshInitView.initDataView(mRefreshLayout, getActivity());
        mGirlRecycle.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mGirlRecycle.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new GirlAdapter(getContext(), mList);
        mGirlRecycle.setAdapter(mAdapter);
        mCommonDialog = new CommonDialog(getContext(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,R.layout.dialog_girl, Gravity.CENTER);
        mPhotoView = mCommonDialog.findViewById(R.id.dialog_photo);
    }

    @Override
    public void returnGirlData(GirlBean girlBean) { //数据返回到View层
        mList.addAll(girlBean.getResults());
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
        mPresenter.getGirlData(Constant.PAGE_SIZE, Constant.PAGE_NUM);
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) { //加载数据
        mPresenter.getGirlData(Constant.PAGE_SIZE, ++pageNum);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showLoading(String title) {
        mRefreshLayout.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
    }

    @Override
    public void stopLoading() {
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        mRefreshLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorTip(String msg) {
        mRefreshLayout.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
    }

}
