package com.jarchie.common.base;

/**
 * Created by Jarchie on 2018\1\24.
 * 封装Presenter的基类
 */

public  interface BasePresenter{
    //默认初始化
    void start();

    //Activity关闭时把View对象置为空
    void detach();

}
