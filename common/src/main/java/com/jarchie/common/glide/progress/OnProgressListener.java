package com.jarchie.common.glide.progress;

import com.bumptech.glide.load.engine.GlideException;

/**
 * Created by Jarchie on 2017\11\8.
 * 描述：进度监听
 */

@SuppressWarnings("unused")
public interface OnProgressListener {

    void onProgress(String imageUrl, long bytesRead, long totalBytes, boolean isDone, GlideException exception);
}
