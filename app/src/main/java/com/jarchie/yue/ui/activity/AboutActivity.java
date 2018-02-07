package com.jarchie.yue.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jarchie.common.base.BaseActivity;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;
import com.jarchie.yue.ui.widget.CustomToolBar;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\2\7.
 * 关于软件模块
 */
public class AboutActivity extends BaseActivity {
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mToolbar.setTitle("关于软件");
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
}
