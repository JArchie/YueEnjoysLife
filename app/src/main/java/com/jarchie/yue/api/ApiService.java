package com.jarchie.yue.api;

import com.jarchie.yue.bean.GirlBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jarchie on 2018\1\24.
 * 定义restFul请求的接口类
 */

public interface ApiService {

    //妹子模块接口
    @GET("data/福利/{size}/{page}")
    Call<GirlBean> requestGirlData(@Path("size") int size,@Path("page") int page);

}
