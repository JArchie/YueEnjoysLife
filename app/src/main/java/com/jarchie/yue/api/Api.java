package com.jarchie.yue.api;

/**
 * Created by Jarchie on 2018\1\24.
 * 网络请求的实现类
 */

public class Api extends RetrofitManage {
    private static Api api;

    protected Api(int hostType) {
        super(hostType);
    }

    public static ApiService getInstance(int hostType){
        api = new Api(hostType);
        return api.getRetrofit().create(ApiService.class);
    }

}
