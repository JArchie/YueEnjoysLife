package com.jarchie.common.glide.progress;

import com.bumptech.glide.load.engine.GlideException;

/**
 * Created by Jarchie on 2017\11\8.
 * 描述：加载进度回调监听
 */

@SuppressWarnings("unused")
public interface OnGlideImageViewListener {

    void onProgress(int percent, boolean isDone, GlideException exception);
}
