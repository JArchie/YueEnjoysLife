package com.jarchie.common.constant;

/**
 * Created by Jarchie on 2018\1\24.
 * 常量类
 */

public class Constant {

    //域名地址
    public static final String NETEASE_URL = "http://c.m.163.com/";
    public static final String SINA_PHOTO_HOST = "http://gank.io/api/";
    public static final String NEWS_DETAIL_URL = "http://kaku.com/";

    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.NETEASE_NEWS_VIDEO:
                host = NETEASE_URL;
                break;
            case HostType.GANK_GIRL_PHOTO:
                host = SINA_PHOTO_HOST;
                break;
            case HostType.NEWS_DETAIL_HTML_PHOTO:
                host = NEWS_DETAIL_URL;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }

}
