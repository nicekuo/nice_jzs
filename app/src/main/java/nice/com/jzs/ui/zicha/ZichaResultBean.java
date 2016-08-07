package nice.com.jzs.ui.zicha;

import java.util.List;

import nice.com.jzs.ui.doctors.DoctorItemBean;
import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/8/7.
 */
public class ZichaResultBean extends BaseBean {


    /**
     * degree : 54
     * doctor_list : [{"title":"主任医师","name":"赵一鸣","doctor_id":"123123","follow_member_num":null,"consultation_times":"149","avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","publish_article_num":null,"hospital":"北京协和医院"}]
     * diagnosed : 比较轻微的脊柱侧弯
     * tips : Cobb角是用来测试脊柱侧弯弯度的指标，cobb角越大，说明越严重。超过20度需要用支具矫正治疗，超过40度则需要用手术治疗。
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String degree;
        private String diagnosed;
        private String tips;
        /**
         * title : 主任医师
         * name : 赵一鸣
         * doctor_id : 123123
         * follow_member_num : null
         * consultation_times : 149
         * avatar : http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg
         * publish_article_num : null
         * hospital : 北京协和医院
         */

        private List<DoctorItemBean> doctor_list;

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getDiagnosed() {
            return diagnosed;
        }

        public void setDiagnosed(String diagnosed) {
            this.diagnosed = diagnosed;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public List<DoctorItemBean> getDoctor_list() {
            return doctor_list;
        }

        public void setDoctor_list(List<DoctorItemBean> doctor_list) {
            this.doctor_list = doctor_list;
        }

    }
}
