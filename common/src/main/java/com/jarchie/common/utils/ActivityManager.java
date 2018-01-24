package com.jarchie.common.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * Created by Jarchie on 2018\1\24.
 * Activity管理类
 */

@SuppressWarnings({"WeakerAccess", "deprecation", "unused"})
public class ActivityManager {
    private final String TAG = ActivityManager.this.getClass().getSimpleName();
    private static Stack<Activity> activityStack;
    private static ActivityManager mInstance;

    private ActivityManager() {
    }

    //获取单一实例
    public static synchronized ActivityManager getInstance() {
        if (mInstance == null) {
            mInstance = new ActivityManager();
        }
        return mInstance;
    }

    //添加Activity到堆栈
    public synchronized void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
        Log.i(TAG, "ActivityManager添加了：" + activity.getClass().getName());
    }

    //获取当前Activity（最后一个压入栈中的）
    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    //结束当前Activity（最后一个压入栈中的）
    public void finishCurActivity() {
        finishActivity(activityStack.lastElement());
    }

    //移除最后一个Activity
    public void removeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            Log.i(TAG, "ActivityManager移除了：" + activity.getClass().getName());
        }
    }

    //结束指定的Activity
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            Log.i(TAG, "ActivityManager关闭了：" + activity.getClass().getName());
        }
    }

    //结束指定类名的Activity
    public void finishActivity(Class<?> cls) {
        for (int i = 0; i < activityStack.size(); i++) {
            if (activityStack.get(i).getClass().equals(cls)) {
                finishActivity(activityStack.get(i));
                removeActivity(activityStack.get(i));
                return;
            }
        }
    }

    //结束所有的Activity
    public void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    //退出应用程序
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
