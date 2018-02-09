package com.jarchie.yue.ui.activity;

import android.os.Bundle;
import android.view.View;
import com.jarchie.common.base.BaseActivity;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.widget.CustomToolBar;
import com.jarchie.yue.ui.widget.ScanView;
import butterknife.Bind;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by Jarchie on 2018\2\7.
 * 二维码扫描
 */
public class ScanActivity extends BaseActivity implements ZBarScannerView.ResultHandler {

    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    @Bind(R.id.mScanView)
    ScanView mScanView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_scan;
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
                ScanActivity.this.finish();
            }
        });
    }

    @Override
    public void initData() {
        mToolbar.setTitle("二维码扫描");
        if (mScanView == null)
            mScanView = new ScanView(this);
        mScanView.setFocusable(true);
        mScanView.setResultHandler(this);
    }

    @Override
    public void handleResult(Result result) {
        final Bundle bundle = new Bundle();
        bundle.putString("SCAN_RESULT",result.getContents());
        setResult(Constant.REQUEST_SCAN_OK,getIntent().putExtras(bundle));
        ScanActivity.this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mScanView!=null)
            mScanView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mScanView!=null){
            mScanView.stopCameraPreview();
            mScanView.stopCamera();
        }
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
