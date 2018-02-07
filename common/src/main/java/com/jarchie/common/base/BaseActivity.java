package com.jarchie.common.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.jarchie.common.R;
import com.jarchie.common.utils.ActivityManager;
import com.jarchie.common.utils.ToastUtil;
import com.jarchie.common.widget.LoadingDialog;
import com.jarchie.common.widget.StatusBarCompat;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\24.
 * 封装Activity的基类
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    public P mPresenter;
    public Context mContext;
    private boolean isConfigChange = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isConfigChange = false;
        ActivityManager.getInstance().addActivity(this);
        setStatusBarColor();
        if (getLayoutId()!=0){
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = initPresenter();
        initListener();
        initData();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
        }
        if (!isConfigChange) {
            ActivityManager.getInstance().finishActivity(this);
        }
        super.onDestroy();
    }

    //着色状态栏（4.4以上系统有效）
    public void setStatusBarColor(){
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this,R.color.color_main));
    }

    //着色状态栏（4.4以上系统有效）
    public void setStatusBarColor(int color){
        StatusBarCompat.setStatusBarColor(this,color);
    }

    //沉浸状态栏（4.4以上系统有效）
    public void setTranslanteBar(){
        StatusBarCompat.translucentStatusBar(this);
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
        LoadingDialog.showDialogForLoading(this);
    }

    //开启浮动加载进度条
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(this, msg, true);
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
