package com.jarchie.yue.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.jarchie.common.utils.ActivityManager;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.widget.CustomToolBar;
import com.jarchie.yue.utils.CommonUtils;
import butterknife.Bind;
import butterknife.ButterKnife;

public class WechatDetailActivity extends AppCompatActivity {

    @Bind(R.id.mWebView)
    WebView mWebView;
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_detail);
        ButterKnife.bind(this);
        ActivityManager.getInstance().addActivity(this);
        initListener();
        initData();
    }

    private void initListener() {
        mToolbar.setLeftBtnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.backPreviousPage(WechatDetailActivity.this, Constant.BACK_PREVIOUS_ACTIVITY, KeyEvent.KEYCODE_BACK, mWebView);
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        mToolbar.setTitle("新闻详情");
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.getSettings().setDomStorageEnabled(true);
        //加载网页的处理逻辑
        mWebView.getSettings().setJavaScriptEnabled(true);
        //支持缩放
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        //接口回调
        mWebView.setWebChromeClient(new WebViewClient());
        //加载网页
        mWebView.loadUrl(url);
        //本地显示
        mWebView.setWebViewClient(new android.webkit.WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (url.contains("http://")) {
                    view.loadUrl(url);
                }
                //接收这个事件
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
    }

    //自定义WebviewClient
    private class WebViewClient extends WebChromeClient {
        //进度变化的监听
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            //处理进度,加载完成时隐藏进度条
            if (newProgress >= 100) {

            }
        }
    }

}
