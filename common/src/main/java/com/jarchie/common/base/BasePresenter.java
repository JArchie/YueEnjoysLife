package com.jarchie.common.base;

import android.content.Context;

/**
 * Created by Jarchie on 2018\1\24.
 * 封装Presenter的基类
 */

public abstract class BasePresenter<V, M> {
    public Context mContext;
    public M mModel;
    public V mView;

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {}

    public void onDestroy() {
        this.mView = null;
    }

}
