package nice.com.jzs.ui.doctors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import nice.com.nice_library.widget.image.SFImageView;
import nice.com.jzs.R;

/**
 * Created by admin on 2016/7/20.
 */
public class ViewDoctorListItem extends LinearLayout {

    private SFImageView avatar;
    private TextView name;
    private TextView hospital;
    private TextView title;
    private TextView consultation;

    public ViewDoctorListItem(Context context) {
        super(context);
        initView(context);
    }

    public ViewDoctorListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_doctor_list_item, this, true);
        avatar = (SFImageView) findViewById(R.id.avatar);
        name = (TextView) findViewById(R.id.name);
        title = (TextView) findViewById(R.id.title);
        hospital = (TextView) findViewById(R.id.hospital);
        consultation = (TextView) findViewById(R.id.consultation);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityDoctorPage_.intent(context).start();
            }
        });
    }

    public void setData(DoctorItemBean itemBean){
        avatar.SFSetImageUrl(itemBean.getAvatar());
        name.setText(itemBean.getName());
        title.setText(itemBean.getTitle());
        hospital.setText(itemBean.getHospital());
        consultation.setText(itemBean.getConsultation_times()+"次咨询");
    }
}
