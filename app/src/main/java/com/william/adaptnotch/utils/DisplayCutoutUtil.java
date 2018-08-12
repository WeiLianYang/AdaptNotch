package com.william.adaptnotch.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * 作者：William 时间：2018/7/23
 * 类说明：adapt cutout utils
 */
public class DisplayCutoutUtil {

    private static final String TAG = "DisplayCutoutUtil";

    /**
     * adapt fullScreen mode
     *
     * @param mActivity a
     */
    public static void openFullScreenModel(Activity mActivity) {
        try {
            if (needAdaptNotch(mActivity)) {
                mActivity.requestWindowFeature(Window.FEATURE_NO_TITLE);
                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
                if (Build.VERSION.SDK_INT >= 28) {
                    lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
                }
                mActivity.getWindow().setAttributes(lp);
                View decorView = mActivity.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                int flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN;
                systemUiVisibility |= flags;
                mActivity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * need to adapt Notch screen
     *
     * @return true otherwise false
     */
    private static boolean needAdaptNotch(Context c) {
        return Build.VERSION.SDK_INT >= 28 || isHuaweiNotch(c) || isOppoNotch(c) || isVivoNotch(c);
    }

    /**
     * huawei
     *
     * @param context c
     * @return hasNotch
     */
    private static boolean isHuaweiNotch(Context context) {
        boolean ret = false;
        try {
            ClassLoader cl = context.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method get = HwNotchSizeUtil.getMethod("hasNotchInScreen");
            ret = (boolean) get.invoke(HwNotchSizeUtil);
        } catch (ClassNotFoundException e) {
            Log.e("test", "hasNotchInScreen ClassNotFoundException");
        } catch (NoSuchMethodException e) {
            Log.e("test", "hasNotchInScreen NoSuchMethodException");
        } catch (Exception e) {
            Log.e("test", "hasNotchInScreen Exception");
        }
        return ret;
    }

    /**
     * OPPO
     *
     * @param context Context
     * @return hasNotch
     */
    private static boolean isOppoNotch(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * VIVO
     * param:
     * 0x00000020表示是否有凹槽;
     * 0x00000008表示是否有圆角。
     *
     * @param context Context
     * @return hasNotch
     */
    private static boolean isVivoNotch(Context context) {
        boolean hasNotch = false;
        try {
            ClassLoader cl = context.getClassLoader();
            Class FtFeature = cl.loadClass("android.util.FtFeature");
            Method get = FtFeature.getMethod("isFeatureSupport");
            hasNotch = (boolean) get.invoke(FtFeature, new Object[]{0x00000020});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasNotch;
    }

    /**
     * get statusBar height
     *
     * @param context c
     * @return h
     */
    public static int getStatusBarHeight(Context context) {
        try {
            int result = 0;
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = context.getResources().getDimensionPixelSize(resourceId);
            }
            Log.d(TAG, "getStatusBarHeight==========>" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
