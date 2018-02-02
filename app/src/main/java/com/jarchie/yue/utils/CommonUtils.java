package com.jarchie.yue.utils;

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

}
