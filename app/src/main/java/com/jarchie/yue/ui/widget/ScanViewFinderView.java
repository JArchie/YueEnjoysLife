package com.jarchie.yue.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import me.dm7.barcodescanner.core.ViewFinderView;

/**
 * Created by Jarchie on 2018\02\09.
 * 二维码View的具体实现类
 */

public class ScanViewFinderView extends ViewFinderView {
    public ScanViewFinderView(Context context) {
        this(context, null);
    }

    public ScanViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mSquareViewFinder = true;
        mBorderPaint.setColor(Color.parseColor("#5EAFE2"));
        mLaserPaint.setColor(Color.parseColor("#5EAFE2"));
    }
}
