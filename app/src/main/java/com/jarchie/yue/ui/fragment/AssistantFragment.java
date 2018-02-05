package com.jarchie.yue.ui.fragment;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;
import com.jarchie.yue.ui.widget.CustomToolBar;
import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\24.
 * 我的Fragment
 */

public class AssistantFragment extends BaseFragment {

    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_assistant_layout;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mToolbar.setTitle("助手");
        mToolbar.hideBack();
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
