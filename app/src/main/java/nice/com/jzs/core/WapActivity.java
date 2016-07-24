package nice.com.jzs.core;

import android.os.Bundle;


/**
 * 
 * @author caibing.zhang
 * @createdate 2013-12-31 上午11:25:32
 * @Description: WAP页面
 */
public class WapActivity extends AbstractActivity {

	@Override
	protected void onClickBack() {
		finish();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
//		outState.putString(IntentConstants.TITLE, title);
//		outState.putString(IntentConstants.WAP_CONTENT, content);
//		outState.putString(IntentConstants.URL, url);
//		outState.putString(IntentConstants.SHARE_CONTENT, shareContent);
	}
}