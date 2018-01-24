package com.jarchie.common.network;

/**
 * Created by Jarchie on 2018\1\24.
 * 网络请求的实现类
 */

public class Api extends RetrofitManage {
    private static Api api;

    public Api(int hostType) {
        super(hostType);
        api = new Api(hostType);
    }

    public static ApiService getInstance(){
        return api.getRetrofit().create(ApiService.class);
    }

}
