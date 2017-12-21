package com.common.widgetforandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.common.widgetforandroid.samples.progress.ProgressSampleHelper;

public class WidgetMainActivity extends Activity implements View.OnClickListener {

    private ProgressSampleHelper mProgressSampleHelper;
    private Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_main);
        initView();
        initData();
    }

    private void initData() {
        mActivity = this;
        mProgressSampleHelper = new ProgressSampleHelper();
    }

    private void initView() {
        findViewById(R.id.control_progress_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.control_progress_btn:
                mProgressSampleHelper.showLoadingDialog(mActivity);
                break;
        }
    }
}
