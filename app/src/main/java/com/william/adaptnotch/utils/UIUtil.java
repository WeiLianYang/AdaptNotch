package com.william.adaptnotch.utils;

import com.william.adaptnotch.App;

/**
 * Author：William Time：2018/8/12
 * Class Comment：
 */
public class UIUtil {

    public static float getDip() {
        return App.getInstance().getResources().getDisplayMetrics().density;
    }

    public static int getIntDip(float i) {
        return (int) getFloatDip(i);
    }

    public static float getFloatDip(float i) {
        return App.getInstance().getResources().getDisplayMetrics().density * i;
    }

    public static int getScreenWidth() {
        return App.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return App.getInstance().getResources().getDisplayMetrics().heightPixels;
    }
}
