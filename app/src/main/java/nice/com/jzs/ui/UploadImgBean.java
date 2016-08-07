package nice.com.jzs.ui;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/8/7.
 */
public class UploadImgBean extends BaseBean {


    /**
     * url : http://www.meixinger.com/jifeng/upload/1470553999855.jpg
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
