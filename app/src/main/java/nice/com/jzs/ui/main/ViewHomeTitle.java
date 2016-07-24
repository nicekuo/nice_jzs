package nice.com.jzs.ui.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import nice.com.jzs.R;
import nice.com.jzs.ui.doctors.ActivityDoctorsGroup_;
import nice.com.jzs.ui.news.ActivityNewsGroup_;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class ViewHomeTitle extends LinearLayout {


    private ImageView title_icon;
    private TextView title;
    private Context context;

    public ViewHomeTitle(Context context) {
        super(context);
        initView(context);
    }

    public ViewHomeTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_home_title, this, true);
        title_icon = (ImageView) findViewById(R.id.title_icon);
        title = (TextView) findViewById(R.id.title);
    }

    public void setData(final int img_id, String title){
        title_icon.setImageResource(img_id);
        this.title.setText(title);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (R.drawable.icon_news == img_id){
                    ActivityNewsGroup_.intent(context).start();
                }else {
                    ActivityDoctorsGroup_.intent(context).start();
                }
            }
        });
    }
}
