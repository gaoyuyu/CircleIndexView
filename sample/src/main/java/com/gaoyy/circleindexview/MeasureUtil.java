package com.gaoyy.circleindexview;

import android.content.Context;

/**
 * Created by gaoyy on 2016/9/28 0028.
 */
public class MeasureUtil
{
    public static int getScreenWidth(Context context)
    {
        int width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }

    public static int getScreenHeight(Context context)
    {
        int height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }
}
