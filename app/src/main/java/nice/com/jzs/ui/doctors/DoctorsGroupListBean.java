package nice.com.jzs.ui.doctors;

import nice.com.nice_library.bean.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/7/20.
 */
public class DoctorsGroupListBean extends BaseBean {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * group_title : 骨科医生
         * group_id : 12345678
         */

        private List<DoctorGroupBean> doctor_group;

        public List<DoctorGroupBean> getDoctor_group() {
            return doctor_group;
        }

        public void setDoctor_group(List<DoctorGroupBean> doctor_group) {
            this.doctor_group = doctor_group;
        }

        public static class DoctorGroupBean {
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
