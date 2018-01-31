package com.jarchie.yue.api;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;

import com.jarchie.yue.constant.ApiConstant;
import com.jarchie.yue.constant.HostType;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jarchie on 2018\1\24.
 * 网络请求的实现类
 */

@SuppressWarnings("WeakerAccess")
public class Api{
    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 15;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 15;
    public Retrofit retrofit;
    public ApiService apiService;
    public OkHttpClient okHttpClient;
    private static SparseArray<Api> mRetrofitManager = new SparseArray<>(HostType.TYPE_COUNT);

    private Api(int hostType){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(getLoggerInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConstant.getHost(hostType))
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    //NETEASE_NEWS_VIDEO：1（新闻，视频），GANK_GIRL_PHOTO：2（图片新闻），EWS_DETAIL_HTML_PHOTO:3新闻详情html图片)
    public static ApiService getDefault(int hostType) {
        Api retrofitManager = mRetrofitManager.get(hostType);
        if (retrofitManager == null) {
            retrofitManager = new Api(hostType);
            mRetrofitManager.put(hostType, retrofitManager);
        }
        return retrofitManager.apiService;
    }

    //设置日志拦截器，打印返回的数据
    private HttpLoggingInterceptor getLoggerInterceptor() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Log.e("ApiUrl------>", message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }

}
