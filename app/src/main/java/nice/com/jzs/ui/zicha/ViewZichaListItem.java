package nice.com.jzs.ui.zicha;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import nice.com.jzs.R;
import nice.com.jzs.ui.main.MainActivity;
import nice.com.nice_library.nice_view.PopupWindowUtil;
import nice.com.nice_library.nice_view.ViewPhotoViews;
import nice.com.nice_library.widget.image.SFImageView;

/**
 * Created by admin on 2016/8/7.
 */
public class ViewZichaListItem extends LinearLayout {

    private SFImageView img;
    private TextView time;
    private TextView degree;
    private ZichaListBean.DataBean dataBean;
    private MainActivity context;

    public ViewZichaListItem(Context context) {
        super(context);
        initView(context);
    }

    public ViewZichaListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        this.context = (MainActivity) context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_zicha_list_item, this, true);
        img = (SFImageView) findViewById(R.id.img);
        time = (TextView) findViewById(R.id.time);
        degree = (TextView) findViewById(R.id.degree);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataBean != null) {
                    ActivityZichaResult_.intent(context).id(dataBean.getZicha_id()).start();
                }
            }
        });
        img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataBean!=null&&!TextUtils.isEmpty(dataBean.getImg())){
                    showPhotoViews(0);
                }
            }
        });
    }

    public void setData(ZichaListBean.DataBean itemBean) {
        if (itemBean == null) {
            return;
        }
        this.dataBean = itemBean;
        img.SFSetImageUrl(itemBean.getImg());
        time.setText(itemBean.getTime());
        degree.setText(itemBean.getDegree());
    }

    private void showPhotoViews(int index) {
        ViewPhotoViews viewPhotoViews = new ViewPhotoViews(context);
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add(dataBean.getImg());
        viewPhotoViews.setData(imageUrls);
        viewPhotoViews.show(index);
        final PopupWindow popupWindow = PopupWindowUtil.getMacthParentPopupWindow(viewPhotoViews, context);
        viewPhotoViews.register(new ViewPhotoViews.OnClickDismissDialogListener() {
            @Override
            public void onDismssDialog() {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(context.rootView, Gravity.CENTER, 0, 0);
    }
}
