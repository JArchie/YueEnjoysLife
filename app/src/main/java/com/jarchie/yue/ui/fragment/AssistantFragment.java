package com.jarchie.yue.ui.fragment;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.ui.widget.CustomToolBar;
import com.jarchie.yue.ui.widget.WaveViewByBezier;
import butterknife.Bind;

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
