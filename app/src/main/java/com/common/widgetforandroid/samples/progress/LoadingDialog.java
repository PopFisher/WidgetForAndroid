package com.common.widgetforandroid.samples.progress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.common.widgetforandroid.R;
import com.common.widgetforandroid.progress.CircleProgressView;

public class LoadingDialog extends Dialog {

    private Context mContext;
    private View mRootView;
    private int mWidth = 0;
    private int mHeight = 0;
    private CircleProgressView mProgressView;

    public LoadingDialog(Context context) {
        super(context, R.style.Dialog);
        initWindow();
        mContext = context;
    }

    public void show(int pluginId) {
        if (isShowing()) {
            dismissWithCatch();
        }
        super.show();
    }

    public void initWindow() {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = 0;
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);
    }

    public void setContentSize(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
        mRootView = findViewById(R.id.dialog_load_root_view);
        mProgressView = (CircleProgressView) findViewById(R.id.dialog_load_progress);
        mProgressView.setRoundProgressBgColor(Color.WHITE);
        mProgressView.setProgressColors(new int[] { 0x00535353, 0xff535353});
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mRootView != null && mWidth > 0 && mHeight > 0) {
            ViewGroup.LayoutParams params = mRootView.getLayoutParams();
            if (params != null) {
                params.width = mWidth;
                params.height = mHeight;
            }
        }
    }


    @Override
    public void dismiss() {
        Log.d("PluginLoadingDialog", "context : " + mContext + " dld isShowing(): " + isShowing());
        if (mContext == null) {
            return;
        }
        if (!isShowing()) { //check if dialog is showing.
            return;
        }
        if (mContext instanceof Activity) {
            Activity activity = (Activity) mContext;
            if (!isFinishingOrFinished(activity)) {
                dismissWithCatch();
            }
        } else { //if the Context used wasnt an Activity, then dismiss it too
            dismissWithCatch();
        }
    }

    private void dismissWithCatch() {
        try {
            super.dismiss();
        } catch (IllegalArgumentException ignore){
            //
        }
    }

    private boolean isFinishingOrFinished(Activity activity) {
        if (activity.isFinishing()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (activity.isDestroyed()) {
                return true;
            }
        }
        return false;
    }
}
