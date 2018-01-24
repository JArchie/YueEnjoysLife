package com.jarchie.common.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.jarchie.common.constant.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Jarchie on 2018\1\24.
 * 创建Retrofit的管理类
 */

class RetrofitManage {

    private volatile static Retrofit mRetrofit = null;
    private Retrofit.Builder mRetrofitBuilder = new Retrofit.Builder();

    RetrofitManage(int hostType){
        OkHttpClient.Builder mClientBuilder = new OkHttpClient.Builder();
        mRetrofitBuilder
                .baseUrl(Constant.getHost(hostType))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(mClientBuilder.addInterceptor(getLoggerInterceptor()).build());
    }

    Retrofit getRetrofit(){
        if (mRetrofit == null){
            synchronized (RetrofitManage.class){
                if (mRetrofit == null){
                    mRetrofit = mRetrofitBuilder.build(); //构建Retrofit对象
                }
            }
        }
        return mRetrofit;
    }

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
