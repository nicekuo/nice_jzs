package nice.com.jzs.ui.doctors;

import java.util.List;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/7/28.
 */
public class DoctorVisitTimeBean extends BaseBean {


    /**
     * during  : 上午8:30-11:30,下午13:30-17:30。
     * tips : 2016年6月9日外出学习，不坐诊。
     * visit_times : [{"id":11,"time":"周一上午","is_visit":1},{"id":21,"time":"周二上午","is_visit":0},{"id":31,"time":"周三上午","is_visit":0},{"id":41,"time":"周四上午","is_visit":1},{"id":51,"time":"周五上午","is_visit":1},{"id":12,"time":"周一下午","is_visit":0},{"id":22,"time":"周二下午","is_visit":0},{"id":32,"time":"周三下午","is_visit":1},{"id":42,"time":"周四下午","is_visit":0},{"id":52,"time":"周五下午","is_visit":1}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String during;
        private String tips;
        /**
         * id : 11
         * time : 周一上午
         * is_visit : 1
         */

        private List<VisitTimesBean> visit_times;

        public String getDuring() {
            return during;
        }

        public void setDuring(String during) {
            this.during = during;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public List<VisitTimesBean> getVisit_times() {
            return visit_times;
        }

        public void setVisit_times(List<VisitTimesBean> visit_times) {
            this.visit_times = visit_times;
        }

        public static class VisitTimesBean {
            private int id;
            private String time;
            private int is_visit;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getIs_visit() {
                return is_visit;
            }

            public void setIs_visit(int is_visit) {
                this.is_visit = is_visit;
            }
        }
    }
}
