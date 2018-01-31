package com.jarchie.common.base.impl;

import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.base.BaseView;

/**
 * Created by Jarchie on 2018\1\30.
 * 基础处理类的实现类
 */

public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter {
    protected V view;

    public BasePresenterImpl(V view) {
        this.view = view;
        start();
    }

    @Override
    public void start() {
    }

    @Override
    public void detach() {
        this.view = null;
    }

}
