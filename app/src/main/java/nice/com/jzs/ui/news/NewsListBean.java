package nice.com.jzs.ui.news;

import nice.com.nice_library.bean.BaseBean;

import java.util.List;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class NewsListBean extends BaseBean {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public int getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(int totalRow) {
            this.totalRow = totalRow;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        /**
         * img : http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg
         * content : 脊柱侧弯到底是怎么样一种病?是怎么引起的?
         * source : 脊诊室主编
         * like_count : 123
         * heart_count : 43
         * is_like : 1
         * is_heart : 0
         */

        private boolean lastPage;
        private int pageSize;
        private int pageNumber;
        private boolean firstPage;
        private int totalRow;
        private int totalPage;

        private List<NewsListItemBean> news_list;

        public List<NewsListItemBean> getNews_list() {
            return news_list;
        }

        public void setNews_list(List<NewsListItemBean> news_list) {
            this.news_list = news_list;
        }

    }
}
