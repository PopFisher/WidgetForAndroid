package com.common.widgetforandroid.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by popfisher on 2017/12/21.
 */

public class ScreenUtil {

    public static float db2px(Context context, float dbValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dbValue, context.getResources().getDisplayMetrics());
    }
}
