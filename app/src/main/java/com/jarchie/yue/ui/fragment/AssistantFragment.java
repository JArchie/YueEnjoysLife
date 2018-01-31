package com.jarchie.yue.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\24.
 * 我的Fragment
 */

public class AssistantFragment extends BaseFragment {

    @Bind(R.id.topbar_back)
    ImageView mTopbarBack;
    @Bind(R.id.topbar_title)
    TextView mTopbarTitle;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_assistant_layout;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mTopbarBack.setVisibility(View.GONE);
        mTopbarTitle.setText("助手");
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
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
