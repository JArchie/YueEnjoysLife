package com.jarchie.yue.ui.videohelper;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.mvp.model.VideoBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\2\1.
 *
 */

public class VideoItemHolder extends RecyclerItemBaseHolder{
    public final static String TAG = "RecyclerView2VideoList";

    protected Context mContext;

    @Bind(R.id.list_item_container)
    FrameLayout listItemContainer;
    @Bind(R.id.list_item_btn)
    ImageView listItemBtn;

    private ImageView imageView;

    private SmallVideoHelper smallVideoHelper;

    private SmallVideoHelper.GSYSmallVideoHelperBuilder gsySmallVideoHelperBuilder;

    public VideoItemHolder(Context context,View itemView) {
        super(itemView);
        this.mContext = context;
        ButterKnife.bind(this, itemView);
        imageView = new ImageView(context);
    }

    public void onBind(final int position, final VideoBean bean,String mType) {

        //增加封面
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(mContext).load(Constant.getTJFmImgs().get(position)).into(imageView);

        smallVideoHelper.addVideoPlayer(position, imageView, TAG, listItemContainer, listItemBtn);

        listItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRecyclerBaseAdapter().notifyDataSetChanged();
                //listVideoUtil.setLoop(true);
                smallVideoHelper.setPlayPositionAndTag(position, TAG);
                String url = Constant.getTJUrls().get(position);
                //listVideoUtil.setCachePath(new File(FileUtils.getPath()));
                String title = Constant.getTJTitles().get(position);
                gsySmallVideoHelperBuilder.setVideoTitle(title).setUrl(url);

                smallVideoHelper.startPlay();

                //必须在startPlay之后设置才能生效
                //listVideoUtil.getGsyVideoPlayer().getTitleTextView().setVisibility(View.VISIBLE);
            }
        });
    }

    public void setVideoHelper(SmallVideoHelper smallVideoHelper, SmallVideoHelper.GSYSmallVideoHelperBuilder gsySmallVideoHelperBuilder) {
        this.smallVideoHelper = smallVideoHelper;
        this.gsySmallVideoHelperBuilder = gsySmallVideoHelperBuilder;
    }

}
