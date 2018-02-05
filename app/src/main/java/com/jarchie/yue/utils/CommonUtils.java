package com.jarchie.yue.utils;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.utils.ActivityManager;
import com.jarchie.common.utils.BackHandlerHelper;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.activity.MainActivity;

/**
 * Created by Jarchie on 2018\2\1.
 * 应用层工具类
 */

public class CommonUtils {

    private static long exitTime = 0; //退出APP的时间

    //双击退出整个APP
    public static void exitApp(MainActivity context) {
        if (!BackHandlerHelper.handleBackPress(context)) {
            if ((System.currentTimeMillis() - exitTime) > Constant.EXIT_TIME) {
                SmartToast.show("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                context.finish();
                ActivityManager.getInstance().finishAllActivity();
                //结束进程
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        }
    }

    //自定义方法处理WebView的返回键，每次返回上一级页面
    public static void backPreviousPage(Context context, int flag, int keyCode, WebView webView) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            switch (flag) {
                case Constant.BACK_PREVIOUS_ACTIVITY:
                    if (webView.canGoBack()) {
                        webView.goBack();//返回上一页面
                    } else {
                        ((Activity) context).finish();
                    }
                    break;
                case Constant.BACK_PREVIOUS_FRAGMENT:
                    if (webView.canGoBack()) {
                        webView.goBack();//返回上一页面
                    }
                    break;
            }
        }
    }

}
