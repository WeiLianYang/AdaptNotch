package com.william.adaptnotch.utils;

/**
 * 作者：William 时间：2018/7/14
 * 类说明：SharedPreferences 工具类
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.william.adaptnotch.App;

public final class PreUtil {
    private static SharedPreferences preferences;

    public PreUtil() {
    }

    public static SharedPreferences getPreferences() {
        if (preferences == null) {
            preferences = App.getInstance().getSharedPreferences(App.getInstance().getAppName(), Context.MODE_PRIVATE);
        }
        return preferences;
    }

    public static boolean contains(String key) {
        return getPreferences().contains(key);
    }

    public static void clear() {
        Editor editor = getPreferences().edit();
        editor.clear();
        editor.commit();
    }

    public static boolean delete(String name) {
        Editor editor = getPreferences().edit();
        editor.remove(name);
        return editor.commit();
    }

    public static String readString(String name) {
        return getPreferences().getString(name, "");
    }

    public static long readLong(String name) {
        return getPreferences().getLong(name, 0L);
    }

    public static int readInt(String name, int defaultval) {
        return getPreferences().getInt(name, defaultval);
    }

    public static float readFloat(String name, float defaultval) {
        return getPreferences().getFloat(name, defaultval);
    }

    public static String readString(String name, String defaultVal) {
        return getPreferences().getString(name, defaultVal);
    }

    public static boolean readBoolean(String name, boolean defaultVal) {
        return getPreferences().getBoolean(name, defaultVal);
    }

    public static boolean writeString(String name, String value) {
        Editor editor = getPreferences().edit();
        editor.putString(name, value);
        return editor.commit();
    }

    public static boolean writeLong(String name, long value) {
        Editor editor = getPreferences().edit();
        editor.putLong(name, value);
        return editor.commit();
    }

    public static boolean writeInt(String name, int value) {
        Editor editor = getPreferences().edit();
        editor.putInt(name, value);
        return editor.commit();
    }

    public static boolean writeFloat(String name, float value) {
        Editor editor = getPreferences().edit();
        editor.putFloat(name, value);
        return editor.commit();
    }

    public static boolean writeBoolean(String name, boolean value) {
        Editor editor = getPreferences().edit();
        editor.putBoolean(name, value);
        return editor.commit();
    }
}
