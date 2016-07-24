package nice.com.jzs.ui.news;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class NewsListItemBean extends BaseBean {

    private String img;
    private String content;
    private String source;
    private int like_count;
    private int heart_count;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getHeart_count() {
        return heart_count;
    }

    public void setHeart_count(int heart_count) {
        this.heart_count = heart_count;
    }
}
