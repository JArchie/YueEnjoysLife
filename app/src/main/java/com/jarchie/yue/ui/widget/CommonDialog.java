package com.jarchie.yue.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.jarchie.common.utils.ScreenUtil;
import com.jarchie.yue.R;

/**
 * Created by Jarchie on 2017\12\20.
 * 创建通用的自定义Dialog
 */

@SuppressWarnings({"ConstantConditions", "WeakerAccess"})
public class CommonDialog extends Dialog {

    private static final int WIDTH_PERCENT = 2; //宽度比
    private static final int HEIGHT_PERCENT = 3; //高度比
    private String tag; //自定义标识

    //固定大小Dialog模板
    public CommonDialog(Context context, int layout) {
        this(context, layout, R.style.Theme_dialog, Gravity.CENTER);
    }

    //固定大小Dialog属性
    public CommonDialog(Context context, int layout, int style, int gravity) {
        super(context, style);
        //设置属性
        setContentView(layout);
        int deviceWidth = ScreenUtil.getScreenWidth();
        int deviceHeight = ScreenUtil.getScreenHeight();
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = deviceWidth / HEIGHT_PERCENT * WIDTH_PERCENT;
        layoutParams.height = deviceHeight / HEIGHT_PERCENT;
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
    }

    //自定义Dialog模板
    public CommonDialog(Context context,int width,int height,int layout,int gravity){
        this(context,width,height,layout, R.style.Theme_dialog,gravity);
    }

    //自定义大小Dialog属性
    public CommonDialog(Context context,int width,int height,int layout,int style,int gravity){
        super(context,style);
        //设置属性
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = width;
        layoutParams.height = height;
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
