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
    public static final int PAGE_COUNT = 20;

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

    //归属地查询的appkey
    public static final String BELONG_KEY = "d52f788787f7e1fa0dd7c5b23f0c9f49";

    //处理Activity和Fragment中的WebView返回键
    public static final int BACK_PREVIOUS_ACTIVITY = 1;
    public static final int BACK_PREVIOUS_FRAGMENT = 2;

    //视频类型标识
    public static final String VIDEO_TYPE = "video_type";

    //视频类型：推荐、视频、段子
    public static final String VIDEO_TJ = "-101";
    public static final String VIDEO_SP = "-104";
    public static final String VIDEO_JOKES = "-102";

    //推荐列表:标题、地址、封面图片
    //推荐标题
    private static final String TJ_TITLE_01 = "史上最牛逼变形计";
    private static final String TJ_TITLE_02 = "老司机啊，这扣扣子的手速！";
    private static final String TJ_TITLE_03 = "这是一个有味道的视频\uD83D\uDE03\uD83D\uDE03";
    private static final String TJ_TITLE_04 = "真是一双巧手哦！";
    private static final String TJ_TITLE_05 = "这是我见过尺度最大的…";
    private static final String TJ_TITLE_06 = "看，车飞起来了";
    private static final String TJ_TITLE_07 = "二十万的辉腾，三十万的GTR";
    private static final String TJ_TITLE_08 = "我怎么那么讨厌百万英雄啊";
    private static final String TJ_TITLE_09 = "这..这让我怎么回家";
    private static final String TJ_TITLE_10 = "这个视频发给你女朋友，绝对会有回复\uD83D\uDE04";
    private static final String TJ_TITLE_11 = "2018年第一个让我笑到不能自拔的视频";
    private static final String TJ_TITLE_12 = "大叔喝醉了接到了爸爸的电话，最后笑岔气";
    private static final String TJ_TITLE_13 = "还有谁，站出来";
    private static final String TJ_TITLE_14 = "看完了这个，我默默扔了刚买的槟榔。";
    private static final String TJ_TITLE_15 = "某天，太阳给草打电话";
    private static final String TJ_TITLE_16 = "中国红衣大战外国白衣 最终还是打起来了";
    private static final String TJ_TITLE_17 = "搭红了，新婚快乐";
    private static final String TJ_TITLE_18 = "我家老母猪都被你干的腿软，你说是不是你的错";
    private static final String TJ_TITLE_19 = "只要这个视频点赞到200......";
    private static final String TJ_TITLE_20 = "谁能解释一下？？";
    //推荐地址
    private static final String TJ_URL_01 = "http://ic.snssdk.com/neihan/video/playback/?video_id=7805d4eb866140c6a6ab722312f7f2a0&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_02 = "http://ic.snssdk.com/neihan/video/playback/?video_id=9ed02e6a6dcd47888821ac8da670c854&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_03 = "http://ic.snssdk.com/neihan/video/playback/?video_id=f1c6b31d9e0243e1a81d5304640ba238&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_04 = "http://ic.snssdk.com/neihan/video/playback/?video_id=20a1edc8be984a238ef4e57551177dcb&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_05 = "http://ic.snssdk.com/neihan/video/playback/?video_id=1a1a4d027a074fde849cf623c9acb1ff&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_06 = "http://ic.snssdk.com/neihan/video/playback/?video_id=7a5f2783b98f424b83f26244ade955df&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_07 = "http://ic.snssdk.com/neihan/video/playback/?video_id=f24e1c88d66b470bb0bc23f3ecbcb094&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_08 = "http://ic.snssdk.com/neihan/video/playback/?video_id=432e3ecde6384145b46e2cff4868dd1d&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_09 = "http://ic.snssdk.com/neihan/video/playback/?video_id=6f517a296d94425da81ee444a9dd6dfd&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_10 = "http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_11 = "http://ic.snssdk.com/neihan/video/playback/?video_id=146a5dfecdd341a4a1983046f0950669&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_12 = "http://ic.snssdk.com/neihan/video/playback/?video_id=fb141859a9124ddbb51695c5ea3b8a0a&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_13 = "http://ic.snssdk.com/neihan/video/playback/?video_id=8c96a83dbcc74b9f9cf4ae5e19370d41&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_14 = "http://ic.snssdk.com/neihan/video/playback/?video_id=081aa9d503d74530808de0c58670706d&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_15 = "http://ic.snssdk.com/neihan/video/playback/?video_id=ca6114cf91aa4fc385d9e3d328ba1b4d&quality=480p&line=0&is_gif=1&device_platform=None.mp4";
    private static final String TJ_URL_16 = "http://ic.snssdk.com/neihan/video/playback/?video_id=ad5a38a2e8b343d09e1ac4305f23c659&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_17 = "http://ic.snssdk.com/neihan/video/playback/?video_id=ec20bb347cdf488a817ddcc923d649c0&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_18 = "http://ic.snssdk.com/neihan/video/playback/?video_id=59ce516eee154cbaa7ddaa193353effe&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String TJ_URL_19 = "http://ic.snssdk.com/neihan/video/playback/?video_id=e2ecfc03b71747539182c4b640e122c4&quality=480p&line=0&is_gif=1&device_platform=None.mp4";
    private static final String TJ_URL_20 = "http://ic.snssdk.com/neihan/video/playback/?video_id=5c0765fa2275428fbb9aea05a9ba5fef&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    //推荐封面
    private static final String TJ_FMIMG_01 = "http://p1.pstatp.com/large/5ee500066a199bc2a778";
    private static final String TJ_FMIMG_02 = "http://p1.pstatp.com/large/5ef200018d6da02df7a1";
    private static final String TJ_FMIMG_03 = "http://p3.pstatp.com/large/5826000fb51dfcdb7a62";
    private static final String TJ_FMIMG_04 = "http://p3.pstatp.com/large/55b0000b43e2d88583cc";
    private static final String TJ_FMIMG_05 = "http://p1.pstatp.com/large/5f0a00076f657468a4e4";
    private static final String TJ_FMIMG_06 = "http://p3.pstatp.com/large/5f0a000b3a352fcfed10";
    private static final String TJ_FMIMG_07 = "http://p3.pstatp.com/large/5f1400156e9eff1cd7e6";
    private static final String TJ_FMIMG_08 = "http://p1.pstatp.com/large/5f180000501e27e455ca";
    private static final String TJ_FMIMG_09 = "http://p3.pstatp.com/large/5c79000c562a0badbc0c";
    private static final String TJ_FMIMG_10 = "http://p3.pstatp.com/large/5efa00001a52afc438f0";
    private static final String TJ_FMIMG_11 = "http://p9.pstatp.com/large/5f1100167a85f3fa4215";
    private static final String TJ_FMIMG_12 = "http://p3.pstatp.com/large/5e920004e044f1292a25";
    private static final String TJ_FMIMG_13 = "http://p3.pstatp.com/large/5ee7000e415837e862ce";
    private static final String TJ_FMIMG_14 = "http://p3.pstatp.com/large/5f18000c51c7e0ce02ef";
    private static final String TJ_FMIMG_15 = "http://p9.pstatp.com/large/5b8300041e4f9966eeef";
    private static final String TJ_FMIMG_16 = "http://p3.pstatp.com/large/5f420002235ef310472a";
    private static final String TJ_FMIMG_17 = "http://p9.pstatp.com/large/5f5e00109ec5ff47f4ae";
    private static final String TJ_FMIMG_18 = "http://p9.pstatp.com/large/549b0013d9adc110ea1e";
    private static final String TJ_FMIMG_19 = "http://p1.pstatp.com/large/5b8c000358b4f66e9078";
    private static final String TJ_FMIMG_20 = "http://p1.pstatp.com/large/5ee50000f2443bc6dadb";

    private static List<String> mTitles = new ArrayList<>();
    private static List<String> mUrls = new ArrayList<>();
    private static List<String> mFmImgs = new ArrayList<>();

    public static List<String> getTJTitles() { //推荐标题
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
        mTitles.add(TJ_TITLE_11);
        mTitles.add(TJ_TITLE_12);
        mTitles.add(TJ_TITLE_13);
        mTitles.add(TJ_TITLE_14);
        mTitles.add(TJ_TITLE_15);
        mTitles.add(TJ_TITLE_16);
        mTitles.add(TJ_TITLE_17);
        mTitles.add(TJ_TITLE_18);
        mTitles.add(TJ_TITLE_19);
        mTitles.add(TJ_TITLE_20);
        return mTitles;
    }

    public static List<String> getTJUrls() { //推荐地址
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
        mUrls.add(TJ_URL_11);
        mUrls.add(TJ_URL_12);
        mUrls.add(TJ_URL_13);
        mUrls.add(TJ_URL_14);
        mUrls.add(TJ_URL_15);
        mUrls.add(TJ_URL_16);
        mUrls.add(TJ_URL_17);
        mUrls.add(TJ_URL_18);
        mUrls.add(TJ_URL_19);
        mUrls.add(TJ_URL_20);
        return mUrls;
    }

    public static List<String> getTJFmImgs() { //推荐封面
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
        mFmImgs.add(TJ_FMIMG_11);
        mFmImgs.add(TJ_FMIMG_12);
        mFmImgs.add(TJ_FMIMG_13);
        mFmImgs.add(TJ_FMIMG_14);
        mFmImgs.add(TJ_FMIMG_15);
        mFmImgs.add(TJ_FMIMG_16);
        mFmImgs.add(TJ_FMIMG_17);
        mFmImgs.add(TJ_FMIMG_18);
        mFmImgs.add(TJ_FMIMG_19);
        mFmImgs.add(TJ_FMIMG_20);
        return mFmImgs;
    }

    //视频列表:标题、地址、封面图片
    //视频标题
    private static final String SP_TITLE_01 = "最近流行跳一跳";
    private static final String SP_TITLE_02 = "买了个小乌龟给狗狗作伴！一天之后 龟还是龟！我的狗不是狗了！";
    private static final String SP_TITLE_03 = "爆笑，神经打车女";
    private static final String SP_TITLE_04 = "会不会把我拉黑 !";
    private static final String SP_TITLE_05 = "这人怎么还没被打死";
    private static final String SP_TITLE_06 = "外国技术不得不佩服！┗=͟͟͞͞(˙牛˙";
    private static final String SP_TITLE_07 = "妹子跑到大叔面前尬舞本想恶搞大叔, 却不知自己是小巫见大巫啊";
    private static final String SP_TITLE_08 = "中国的自由女神像我自己都想点13亿";
    private static final String SP_TITLE_09 = "看了好几遍这个视频 他是扔烟头了吗？";
    private static final String SP_TITLE_10 = "就你有人？有种你也叫啊";
    private static final String SP_TITLE_11 = "大哥你放大了吗？\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE1B\uD83D\uDE1B";
    private static final String SP_TITLE_12 = "明天你是否会想起？";
    private static final String SP_TITLE_13 = "大家看到了啥";
    private static final String SP_TITLE_14 = "喜欢微信支付的朋友注意了，一定要看此视频";
    private static final String SP_TITLE_15 = "也许这就是爱情吧\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02";
    private static final String SP_TITLE_16 = "老规矩，先赞后看";
    private static final String SP_TITLE_17 = "听说段友都是神手速";
    private static final String SP_TITLE_18 = "有毒！有毒！这视频这歌都有毒";
    private static final String SP_TITLE_19 = "第一句以为是《同桌的你》，第二句就乐坏了";
    private static final String SP_TITLE_20 = "这手速真不是盖的，看一遍都没发现！！";
    //视频地址
    private static final String SP_URL_01 = "http://ic.snssdk.com/neihan/video/playback/?video_id=0a8a3b8429734415a5c4b0af138226d7&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_02 = "http://ic.snssdk.com/neihan/video/playback/?video_id=793e26340f8d44ff88b2d7027fe95876&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_03 = "http://ic.snssdk.com/neihan/video/playback/?video_id=a215a382d5824913a68e069d8c990782&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_04 = "http://ic.snssdk.com/neihan/video/playback/?video_id=2715bce5c25f4a07b1e0e00ccd4667fe&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_05 = "http://ic.snssdk.com/neihan/video/playback/?video_id=72215eb0f1b44030a9eba5bf2be4baf5&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_06 = "http://ic.snssdk.com/neihan/video/playback/?video_id=e8abeaec64644e738c7a2c10846fe26f&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_07 = "http://ic.snssdk.com/neihan/video/playback/?video_id=dc5643c101f44992b1a3ca42bb359a54&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_08 = "http://ic.snssdk.com/neihan/video/playback/?video_id=096b6351bf614c95a337e111b8c7baf6&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_09 = "http://ic.snssdk.com/neihan/video/playback/?video_id=016caa98363f47829d8fe53d53e8ee00&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_10 = "http://ic.snssdk.com/neihan/video/playback/?video_id=71b33a5005034f8e85d7e3bdee2393ef&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_11 = "http://ic.snssdk.com/neihan/video/playback/?video_id=81dc7a2f34f94edbbbcd57dca8adc1aa&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_12 = "http://ic.snssdk.com/neihan/video/playback/?video_id=d8506e44162a4190b09b15406a3d1aa3&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_13 = "http://ic.snssdk.com/neihan/video/playback/?video_id=d643cde68cef43529517f8f6d32c0d19&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_14 = "http://ic.snssdk.com/neihan/video/playback/?video_id=19c8c810df8e49b08b69defc6bea1a62&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_15 = "http://ic.snssdk.com/neihan/video/playback/?video_id=6bacf0a062444a43aca20bbff9a5cdd2&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_16 = "http://ic.snssdk.com/neihan/video/playback/?video_id=5f8343bd2a9d4141a7df5d949910c2c1&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_17 = "http://ic.snssdk.com/neihan/video/playback/?video_id=3fa9a4dbf61e4b87b9bbc9f911f9e76b&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_18 = "http://ic.snssdk.com/neihan/video/playback/?video_id=cb3cfd267bc24a2c80f2c308871b5e21&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_19 = "http://ic.snssdk.com/neihan/video/playback/?video_id=69a48f42cc544d368b5257d600a1fe73&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    private static final String SP_URL_20 = "http://ic.snssdk.com/neihan/video/playback/?video_id=139a11d94dc34761a36c5beb080deded&quality=480p&line=0&is_gif=0&device_platform=.mp4";
    //视频封面
    private static final String SP_FMIMG_01 = "http://p3.pstatp.com/large/5f0e00037e3635179a42";
    private static final String SP_FMIMG_02 = "http://p1.pstatp.com/large/5f3f0000c014f8886f45";
    private static final String SP_FMIMG_03 = "http://p3.pstatp.com/large/4ca1000676fd93de0f34";
    private static final String SP_FMIMG_04 = "http://p1.pstatp.com/large/5f530014f0a16084f49c";
    private static final String SP_FMIMG_05 = "http://p3.pstatp.com/large/59f3000a1f3dbd39ceb9";
    private static final String SP_FMIMG_06 = "http://p1.pstatp.com/large/561f00106a9a30507a47";
    private static final String SP_FMIMG_07 = "http://p1.pstatp.com/large/5cb30010c295ab6fc544";
    private static final String SP_FMIMG_08 = "http://p3.pstatp.com/large/5f5500087446c2b67f10";
    private static final String SP_FMIMG_09 = "http://p1.pstatp.com/large/5f1b000248a2b8cebb1a";
    private static final String SP_FMIMG_10 = "http://p3.pstatp.com/large/5f5e0009d208ce8627da";
    private static final String SP_FMIMG_11 = "http://p9.pstatp.com/large/5cca000f1bda6c91ef63";
    private static final String SP_FMIMG_12 = "http://p1.pstatp.com/large/5a8f0007c1f4ab7c45b8";
    private static final String SP_FMIMG_13 = "http://p9.pstatp.com/large/55790000e32bfd745769";
    private static final String SP_FMIMG_14 = "http://p1.pstatp.com/large/5ee400147ba59146da59";
    private static final String SP_FMIMG_15 = "http://p3.pstatp.com/large/5a5e00067a6ade9844ef";
    private static final String SP_FMIMG_16 = "http://p3.pstatp.com/large/5f5600082cff67083667";
    private static final String SP_FMIMG_17 = "http://p3.pstatp.com/large/5f1100177f156edf08f2";
    private static final String SP_FMIMG_18 = "http://p3.pstatp.com/large/5f2c000fe98e09e2a4e4";
    private static final String SP_FMIMG_19 = "http://p3.pstatp.com/large/4cb60005ff4b12aa4384";
    private static final String SP_FMIMG_20 = "http://p3.pstatp.com/large/5ef4000687286a79633a";

    private static List<String> mSPTitles = new ArrayList<>();
    private static List<String> mSPUrls = new ArrayList<>();
    private static List<String> mSPFmImgs = new ArrayList<>();

    public static List<String> getSPTitles() { //视频标题
        mSPTitles.add(SP_TITLE_01);
        mSPTitles.add(SP_TITLE_02);
        mSPTitles.add(SP_TITLE_03);
        mSPTitles.add(SP_TITLE_04);
        mSPTitles.add(SP_TITLE_05);
        mSPTitles.add(SP_TITLE_06);
        mSPTitles.add(SP_TITLE_07);
        mSPTitles.add(SP_TITLE_08);
        mSPTitles.add(SP_TITLE_09);
        mSPTitles.add(SP_TITLE_10);
        mSPTitles.add(SP_TITLE_11);
        mSPTitles.add(SP_TITLE_12);
        mSPTitles.add(SP_TITLE_13);
        mSPTitles.add(SP_TITLE_14);
        mSPTitles.add(SP_TITLE_15);
        mSPTitles.add(SP_TITLE_16);
        mSPTitles.add(SP_TITLE_17);
        mSPTitles.add(SP_TITLE_18);
        mSPTitles.add(SP_TITLE_19);
        mSPTitles.add(SP_TITLE_20);
        return mSPTitles;
    }

    public static List<String> getSPUrls() { //视频地址
        mSPUrls.add(SP_URL_01);
        mSPUrls.add(SP_URL_02);
        mSPUrls.add(SP_URL_03);
        mSPUrls.add(SP_URL_04);
        mSPUrls.add(SP_URL_05);
        mSPUrls.add(SP_URL_06);
        mSPUrls.add(SP_URL_07);
        mSPUrls.add(SP_URL_08);
        mSPUrls.add(SP_URL_09);
        mSPUrls.add(SP_URL_10);
        mSPUrls.add(SP_URL_11);
        mSPUrls.add(SP_URL_12);
        mSPUrls.add(SP_URL_13);
        mSPUrls.add(SP_URL_14);
        mSPUrls.add(SP_URL_15);
        mSPUrls.add(SP_URL_16);
        mSPUrls.add(SP_URL_17);
        mSPUrls.add(SP_URL_18);
        mSPUrls.add(SP_URL_19);
        mSPUrls.add(SP_URL_20);
        return mSPUrls;
    }

    public static List<String> getSPFmImgs() { //视频封面
        mSPFmImgs.add(SP_FMIMG_01);
        mSPFmImgs.add(SP_FMIMG_02);
        mSPFmImgs.add(SP_FMIMG_03);
        mSPFmImgs.add(SP_FMIMG_04);
        mSPFmImgs.add(SP_FMIMG_05);
        mSPFmImgs.add(SP_FMIMG_06);
        mSPFmImgs.add(SP_FMIMG_07);
        mSPFmImgs.add(SP_FMIMG_08);
        mSPFmImgs.add(SP_FMIMG_09);
        mSPFmImgs.add(SP_FMIMG_10);
        mSPFmImgs.add(SP_FMIMG_11);
        mSPFmImgs.add(SP_FMIMG_12);
        mSPFmImgs.add(SP_FMIMG_13);
        mSPFmImgs.add(SP_FMIMG_14);
        mSPFmImgs.add(SP_FMIMG_15);
        mSPFmImgs.add(SP_FMIMG_16);
        mSPFmImgs.add(SP_FMIMG_17);
        mSPFmImgs.add(SP_FMIMG_18);
        mSPFmImgs.add(SP_FMIMG_19);
        mSPFmImgs.add(SP_FMIMG_20);
        return mSPFmImgs;
    }

}
