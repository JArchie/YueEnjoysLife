package com.jarchie.yue.api;

import com.jarchie.yue.bean.BelongBean;
import com.jarchie.yue.mvp.model.GirlBean;
import com.jarchie.yue.mvp.model.JokesBean;
import com.jarchie.yue.mvp.model.NewsBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jarchie on 2018\1\24.
 * 定义restFul请求的接口类
 */

@SuppressWarnings("WeakerAccess")
public interface ApiService {

    //新闻模块接口
    @FormUrlEncoded
    @POST("news/get")
    Call<NewsBean> requestNewsListData(@Field("channel") String channel, @Field("start") int start, @Field("num") int num, @Field("appkey") String appkey);

    //妹子模块接口
    @GET("data/福利/{size}/{page}")
    Call<GirlBean> requestGirlData(@Path("size") int size, @Path("page") int page);

    //视频模块接口
//    @GET("neihan/stream/mix/v1")
//    Call<VideoBean> requestVideoListData(@Query("content_type") String content_type, @Query("count") int count);

    //段子接口
    @GET("neihan/stream/mix/v1")
    Call<JokesBean> requestJokesListData(@Query("content_type") String content_type, @Query("count") int count);

    //归属地查询
    @GET("mobile/get")
    Call<BelongBean> requestBelongData(@Query("phone") String phone, @Query("key") String key);

}
