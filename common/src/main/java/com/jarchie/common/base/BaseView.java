package com.jarchie.common.base;

/**
 * Created by Jarchie on 2018\1\24.
 * 封装View的基类
 */

public interface BaseView {

    //内嵌加载
    void showLoading(String title);

    void stopLoading();

    void showErrorTip(String msg);

}
