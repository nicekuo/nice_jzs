package nice.com.jzs.ui.zicha;

import java.util.List;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/8/7.
 */
public class ZichaListBean extends BaseBean {


    /**
     * degree : 18
     * img : 111
     * zicha_id : 23
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends BaseBean {
        private String degree;
        private String img;
        private String zicha_id;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        private String time;

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getZicha_id() {
            return zicha_id;
        }

        public void setZicha_id(String zicha_id) {
            this.zicha_id = zicha_id;
        }
    }
}
