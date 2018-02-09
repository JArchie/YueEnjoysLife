package com.jarchie.yue.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.base.BaseActivity;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.widget.CustomToolBar;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Jarchie on 2018\2\7.
 * 关于软件模块
 */
public class AboutActivity extends BaseActivity {
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    @Bind(R.id.mBlogTv)
    TextView mBlogTv;
    @Bind(R.id.mGithubTv)
    TextView mGithubTv;

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
        mToolbar.setLeftBtnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutActivity.this.finish();
            }
        });
    }

    @Override
    public void initData() {
        mToolbar.setTitle("关于软件");
    }

    @OnClick({R.id.mBlogTv, R.id.mGithubTv})
    public void onClick(TextView view) {
        switch (view.getId()) {
            case R.id.mBlogTv:
                switchBrowser(Constant.BLOG_FLAG);
                break;
            case R.id.mGithubTv:
                switchBrowser(Constant.GITHUB_FLAG);
                break;
        }
    }

    //调起系统自带浏览器
    private void switchBrowser(String flag) {
        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        if (flag.equals(Constant.BLOG_FLAG)) {
            intent.setData(Uri.parse(Constant.BLOG_URL));
        } else if (flag.equals(Constant.GITHUB_FLAG)) {
            intent.setData(Uri.parse(Constant.GITHUB_URL));
        }
        // 注意此处的判断intent.resolveActivity()可以返回显示该Intent的Activity对应的组件名
        // 官方解释 : Name of the component implementing an activity that can display the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "请选择浏览器"));
        } else {
            SmartToast.showInCenter("对不起，没有相匹配的应用");
        }
    }

    @Override
    public void showLoading(String title) {}
    @Override
    public void stopLoading() {}
    @Override
    public void showErrorTip(String msg) {}

}
