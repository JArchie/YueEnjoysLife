package com.jarchie.yue.ui.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jarchie.common.base.BaseActivity;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.common.widget.RefreshInitView;
import com.jarchie.yue.R;
import com.jarchie.yue.ui.widget.CustomToolBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.Bind;

@SuppressWarnings("deprecation")
public class NewsDetailActivity extends BaseActivity implements OnRefreshListener {

    @Bind(R.id.mWebView)
    WebView mWebView;
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    @Bind(R.id.mHeader)
    ClassicsHeader mHeader;
    @Bind(R.id.mLoadedTip)
    LoadingTip mLoadedTip;
    @Bind(R.id.mRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String url;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wechat_detail;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {
        mRefreshLayout.setOnRefreshListener(this);
        RefreshInitView.initView(mRefreshLayout);
        mToolbar.setLeftBtnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsDetailActivity.this.finish();
            }
        });
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        mToolbar.setTitle("新闻详情");
//        mToolbar.showSearch();
//        mToolbar.setRightBtnIcon(getResources().getDrawable(R.drawable.share));
        RefreshInitView.initDataView(mRefreshLayout, this);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.getSettings().setDomStorageEnabled(true);
        //加载网页的处理逻辑
        mWebView.getSettings().setJavaScriptEnabled(true);
        //接口回调
        mWebView.setWebChromeClient(new WebViewClient());
        loadingPage(url);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        loadingPage(url);
        mRefreshLayout.finishRefresh();
    }

    //加载显示
    private void loadingPage(final String mUrl) {
        showLoading("");
        //加载网页
        mWebView.loadUrl(mUrl);
        //本地显示
        mWebView.setWebViewClient(new android.webkit.WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(mUrl);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                showErrorTip("");
            }
        });
    }

    //自定义WebviewClient
    private class WebViewClient extends WebChromeClient {
        //进度变化的监听
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            //处理进度,加载完成时隐藏进度条
            if (newProgress >= 100) {
                stopLoading();
            }
        }
    }

    @Override
    public void onBackPressed() {
        NewsDetailActivity.this.finish();
    }

    @Override
    public void showLoading(String title) {
        mWebView.setVisibility(View.GONE);
        mHeader.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
    }

    @Override
    public void stopLoading() {
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        mWebView.setVisibility(View.VISIBLE);
        mHeader.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorTip(String msg) {
        mWebView.setVisibility(View.GONE);
        mHeader.setVisibility(View.GONE);
        mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
    }

}
