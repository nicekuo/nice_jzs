package nice.com.jzs.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import nice.com.jzs.R;
import nice.com.nice_library.util.DisplayUtil;

/**
 * Created by admin on 2016/8/6.
 */
public class ViewProgress extends LinearLayout {

    private Context context;

    public ViewProgress(Context context) {
        super(context);
        initView(context);
    }

    public ViewProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        setOrientation(HORIZONTAL);
        int height = DisplayUtil.dip2px(context, 40);
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        setLayoutParams(params);
    }

    public void setImages(List<Integer> images) {
        removeAllViews();
        ViewProgressLine line = new ViewProgressLine(context);
        LinearLayout.LayoutParams params_image = new LayoutParams(70,70);
        LinearLayout.LayoutParams params_line = new LayoutParams(0,30);
        params_line.weight = 1;
        params_line.gravity = Gravity.CENTER_VERTICAL;

        addView(line,params_line);
        for (int i = 0; i < images.size(); i++) {
            ImageView image = new ImageView(context);
            image.setImageResource(images.get(i));
            addView(image,params_image);
            addView(new ViewProgressLine(context),params_line);
        }
    }


    private class ViewProgressImage extends ImageView {

        public ViewProgressImage(Context context) {
            super(context);
            initView(context);
        }

        public ViewProgressImage(Context context, AttributeSet attrs) {
            super(context, attrs);
            initView(context);
        }

        private void initView(Context context) {
            setBackgroundColor(getResources().getColor(R.color.blue));
        }

        public void setData(int img) {
            setImageResource(img);
        }
    }

    private class ViewProgressLine extends View {

        public ViewProgressLine(Context context) {
            super(context);
            initView(context);
        }

        public ViewProgressLine(Context context, AttributeSet attrs) {
            super(context, attrs);
            initView(context);
        }

        private void initView(Context context) {
            setBackgroundColor(getResources().getColor(R.color.line_progress));
        }
    }
}
