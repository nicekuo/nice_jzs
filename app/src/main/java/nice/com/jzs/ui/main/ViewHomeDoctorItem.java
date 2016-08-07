package nice.com.jzs.ui.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import nice.com.jzs.ui.doctors.ActivityDoctorPage_;
import nice.com.nice_library.widget.image.SFImageView;
import nice.com.jzs.R;
import nice.com.jzs.ui.doctors.DoctorItemBean;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class ViewHomeDoctorItem extends LinearLayout {

    private SFImageView avatar;
    private TextView name;
    private TextView title;
    private TextView hospital;

    public ViewHomeDoctorItem(Context context) {
        super(context);
        initView(context);
    }

    public ViewHomeDoctorItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_home_doctor_item, this, true);
        avatar = (SFImageView) findViewById(R.id.avatar);
        name = (TextView) findViewById(R.id.name);
        title = (TextView) findViewById(R.id.title);
        hospital = (TextView) findViewById(R.id.hospital);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityDoctorPage_.intent(context).start();
            }
        });

    }

    public void setData(DoctorItemBean bean){
        avatar.SFSetImageUrl(bean.getAvatar());
        name.setText(bean.getName());
        title.setText(bean.getTitle());
        hospital.setText(bean.getHospital());
    }
}
