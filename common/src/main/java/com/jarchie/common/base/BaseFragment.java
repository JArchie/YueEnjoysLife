package com.jarchie.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jarchie.common.R;
import com.jarchie.common.utils.ToastUtil;
import com.jarchie.common.widget.LoadingDialog;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\24.
 * 封装Fragment的基类
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{

    protected View mRootView;
    public P mPresenter;
    public Context mContext;
    private boolean isViewCreated; //控件是否初始化完成
    private boolean isLoadDataCompleted; //数据是否已经加载完成

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            isLoadDataCompleted = true;
            initData();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null)
            mRootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, mRootView);
        isViewCreated = true;
        initListener();
        return mRootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted) {
            isLoadDataCompleted = true;
            initData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            setUserVisibleHint(true);
        }
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
        }
        super.onDestroyView();
    }

    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract P initPresenter();

    //初始化view
    public abstract void initListener();

    //初始化数据
    public abstract void initData();

    //开启浮动加载进度条
    public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    //开启浮动加载进度条
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(getActivity(), msg, true);
    }

    //停止浮动加载进度条
    public void stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading();
    }

    //网络访问错误提醒
    public void showNetErrorTip() {
        ToastUtil.showToastWithImg(getText(R.string.net_error).toString(), R.drawable.ic_wifi_off);
    }

    public void showNetErrorTip(String error) {
        ToastUtil.showToastWithImg(error, R.drawable.ic_wifi_off);
    }
}
