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
 * 归属地查询
 */
public class BelongActivity extends BaseActivity {
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_belong;
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
        mToolbar.setTitle("归属地查询");
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
