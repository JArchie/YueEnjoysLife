package com.jarchie.yue.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jarchie on 2018\1\31.
 * 视频模块的数据实体
 */

public class VideoBean {

    private String message;
    private DataBeanX data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {

        private boolean has_more;
        private String tip;
        private boolean has_new_message;
        private double max_time;
        private int min_time;
        private List<DataBean> data;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public boolean isHas_new_message() {
            return has_new_message;
        }

        public void setHas_new_message(boolean has_new_message) {
            this.has_new_message = has_new_message;
        }

        public double getMax_time() {
            return max_time;
        }

        public void setMax_time(double max_time) {
            this.max_time = max_time;
        }

        public int getMin_time() {
            return min_time;
        }

        public void setMin_time(int min_time) {
            this.min_time = min_time;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {

            private GroupBean group;
            private int type;
            private double display_time;
            private double online_time;
            private List<?> comments;

            public GroupBean getGroup() {
                return group;
            }

            public void setGroup(GroupBean group) {
                this.group = group;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public double getDisplay_time() {
                return display_time;
            }

            public void setDisplay_time(double display_time) {
                this.display_time = display_time;
            }

            public double getOnline_time() {
                return online_time;
            }

            public void setOnline_time(double online_time) {
                this.online_time = online_time;
            }

            public List<?> getComments() {
                return comments;
            }

            public void setComments(List<?> comments) {
                this.comments = comments;
            }

            public static class GroupBean {
                @SerializedName("360p_video")
                private _$360pVideoBean _$360p_video;
                private String mp4_url;
                private String text;
                private int category_activity_start_time;
                @SerializedName("720p_video")
                private _$720pVideoBean _$720p_video;
                private int digg_count;
                private double duration;
                @SerializedName("480p_video")
                private _$480pVideoBean _$480p_video;
                private int create_time;
                private String share_url;
                private int go_detail_count;
                private String keywords;
                private long id;
                private int favorite_count;
                private DanmakuAttrsBean danmaku_attrs;
                private String m3u8_url;
                private LargeCoverBean large_cover;
                private String category_activity_schema_url;
                private int user_favorite;
                private int share_type;
                private String title;
                private String category_activity_text;
                private UserBean user;
                private int is_can_share;
                private int category_type;
                private String download_url;
                private int label;
                private String content;
                private int video_height;
                private int comment_count;
                private String id_str;
                private int media_type;
                private int share_count;
                private int type;
                private int category_id;
                private int status;
                private int has_comments;
                private String publish_time;
                private int user_bury;
                private OriginVideoBean origin_video;
                private String status_desc;
                private int play_count;
                private int user_repin;
                private int category_activity_end_time;
                private MediumCoverBean medium_cover;
                private int user_digg;
                private int video_width;
                private int online_time;
                private String category_name;
                private String flash_url;
                private boolean category_visible;
                private int bury_count;
                private boolean is_anonymous;
                private int repin_count;
                private String video_id;
                private String uri;
                private int is_public_url;
                private int has_hot_comments;
                private int category_show_ranking;
                private String cover_image_uri;
                private int category_is_activity;
                private String cover_image_url;
                private ActivityBean activity;
                private long group_id;
                private int is_video;
                private boolean allow_dislike;
                private int display_type;
                private List<DislikeReasonBean> dislike_reason;

                public _$360pVideoBean get_$360p_video() {
                    return _$360p_video;
                }

                public void set_$360p_video(_$360pVideoBean _$360p_video) {
                    this._$360p_video = _$360p_video;
                }

                public String getMp4_url() {
                    return mp4_url;
                }

                public void setMp4_url(String mp4_url) {
                    this.mp4_url = mp4_url;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCategory_activity_start_time() {
                    return category_activity_start_time;
                }

                public void setCategory_activity_start_time(int category_activity_start_time) {
                    this.category_activity_start_time = category_activity_start_time;
                }

                public _$720pVideoBean get_$720p_video() {
                    return _$720p_video;
                }

                public void set_$720p_video(_$720pVideoBean _$720p_video) {
                    this._$720p_video = _$720p_video;
                }

                public int getDigg_count() {
                    return digg_count;
                }

                public void setDigg_count(int digg_count) {
                    this.digg_count = digg_count;
                }

                public double getDuration() {
                    return duration;
                }

                public void setDuration(double duration) {
                    this.duration = duration;
                }

                public _$480pVideoBean get_$480p_video() {
                    return _$480p_video;
                }

                public void set_$480p_video(_$480pVideoBean _$480p_video) {
                    this._$480p_video = _$480p_video;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
                }

                public int getGo_detail_count() {
                    return go_detail_count;
                }

                public void setGo_detail_count(int go_detail_count) {
                    this.go_detail_count = go_detail_count;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getFavorite_count() {
                    return favorite_count;
                }

                public void setFavorite_count(int favorite_count) {
                    this.favorite_count = favorite_count;
                }

                public DanmakuAttrsBean getDanmaku_attrs() {
                    return danmaku_attrs;
                }

                public void setDanmaku_attrs(DanmakuAttrsBean danmaku_attrs) {
                    this.danmaku_attrs = danmaku_attrs;
                }

                public String getM3u8_url() {
                    return m3u8_url;
                }

                public void setM3u8_url(String m3u8_url) {
                    this.m3u8_url = m3u8_url;
                }

                public LargeCoverBean getLarge_cover() {
                    return large_cover;
                }

                public void setLarge_cover(LargeCoverBean large_cover) {
                    this.large_cover = large_cover;
                }

                public String getCategory_activity_schema_url() {
                    return category_activity_schema_url;
                }

                public void setCategory_activity_schema_url(String category_activity_schema_url) {
                    this.category_activity_schema_url = category_activity_schema_url;
                }

                public int getUser_favorite() {
                    return user_favorite;
                }

                public void setUser_favorite(int user_favorite) {
                    this.user_favorite = user_favorite;
                }

                public int getShare_type() {
                    return share_type;
                }

                public void setShare_type(int share_type) {
                    this.share_type = share_type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCategory_activity_text() {
                    return category_activity_text;
                }

                public void setCategory_activity_text(String category_activity_text) {
                    this.category_activity_text = category_activity_text;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public int getIs_can_share() {
                    return is_can_share;
                }

                public void setIs_can_share(int is_can_share) {
                    this.is_can_share = is_can_share;
                }

                public int getCategory_type() {
                    return category_type;
                }

                public void setCategory_type(int category_type) {
                    this.category_type = category_type;
                }

                public String getDownload_url() {
                    return download_url;
                }

                public void setDownload_url(String download_url) {
                    this.download_url = download_url;
                }

                public int getLabel() {
                    return label;
                }

                public void setLabel(int label) {
                    this.label = label;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getVideo_height() {
                    return video_height;
                }

                public void setVideo_height(int video_height) {
                    this.video_height = video_height;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public String getId_str() {
                    return id_str;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }

                public int getMedia_type() {
                    return media_type;
                }

                public void setMedia_type(int media_type) {
                    this.media_type = media_type;
                }

                public int getShare_count() {
                    return share_count;
                }

                public void setShare_count(int share_count) {
                    this.share_count = share_count;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getHas_comments() {
                    return has_comments;
                }

                public void setHas_comments(int has_comments) {
                    this.has_comments = has_comments;
                }

                public String getPublish_time() {
                    return publish_time;
                }

                public void setPublish_time(String publish_time) {
                    this.publish_time = publish_time;
                }

                public int getUser_bury() {
                    return user_bury;
                }

                public void setUser_bury(int user_bury) {
                    this.user_bury = user_bury;
                }

                public OriginVideoBean getOrigin_video() {
                    return origin_video;
                }

                public void setOrigin_video(OriginVideoBean origin_video) {
                    this.origin_video = origin_video;
                }

                public String getStatus_desc() {
                    return status_desc;
                }

                public void setStatus_desc(String status_desc) {
                    this.status_desc = status_desc;
                }

                public int getPlay_count() {
                    return play_count;
                }

                public void setPlay_count(int play_count) {
                    this.play_count = play_count;
                }

                public int getUser_repin() {
                    return user_repin;
                }

                public void setUser_repin(int user_repin) {
                    this.user_repin = user_repin;
                }

                public int getCategory_activity_end_time() {
                    return category_activity_end_time;
                }

                public void setCategory_activity_end_time(int category_activity_end_time) {
                    this.category_activity_end_time = category_activity_end_time;
                }

                public MediumCoverBean getMedium_cover() {
                    return medium_cover;
                }

                public void setMedium_cover(MediumCoverBean medium_cover) {
                    this.medium_cover = medium_cover;
                }

                public int getUser_digg() {
                    return user_digg;
                }

                public void setUser_digg(int user_digg) {
                    this.user_digg = user_digg;
                }

                public int getVideo_width() {
                    return video_width;
                }

                public void setVideo_width(int video_width) {
                    this.video_width = video_width;
                }

                public int getOnline_time() {
                    return online_time;
                }

                public void setOnline_time(int online_time) {
                    this.online_time = online_time;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getFlash_url() {
                    return flash_url;
                }

                public void setFlash_url(String flash_url) {
                    this.flash_url = flash_url;
                }

                public boolean isCategory_visible() {
                    return category_visible;
                }

                public void setCategory_visible(boolean category_visible) {
                    this.category_visible = category_visible;
                }

                public int getBury_count() {
                    return bury_count;
                }

                public void setBury_count(int bury_count) {
                    this.bury_count = bury_count;
                }

                public boolean isIs_anonymous() {
                    return is_anonymous;
                }

                public void setIs_anonymous(boolean is_anonymous) {
                    this.is_anonymous = is_anonymous;
                }

                public int getRepin_count() {
                    return repin_count;
                }

                public void setRepin_count(int repin_count) {
                    this.repin_count = repin_count;
                }

                public String getVideo_id() {
                    return video_id;
                }

                public void setVideo_id(String video_id) {
                    this.video_id = video_id;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public int getIs_public_url() {
                    return is_public_url;
                }

                public void setIs_public_url(int is_public_url) {
                    this.is_public_url = is_public_url;
                }

                public int getHas_hot_comments() {
                    return has_hot_comments;
                }

                public void setHas_hot_comments(int has_hot_comments) {
                    this.has_hot_comments = has_hot_comments;
                }

                public int getCategory_show_ranking() {
                    return category_show_ranking;
                }

                public void setCategory_show_ranking(int category_show_ranking) {
                    this.category_show_ranking = category_show_ranking;
                }

                public String getCover_image_uri() {
                    return cover_image_uri;
                }

                public void setCover_image_uri(String cover_image_uri) {
                    this.cover_image_uri = cover_image_uri;
                }

                public int getCategory_is_activity() {
                    return category_is_activity;
                }

                public void setCategory_is_activity(int category_is_activity) {
                    this.category_is_activity = category_is_activity;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public ActivityBean getActivity() {
                    return activity;
                }

                public void setActivity(ActivityBean activity) {
                    this.activity = activity;
                }

                public long getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(long group_id) {
                    this.group_id = group_id;
                }

                public int getIs_video() {
                    return is_video;
                }

                public void setIs_video(int is_video) {
                    this.is_video = is_video;
                }

                public boolean isAllow_dislike() {
                    return allow_dislike;
                }

                public void setAllow_dislike(boolean allow_dislike) {
                    this.allow_dislike = allow_dislike;
                }

                public int getDisplay_type() {
                    return display_type;
                }

                public void setDisplay_type(int display_type) {
                    this.display_type = display_type;
                }

                public List<DislikeReasonBean> getDislike_reason() {
                    return dislike_reason;
                }

                public void setDislike_reason(List<DislikeReasonBean> dislike_reason) {
                    this.dislike_reason = dislike_reason;
                }

                public static class _$360pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=360p&line=0&is_gif=0&device_platform="},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=360p&line=1&is_gif=0&device_platform="}]
                     * uri : 360p/b93a96dfe2e24b5c9fc81dd9e6b9415b
                     * height : 480
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBean> url_list;

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public List<UrlListBean> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBean> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBean {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=360p&line=0&is_gif=0&device_platform=
                         */

                        private String url;

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class _$720pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=720p&line=0&is_gif=0&device_platform="},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=720p&line=1&is_gif=0&device_platform="}]
                     * uri : 720p/b93a96dfe2e24b5c9fc81dd9e6b9415b
                     * height : 480
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBeanX> url_list;

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public List<UrlListBeanX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=720p&line=0&is_gif=0&device_platform=
                         */

                        private String url;

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class _$480pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=480p&line=0&is_gif=0&device_platform="},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=480p&line=1&is_gif=0&device_platform="}]
                     * uri : 480p/b93a96dfe2e24b5c9fc81dd9e6b9415b
                     * height : 480
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBeanXX> url_list;

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public List<UrlListBeanXX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanXX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanXX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=480p&line=0&is_gif=0&device_platform=
                         */

                        private String url;

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class DanmakuAttrsBean {
                    /**
                     * allow_show_danmaku : 1
                     * allow_send_danmaku : 1
                     */

                    private int allow_show_danmaku;
                    private int allow_send_danmaku;

                    public int getAllow_show_danmaku() {
                        return allow_show_danmaku;
                    }

                    public void setAllow_show_danmaku(int allow_show_danmaku) {
                        this.allow_show_danmaku = allow_show_danmaku;
                    }

                    public int getAllow_send_danmaku() {
                        return allow_send_danmaku;
                    }

                    public void setAllow_send_danmaku(int allow_send_danmaku) {
                        this.allow_send_danmaku = allow_send_danmaku;
                    }
                }

                public static class LargeCoverBean {
                    /**
                     * url_list : [{"url":"http://p3.pstatp.com/large/5efa00001a52afc438f0"},{"url":"http://pb9.pstatp.com/large/5efa00001a52afc438f0"},{"url":"http://pb1.pstatp.com/large/5efa00001a52afc438f0"}]
                     * uri : large/5efa00001a52afc438f0
                     */

                    private String uri;
                    private List<UrlListBeanXXX> url_list;

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public List<UrlListBeanXXX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanXXX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanXXX {
                        /**
                         * url : http://p3.pstatp.com/large/5efa00001a52afc438f0
                         */

                        private String url;

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class UserBean {
                    /**
                     * is_living : false
                     * user_id : 76785936360
                     * name : 用户250322778
                     * followings : 0
                     * user_verified : false
                     * ugc_count : 1
                     * avatar_url : http://p3.pstatp.com/medium/46c200092bcc8aee38f5
                     * followers : 85
                     * is_following : false
                     * is_pro_user : false
                     * medals : []
                     */

                    private boolean is_living;
                    private long user_id;
                    private String name;
                    private int followings;
                    private boolean user_verified;
                    private int ugc_count;
                    private String avatar_url;
                    private int followers;
                    private boolean is_following;
                    private boolean is_pro_user;
                    private List<?> medals;

                    public boolean isIs_living() {
                        return is_living;
                    }

                    public void setIs_living(boolean is_living) {
                        this.is_living = is_living;
                    }

                    public long getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(long user_id) {
                        this.user_id = user_id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getFollowings() {
                        return followings;
                    }

                    public void setFollowings(int followings) {
                        this.followings = followings;
                    }

                    public boolean isUser_verified() {
                        return user_verified;
                    }

                    public void setUser_verified(boolean user_verified) {
                        this.user_verified = user_verified;
                    }

                    public int getUgc_count() {
                        return ugc_count;
                    }

                    public void setUgc_count(int ugc_count) {
                        this.ugc_count = ugc_count;
                    }

                    public String getAvatar_url() {
                        return avatar_url;
                    }

                    public void setAvatar_url(String avatar_url) {
                        this.avatar_url = avatar_url;
                    }

                    public int getFollowers() {
                        return followers;
                    }

                    public void setFollowers(int followers) {
                        this.followers = followers;
                    }

                    public boolean isIs_following() {
                        return is_following;
                    }

                    public void setIs_following(boolean is_following) {
                        this.is_following = is_following;
                    }

                    public boolean isIs_pro_user() {
                        return is_pro_user;
                    }

                    public void setIs_pro_user(boolean is_pro_user) {
                        this.is_pro_user = is_pro_user;
                    }

                    public List<?> getMedals() {
                        return medals;
                    }

                    public void setMedals(List<?> medals) {
                        this.medals = medals;
                    }
                }

                public static class OriginVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=origin&line=0&is_gif=0&device_platform="},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=origin&line=1&is_gif=0&device_platform="}]
                     * uri : origin/b93a96dfe2e24b5c9fc81dd9e6b9415b
                     * height : 480
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBeanXXXX> url_list;

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public List<UrlListBeanXXXX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanXXXX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanXXXX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/?video_id=b93a96dfe2e24b5c9fc81dd9e6b9415b&quality=origin&line=0&is_gif=0&device_platform=
                         */

                        private String url;

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class MediumCoverBean {
                    public static class UrlListBeanXXXXX {
                    }
                }

                public static class ActivityBean {
                }

                public static class DislikeReasonBean {
                    /**
                     * type : 2
                     * id : 65
                     * title : 吧:搞笑视频
                     */

                    private int type;
                    private double id;
                    private String title;

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public double getId() {
                        return id;
                    }

                    public void setId(double id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }
            }
        }
    }
}
