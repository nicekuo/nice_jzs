package nice.com.jzs.ui.doctors;

import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/7/20.
 */
public class DoctorItemBean extends BaseBean {
    private String avatar;
    private String name;
    private String title;
    private String hospital;
    private String doctor_id;

    public String getConsultation_times() {
        return consultation_times;
    }

    public void setConsultation_times(String consultation_times) {
        this.consultation_times = consultation_times;
    }

    private String consultation_times;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
