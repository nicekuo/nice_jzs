package nice.com.jzs.ui.zicha;

import java.util.List;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/8/7.
 */
public class ZichaListBean extends BaseBean {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * img : http://static.i3.xywy.com/cms/20141015/1eb0f5cb008bc21b439653566323f9f517388.jpg
         * time : 2016-8-7 15:47:25
         * degree : 约19°
         * zicha_id : 2342
         */

        private List<ZichaItemBean> zicha_list;

        public List<ZichaItemBean> getZicha_list() {
            return zicha_list;
        }

        public void setZicha_list(List<ZichaItemBean> zicha_list) {
            this.zicha_list = zicha_list;
        }

        public static class ZichaItemBean extends BaseBean {
            private String img;
            private String time;
            private String degree;
            private String zicha_id;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getDegree() {
                return degree;
            }

            public void setDegree(String degree) {
                this.degree = degree;
            }

            public String getZicha_id() {
                return zicha_id;
            }

            public void setZicha_id(String zicha_id) {
                this.zicha_id = zicha_id;
            }
        }
    }
}
