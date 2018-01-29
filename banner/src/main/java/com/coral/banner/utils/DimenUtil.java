package com.coral.banner.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by xss on 2018/1/26.
 */

public class DimenUtil {
    private static final TypedValue mTmpValue = new TypedValue();
    static final float POINT_FIVE_F = 0.5F;

    private DimenUtil() {
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue * fontScale + 0.5F);
    }

    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(pxValue / fontScale + 0.5F);
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5F);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenWidthMinusOf(Context context, int dpValue) {
        return getScreenWidth(context) - dip2px(context, (float)dpValue);
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenHeightMinusOf(Context context, int dpValue) {
        return getScreenHeight(context) - dip2px(context, (float)dpValue);
    }

    public static int getXmlValue(Context context, int id) {
        TypedValue var2 = mTmpValue;
        synchronized(mTmpValue) {
            TypedValue value = mTmpValue;
            context.getResources().getValue(id, value, true);
            return (int)TypedValue.complexToFloat(value.data);
        }
    }
}
