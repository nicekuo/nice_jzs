package nice.com.jzs.ui;

import android.content.Context;
import android.util.AttributeSet;

import nice.com.nice_library.util.DisplayUtil;
import nice.com.nice_library.widget.container.ViewContainerItem;
import nice.com.jzs.R;

/**
 * Created by nice on 16/4/13.
 */
public class BlankEmptyView extends ViewContainerItem {


    public BlankEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BlankEmptyView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        height = DisplayUtil.dip2px(context,5);
        isMatchParent = 1;
        setBackgroundColor(getResources().getColor(R.color.app_bg_color));
    }
}
