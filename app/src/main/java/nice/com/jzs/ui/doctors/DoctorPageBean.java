package nice.com.jzs.ui.doctors;

import java.util.List;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/7/26.
 */
public class DoctorPageBean extends BaseBean {


    /**
     * doctor_info : {"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456","consultation_times":"149","follow_member_num":56,"publish_article_num":60}
     * about_article : {"title":"相关文章","article_list":[{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?"}]}
     * publish_paper : {"title":"发表论文","paper_list":[{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","time":"2016年7月25日23:21:021","magazine":"《骨科研究》"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","time":"2016年7月25日23:21:021","magazine":"《骨科研究》"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","time":"2016年7月25日23:21:021","magazine":"《骨科研究》"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * avatar : http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg
         * name : 赵一鸣
         * title : 主任医师
         * hospital : 北京协和医院
         * doctor_id : 123456
         * consultation_times : 149
         * follow_member_num : 56
         * publish_article_num : 60
         */

        private DoctorInfoBean doctor_info;
        /**
         * title : 相关文章
         * article_list : [{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?"}]
         */

        private AboutArticleBean about_article;
        /**
         * title : 发表论文
         * paper_list : [{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","time":"2016年7月25日23:21:021","magazine":"《骨科研究》"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","time":"2016年7月25日23:21:021","magazine":"《骨科研究》"},{"url":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","title":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","time":"2016年7月25日23:21:021","magazine":"《骨科研究》"}]
         */

        private PublishPaperBean publish_paper;

        public DoctorInfoBean getDoctor_info() {
            return doctor_info;
        }

        public void setDoctor_info(DoctorInfoBean doctor_info) {
            this.doctor_info = doctor_info;
        }

        public AboutArticleBean getAbout_article() {
            return about_article;
        }

        public void setAbout_article(AboutArticleBean about_article) {
            this.about_article = about_article;
        }

        public PublishPaperBean getPublish_paper() {
            return publish_paper;
        }

        public void setPublish_paper(PublishPaperBean publish_paper) {
            this.publish_paper = publish_paper;
        }

        public static class DoctorInfoBean {
            private String avatar;
            private String name;
            private String title;
            private String hospital;
            private String doctor_id;
            private String consultation_times;
            private int follow_member_num;
            private int publish_article_num;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHospital() {
                return hospital;
            }

            public void setHospital(String hospital) {
                this.hospital = hospital;
            }

            public String getDoctor_id() {
                return doctor_id;
            }

            public void setDoctor_id(String doctor_id) {
                this.doctor_id = doctor_id;
            }

            public String getConsultation_times() {
                return consultation_times;
            }

            public void setConsultation_times(String consultation_times) {
                this.consultation_times = consultation_times;
            }

            public int getFollow_member_num() {
                return follow_member_num;
            }

            public void setFollow_member_num(int follow_member_num) {
                this.follow_member_num = follow_member_num;
            }

            public int getPublish_article_num() {
                return publish_article_num;
            }

            public void setPublish_article_num(int publish_article_num) {
                this.publish_article_num = publish_article_num;
            }
        }

        public static class AboutArticleBean {
            private String title;
            /**
             * url : http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg
             * title : 脊柱侧弯到底是怎么样一种病?是怎么引起的?
             */

            private List<ArticleListBean> article_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ArticleListBean> getArticle_list() {
                return article_list;
            }

            public void setArticle_list(List<ArticleListBean> article_list) {
                this.article_list = article_list;
            }

            public static class ArticleListBean {
                private String url;
                private String title;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class PublishPaperBean {
            private String title;
            /**
             * url : http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg
             * title : 脊柱侧弯到底是怎么样一种病?是怎么引起的?
             * time : 2016年7月25日23:21:021
             * magazine : 《骨科研究》
             */

            private List<PaperListBean> paper_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<PaperListBean> getPaper_list() {
                return paper_list;
            }

            public void setPaper_list(List<PaperListBean> paper_list) {
                this.paper_list = paper_list;
            }

            public static class PaperListBean {
                private String url;
                private String title;
                private String time;
                private String magazine;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getMagazine() {
                    return magazine;
                }

                public void setMagazine(String magazine) {
                    this.magazine = magazine;
                }
            }
        }
    }
}
