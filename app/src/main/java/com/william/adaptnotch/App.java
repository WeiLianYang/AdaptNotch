package com.william.adaptnotch;

import android.app.Application;

/**
 * 作者：William 时间：2018/7/14
 * 类说明：
 */
public class App extends Application {
    protected static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public String getAppName() {
        return getPackageManager().getApplicationLabel(this.getApplicationInfo()).toString();
    }
}
