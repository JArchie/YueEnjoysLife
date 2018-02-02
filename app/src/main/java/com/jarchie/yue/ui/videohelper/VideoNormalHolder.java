package com.jarchie.yue.ui.videohelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jarchie.common.glide.GlideImageView;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.model.VideoBean;
import com.jarchie.yue.ui.widget.CustomCoverVideo;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\2\1.
 * 视频播放的Holder类
 */

@SuppressWarnings("WeakerAccess")
public class VideoNormalHolder extends RecyclerItemBaseHolder {
    public final static String TAG = "RecyclerView2VideoList";

    @Bind(R.id.videoplayer)
    CustomCoverVideo videoplayer;
    @Bind(R.id.iv_logo)
    GlideImageView ivLogo;
    @Bind(R.id.tv_from)
    TextView tvFrom;
    @Bind(R.id.tv_play_time)
    TextView tvPlayTime;

    private Context mContext;
    private ImageView imageView;
    private GSYVideoOptionBuilder gsyVideoOptionBuilder;

    public VideoNormalHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        ButterKnife.bind(this, itemView);
        imageView = new ImageView(context);
        gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
    }

    public void onBind(int position, VideoBean bean,String mType) {
        //增加封面
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(mContext).load(Constant.getTJFmImgs().get(position)).into(imageView);
        if (imageView.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) imageView.getParent();
            viewGroup.removeView(imageView);
        }
        ivLogo.loadLocalCircleImage(R.drawable.neihan, R.color.placeholder_color);
        tvFrom.setText("内涵段子");

        String url = Constant.getTJUrls().get(position);
        String title = Constant.getTJTitles().get(position);

        //防止错位，离开释放
        //gsyVideoPlayer.initUIState();
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
                .setThumbImageView(imageView)
                .setUrl(url)
                .setSetUpLazy(true)//lazy可以防止滑动卡顿
                .setVideoTitle(title)
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
                .setPlayPosition(position)
                .setStandardVideoAllCallBack(new VideoListener() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (!videoplayer.isIfCurrentIsFullscreen()) {
                            //静音
                            GSYVideoManager.instance().setNeedMute(true);
                        }

                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        //全屏不静音
                        GSYVideoManager.instance().setNeedMute(true);
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        GSYVideoManager.instance().setNeedMute(false);
                        videoplayer.getCurrentPlayer().getTitleTextView().setText((String) objects[0]);
                    }
                }).build(videoplayer);

        //增加title
        videoplayer.getTitleTextView().setVisibility(View.GONE);
        //设置返回键
        videoplayer.getBackButton().setVisibility(View.GONE);
        //设置全屏按键功能
        videoplayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolveFullBtn(videoplayer);
            }
        });
    }

    //全屏幕按键处理
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(mContext, true, true);
    }

}
