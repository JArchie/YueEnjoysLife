package com.jarchie.yue.ui.fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.LinearLayout;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.activity.AboutActivity;
import com.jarchie.yue.ui.activity.BelongActivity;
import com.jarchie.yue.ui.activity.ChatActivity;
import com.jarchie.yue.ui.activity.CourierActivity;
import com.jarchie.yue.ui.activity.LocationActivity;
import com.jarchie.yue.ui.activity.ScanActivity;
import com.jarchie.yue.ui.widget.CustomToolBar;
import com.jarchie.yue.ui.widget.WaveViewByBezier;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Jarchie on 2018\1\24.
 * 我的Fragment
 */

public class AssistantFragment extends BaseFragment {

    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    @Bind(R.id.user_logo)
    GlideImageView userLogo;
    //    @Bind(R.id.mWaveView)
//    WaveView mWaveView;
    @Bind(R.id.mWaveView)
    WaveViewByBezier waveViewByBezier;
    @Bind(R.id.mScanLayout)
    LinearLayout mScanLayout;
    @Bind(R.id.mChatLayout)
    LinearLayout mChatLayout;
    @Bind(R.id.mLocationLayout)
    LinearLayout mLocationLayout;
    @Bind(R.id.mBelongLayout)
    LinearLayout mBelongLayout;
    @Bind(R.id.mCourierLayout)
    LinearLayout mCourierLayout;
    @Bind(R.id.mAboutLayout)
    LinearLayout mAboutLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_assistant_layout;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mToolbar.setTitle("生活助手");
        mToolbar.hideBack();
        userLogo.loadLocalCircleImage(R.drawable.zly, R.color.placeholder_color);
//        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
//        lp.gravity = Gravity.CENTER;
//        mWaveView.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
//            @Override
//            public void OnWaveAnimation(float y) {
//                lp.setMargins(0, 0, 0, (int) y + 2);
//                userLogo.setLayoutParams(lp);
//            }
//        });
        waveViewByBezier.startAnimation();
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @OnClick({R.id.mScanLayout, R.id.mChatLayout, R.id.mLocationLayout, R.id.mBelongLayout, R.id.mCourierLayout, R.id.mAboutLayout})
    public void onClick(LinearLayout layout) {
        switch (layout.getId()) {
            case R.id.mScanLayout: //扫一扫
                requestCameraPermission();
                break;
            case R.id.mChatLayout: //聊一聊
                startActivity(new Intent(getContext(), ChatActivity.class));
                break;
            case R.id.mLocationLayout: //定位
                startActivity(new Intent(getContext(), LocationActivity.class));
                break;
            case R.id.mBelongLayout: //归属地查询
                startActivity(new Intent(getContext(), BelongActivity.class));
                break;
            case R.id.mCourierLayout: //物流查询
                startActivity(new Intent(getContext(), CourierActivity.class));
                break;
            case R.id.mAboutLayout: //关于
                startActivity(new Intent(getContext(), AboutActivity.class));
                break;
        }
    }

    //二维码扫描结果回传处理
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_SCAN_CODE) {
            if (resultCode == Constant.REQUEST_SCAN_OK) {
                Bundle bundle = data.getExtras();
                SmartToast.showInCenter(bundle.getString("SCAN_RESULT"));
            }
        }
    }

    //申请相机权限
    private void requestCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    showPermissionDialog();
                } else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
                }
            } else {
                startActivityForResult(new Intent(getContext(), ScanActivity.class), Constant.REQUEST_SCAN_CODE);
            }
        } else {
            startActivityForResult(new Intent(getContext(), ScanActivity.class), Constant.REQUEST_SCAN_CODE);
        }
    }

    //权限申请的回调处理
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivityForResult(new Intent(getContext(), ScanActivity.class), Constant.REQUEST_SCAN_CODE);
                } else {
                    SmartToast.showLongInCenter("您拒绝了此权限！使用此功能需要允许使用该权限！");
                }
                break;
        }
    }

    //弹出二维码权限提示Dialog
    private void showPermissionDialog() {
        new AlertDialog.Builder(getContext())
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setCancelable(false)
                .setTitle("相机权限申请")
                .setMessage("您允许悦享生活使用相机功能吗？")
                .show();
    }

    @Override
    public void onPause() {
        super.onPause();
        waveViewByBezier.pauseAnimation();
    }

    @Override
    public void onResume() {
        super.onResume();
        waveViewByBezier.resumeAnimation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        waveViewByBezier.stopAnimation();
    }

    @Override
    public void showLoading(String title) {}

    @Override
    public void stopLoading() {}

    @Override
    public void showErrorTip(String msg) {}

}
