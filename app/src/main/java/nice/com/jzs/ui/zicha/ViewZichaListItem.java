package nice.com.jzs.ui.zicha;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.ViewById;

import nice.com.jzs.R;
import nice.com.nice_library.widget.image.SFImageView;

/**
 * Created by admin on 2016/8/7.
 */
public class ViewZichaListItem extends LinearLayout {

    private SFImageView img;
    private TextView time;
    private TextView degree;

    public ViewZichaListItem(Context context) {
        super(context);
        initView(context);
    }

    public ViewZichaListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_zicha_list_item, this, true);
        img = (SFImageView) findViewById(R.id.img);
        time = (TextView) findViewById(R.id.time);
        degree = (TextView) findViewById(R.id.degree);
    }

    public void setData(ZichaListBean.DataBean itemBean){
        if (itemBean == null){
            return;
        }
//        img.SFSetImageUrl(itemBean.getImg());
        time.setText(itemBean.getTime());
        degree.setText(itemBean.getDegree());
    }
}
