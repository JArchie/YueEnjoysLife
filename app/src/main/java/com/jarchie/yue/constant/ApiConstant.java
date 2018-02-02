package com.jarchie.yue.constant;

/**
 * Created by Jarchie on 2018\1\24.
 * 常量类
 */

@SuppressWarnings("WeakerAccess")
public class ApiConstant {

    //域名地址
    public static final String VIDEO_URL = "http://lf.snssdk.com/";
    public static final String SINA_PHOTO_HOST = "http://gank.io/api/";
    public static final String NEWS_URL = "http://api.jisuapi.com/";

    //获取域名服务器地址
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.NEIHAN_VIDEO:
                host = VIDEO_URL;
                break;
            case HostType.GANK_GIRL_PHOTO:
                host = SINA_PHOTO_HOST;
                break;
            case HostType.NEWS_LIST:
                host = NEWS_URL;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }

}
