package nice.com.jzs.ui.main;

import java.util.List;

import nice.com.jzs.ui.doctors.DoctorItemBean;
import nice.com.jzs.ui.news.NewsListItemBean;
import nice.com.nice_library.bean.BaseBean;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class HomeBaen extends BaseBean {


    /**
     * banner : [{"img":"http://img5.imgtn.bdimg.com/it/u=3288727571,1668503812&fm=21&gp=0.jpg","type":2,"url":"http://life.yxlady.com/health/201510/249201.shtml"}]
     * news : {"title":"头条资讯","news_list":[{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43,"is_like":0,"is_heart":0},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43,"is_like":1,"is_heart":0},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43,"is_like":0,"is_heart":1}]}
     * doctor : {"title":"联系医生","doctor_list":[{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"}]}
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
         * title : 头条资讯
         * news_list : [{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43,"is_like":0,"is_heart":0},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43,"is_like":1,"is_heart":0},{"img":"http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg","content":"脊柱侧弯到底是怎么样一种病?是怎么引起的?","source":"脊诊室主编","like_count":123,"heart_count":43,"is_like":0,"is_heart":1}]
         */

        private NewsBean news;
        /**
         * title : 联系医生
         * doctor_list : [{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"}]
         */

        private DoctorBean doctor;
        /**
         * img : http://img5.imgtn.bdimg.com/it/u=3288727571,1668503812&fm=21&gp=0.jpg
         * type : 2
         * url : http://life.yxlady.com/health/201510/249201.shtml
         */

        private List<BannerBean> banner;

        public NewsBean getNews() {
            return news;
        }

        public void setNews(NewsBean news) {
            this.news = news;
        }

        public DoctorBean getDoctor() {
            return doctor;
        }

        public void setDoctor(DoctorBean doctor) {
            this.doctor = doctor;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class NewsBean {
            private String title;
            /**
             * img : http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg
             * content : 脊柱侧弯到底是怎么样一种病?是怎么引起的?
             * source : 脊诊室主编
             * like_count : 123
             * heart_count : 43
             * is_like : 0
             * is_heart : 0
             */

            private List<NewsListItemBean> news_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<NewsListItemBean> getNews_list() {
                return news_list;
            }

            public void setNews_list(List<NewsListItemBean> news_list) {
                this.news_list = news_list;
            }

        }

        public static class DoctorBean {
            private String title;
            /**
             * avatar : http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg
             * name : 赵一鸣
             * title : 主任医师
             * hospital : 北京协和医院
             * doctor_id : 123456
             */

            private List<DoctorItemBean> doctor_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DoctorItemBean> getDoctor_list() {
                return doctor_list;
            }

            public void setDoctor_list(List<DoctorItemBean> doctor_list) {
                this.doctor_list = doctor_list;
            }

        }

        public static class BannerBean {
            private String img;
            private int type;
            private String url;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
