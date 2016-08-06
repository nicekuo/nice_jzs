package nice.com.jzs.ui.account;

import org.androidannotations.annotations.res.StringRes;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by nice on 16/3/23.
 */
public class LoginBean extends BaseBean {


    /**
     * token : JFJDJKKFJSKDFKDFSDUDu344823437824yJHJKJKH
     * phone : 18513854789
     * avatar : http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg
     * nick_name : 林心如
     * born : 2016年8月1日
     * gender : 0
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean extends BaseBean {
        private String token;
        private String phone;
        private String avatar;
        private String nick_name;
        private String born;
        private String gender;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
