package com.jarchie.common.base;

import android.app.Application;
import android.content.Context;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.R;

/**
 * Created by Jarchie on 2018\1\24.
 * 项目全局初始化
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //初始化SmartToast对象，自定义Toast显示
        SmartToast.plainToast(this)
                .backgroundColorRes(R.color.color_50)
                .textColorRes(R.color.color_fff)
                .textSizeSp(16)
                .textBold(true);
    }

    //获取全局上下文对象
    public static Context getAppContext() {
        if (mContext != null)
            return mContext;
        throw new NullPointerException("you should init first!");
    }

}
