package com.jarchie.yue.api;

import com.jarchie.yue.mvp.model.GirlBean;
import com.jarchie.yue.mvp.model.NewsBean;
import com.jarchie.yue.mvp.model.VideoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jarchie on 2018\1\24.
 * 定义restFul请求的接口类
 */

@SuppressWarnings("WeakerAccess")
public interface ApiService {

    //新闻模块接口
    @GET("news/get")
    Call<NewsBean> requestNewsListData(@Query("channel") String channel, @Query("start") int start, @Query("num") int num, @Query("appkey") String appkey);

    //妹子模块接口
    @GET("data/福利/{size}/{page}")
    Call<GirlBean> requestGirlData(@Path("size") int size, @Path("page") int page);

    //视频模块接口
//    @GET("neihan/stream/mix/v1")
//    Call<VideoBean> requestVideoListData(@Query("content_type") String content_type, @Query("count") int count);

}
