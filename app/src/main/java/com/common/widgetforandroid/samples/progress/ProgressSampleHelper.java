package com.common.widgetforandroid.samples.progress;

import android.app.Activity;

import com.common.widgetforandroid.utils.ScreenUtil;

/**
 * Created by popfisher on 2017/12/21.
 */

public class ProgressSampleHelper {

    public void showLoadingDialog(Activity activity) {
        LoadingDialog loadingDialog = new LoadingDialog(activity);
        loadingDialog.setContentSize((int) ScreenUtil.db2px(activity, 150), (int) ScreenUtil.db2px(activity, 100));
        loadingDialog.setCanceledOnTouchOutside(true);
        loadingDialog.show();
    }
}
