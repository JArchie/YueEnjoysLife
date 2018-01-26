package com.jarchie.common.widget;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;

import com.jarchie.common.R;
import com.jarchie.common.utils.DynamicTimeFormat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Created by Jarchie on 2017\12\11.
 * 初始化刷新加载的Header样式
 */

public class RefreshInitView {

    private static Drawable mDrawableProgress;

    public static void initView(RefreshLayout mRefreshLayout) {
        ClassicsHeader mClassicsHeader = (ClassicsHeader) mRefreshLayout.getRefreshHeader();
        if (mClassicsHeader != null) {
            mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));
        }
        if (mClassicsHeader != null) {
            mDrawableProgress = mClassicsHeader.getProgressView().getDrawable();
        }
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }
    }

    public static void initDataView(RefreshLayout mRefreshLayout, Activity context) {
        setThemeColor(mRefreshLayout,context, R.color.colorPrimary, R.color.colorPrimaryDark);
        mRefreshLayout.getLayout().setBackgroundResource(android.R.color.transparent);
        mRefreshLayout.setPrimaryColors(0, 0xff666666);
        if (Build.VERSION.SDK_INT >= 21) {
            mDrawableProgress.setTint(0xff666666);
        } else if (mDrawableProgress instanceof VectorDrawableCompat) {
            ((VectorDrawableCompat) mDrawableProgress).setTint(0xff666666);
        }
    }

    private static void setThemeColor(RefreshLayout mRefreshLayout,Activity context, int colorPrimary, int colorPrimaryDark) {
        mRefreshLayout.setPrimaryColorsId(colorPrimary, android.R.color.white);
        if (Build.VERSION.SDK_INT >= 21) {
            context.getWindow().setStatusBarColor(ContextCompat.getColor(context, colorPrimaryDark));
            mDrawableProgress.setTint(0xffffffff);
        } else if (mDrawableProgress instanceof VectorDrawableCompat) {
            ((VectorDrawableCompat) mDrawableProgress).setTint(0xffffffff);
        }
    }

}
