package nice.com.jzs.ui.doctors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import nice.com.jzs.R;
import nice.com.nice_library.widget.container.ViewContainerItem;

/**
 * Created by admin on 2016/7/29.
 */
public class ViewDoctorVisitTimeItem extends ViewContainerItem {

    private View container;
    private CheckBox select;

    public ViewDoctorVisitTimeItem(Context context) {
        super(context);
        initView(context);
    }

    public ViewDoctorVisitTimeItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context){
        radio = 1.2f;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_doctor_visit_time_item,this,true);
        container = findViewById(R.id.container);
        select = (CheckBox) findViewById(R.id.select);
    }

    public void setData(int color,int isSelect){
        container.setBackgroundColor(color);
        if (isSelect == 1){
            select.setVisibility(View.VISIBLE);
        }else {
            select.setVisibility(View.GONE);
        }
    }
}
