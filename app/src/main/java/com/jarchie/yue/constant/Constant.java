package com.jarchie.yue.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarchie on 2018\1\26.
 * 应用层的常量类
 */

public class Constant {

    //Back键退出应用所需时间
    public static final int EXIT_TIME = 2000;

    //页码
    public static final int PAGE_START = 0;
    public static final int PAGE_NUM = 1;

    //每页数量
    public static final int PAGE_SIZE = 10;

    //新闻类型标识
    public static final String CHANNEL = "channel";

    //新闻类型：头条，新闻，财经，体育，娱乐，教育，科技，健康
    public static final String TOUTIAO = "头条";
    public static final String XINWEN = "新闻";
    public static final String CAIJING = "财经";
    public static final String TIYU = "体育";
    public static final String YULE = "娱乐";
    public static final String JIAOYU = "教育";
    public static final String KEJI = "科技";
    public static final String JIANKANG = "健康";

    //新闻appkey
    public static final String NEWS_KEY = "a17c04f329d9d88f";

    //视频类型标识
    public static final String VIDEO_TYPE = "video_type";

    //视频类型：推荐、视频、段友秀
    public static final String VIDEO_TJ = "-101";
    public static final String VIDEO_SP = "-104";
    public static final String VIDEO_DYX = "-301";

    //推荐列表:标题、地址、封面图片
    //推荐标题
    private static final String TJ_TITLE_01 = "谁能截到薛之谦？";
    private static final String TJ_TITLE_02 = "老司机啊，这扣扣子的手速！";
    private static final String TJ_TITLE_03 = "这是一个有味道的视频\uD83D\uDE03\uD83D\uDE03";
    private static final String TJ_TITLE_04 = "真是一双巧手哦！";
    private static final String TJ_TITLE_05 = "这是我见过尺度最大的…";
    private static final String TJ_TITLE_06 = "看，车飞起来了";
    private static final String TJ_TITLE_07 = "妹子跑到大叔面前尬舞本想恶搞大叔, 却不知自己是小巫见大巫啊！";
    private static final String TJ_TITLE_08 = "我怎么那么讨厌百万英雄啊";
    private static final String TJ_TITLE_09 = "这..这让我怎么回家";
    private static final String TJ_TITLE_10 = "这个视频发给你女朋友，绝对会有回复\uD83D\uDE04";
    //推荐地址
    private static final String TJ_URL_01 = "http://ic.snssdk.com/neihan/video/playback/?video_id=0782da99cf4c46d9873a9016d7d2f8fe&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_02 = "http://ic.snssdk.com/neihan/video/playback/?video_id=9ed02e6a6dcd47888821ac8da670c854&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_03 = "http://ic.snssdk.com/neihan/video/playback/?video_id=f1c6b31d9e0243e1a81d5304640ba238&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_04 = "http://ic.snssdk.com/neihan/video/playback/?video_id=20a1edc8be984a238ef4e57551177dcb&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_05 = "http://ic.snssdk.com/neihan/video/playback/?video_id=1a1a4d027a074fde849cf623c9acb1ff&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_06 = "http://ic.snssdk.com/neihan/video/playback/?video_id=7a5f2783b98f424b83f26244ade955df&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_07 = "http://ic.snssdk.com/neihan/video/playback/?video_id=dc5643c101f44992b1a3ca42bb359a54&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_08 = "http://ic.snssdk.com/neihan/video/playback/?video_id=432e3ecde6384145b46e2cff4868dd1d&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_09 = "http://ic.snssdk.com/neihan/video/playback/?video_id=6f517a296d94425da81ee444a9dd6dfd&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_10 = "http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    //推荐封面
    private static final String TJ_FMIMG_01 = "http://p3.pstatp.com/large/5f4e00013259f1d9077c";
    private static final String TJ_FMIMG_02 = "http://p1.pstatp.com/large/5ef200018d6da02df7a1";
    private static final String TJ_FMIMG_03 = "http://p3.pstatp.com/large/5826000fb51dfcdb7a62";
    private static final String TJ_FMIMG_04 = "http://p3.pstatp.com/large/55b0000b43e2d88583cc";
    private static final String TJ_FMIMG_05 = "http://p1.pstatp.com/large/5f0a00076f657468a4e4";
    private static final String TJ_FMIMG_06 = "http://p3.pstatp.com/large/5f0a000b3a352fcfed10";
    private static final String TJ_FMIMG_07 = "http://p1.pstatp.com/large/5cb30010c295ab6fc544";
    private static final String TJ_FMIMG_08 = "http://p1.pstatp.com/large/5f180000501e27e455ca";
    private static final String TJ_FMIMG_09 = "http://p3.pstatp.com/large/5c79000c562a0badbc0c";
    private static final String TJ_FMIMG_10 = "http://p3.pstatp.com/large/5efa00001a52afc438f0";

    private static List<String> mTitles = new ArrayList<>();
    private static List<String> mUrls = new ArrayList<>();
    private static List<String> mFmImgs = new ArrayList<>();

    public static List<String> getTJTitles(){
        mTitles.add(TJ_TITLE_01);
        mTitles.add(TJ_TITLE_02);
        mTitles.add(TJ_TITLE_03);
        mTitles.add(TJ_TITLE_04);
        mTitles.add(TJ_TITLE_05);
        mTitles.add(TJ_TITLE_06);
        mTitles.add(TJ_TITLE_07);
        mTitles.add(TJ_TITLE_08);
        mTitles.add(TJ_TITLE_09);
        mTitles.add(TJ_TITLE_10);
        return mTitles;
    }

    public static List<String> getTJUrls(){
        mUrls.add(TJ_URL_01);
        mUrls.add(TJ_URL_02);
        mUrls.add(TJ_URL_03);
        mUrls.add(TJ_URL_04);
        mUrls.add(TJ_URL_05);
        mUrls.add(TJ_URL_06);
        mUrls.add(TJ_URL_07);
        mUrls.add(TJ_URL_08);
        mUrls.add(TJ_URL_09);
        mUrls.add(TJ_URL_10);
        return mUrls;
    }

    public static List<String> getTJFmImgs(){
        mFmImgs.add(TJ_FMIMG_01);
        mFmImgs.add(TJ_FMIMG_02);
        mFmImgs.add(TJ_FMIMG_03);
        mFmImgs.add(TJ_FMIMG_04);
        mFmImgs.add(TJ_FMIMG_05);
        mFmImgs.add(TJ_FMIMG_06);
        mFmImgs.add(TJ_FMIMG_07);
        mFmImgs.add(TJ_FMIMG_08);
        mFmImgs.add(TJ_FMIMG_09);
        mFmImgs.add(TJ_FMIMG_10);
        return mFmImgs;
    }
}
