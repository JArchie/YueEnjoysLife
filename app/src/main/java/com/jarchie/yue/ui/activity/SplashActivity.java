package com.jarchie.yue.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;
import com.jarchie.common.utils.ActivityManager;
import com.jarchie.yue.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\24.
 * 启动页Activity
 */

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.tv_splash)
    TextView mTvSplash;
    @Bind(R.id.splash_view)
    PathView mPathView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Typeface fontType = Typeface.createFromAsset(getAssets(), "fonts/FONT.TTF");
        mTvSplash.setTypeface(fontType);
        mPathView.getPathAnimator()
                .delay(100)
                .duration(3000)
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        ActivityManager.getInstance().removeActivity(this);
    }

    @Override
    public void onBackPressed() {}
}
