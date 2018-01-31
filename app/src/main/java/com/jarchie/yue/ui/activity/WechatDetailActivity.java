package com.jarchie.yue.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jarchie.common.utils.ActivityManager;
import com.jarchie.yue.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WechatDetailActivity extends AppCompatActivity {

    @Bind(R.id.topbar_back)
    ImageView topbarBack;
    @Bind(R.id.topbar_title)
    TextView topbarTitle;
    @Bind(R.id.mProgressBar)
    ProgressBar mProgressBar;
    @Bind(R.id.mWebView)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_detail);
        ButterKnife.bind(this);
        ActivityManager.getInstance().addActivity(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        topbarTitle.setText("新闻详情");
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
        mWebView.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                //接收这个事件
                return true;
            }
        });
    }

    @OnClick(R.id.topbar_back)
    public void onClick(){
        finish();
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
            if (newProgress == 100){
                mProgressBar.setVisibility(View.GONE);
            }
        }
    }

}
