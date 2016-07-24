package nice.com.jzs.ui.news;

import nice.com.nice_library.bean.BaseBean;

import java.util.List;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class NewsGroupListBean extends BaseBean{


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * group_title : 头条资讯
         * group_id : 12345678
         */

        private List<NewsGroupBean> news_group;

        public List<NewsGroupBean> getNews_group() {
            return news_group;
        }

        public void setNews_group(List<NewsGroupBean> news_group) {
            this.news_group = news_group;
        }

        public static class NewsGroupBean {
            private String group_title;
            private String group_id;

            public String getGroup_title() {
                return group_title;
            }

            public void setGroup_title(String group_title) {
                this.group_title = group_title;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }
        }
    }
}
