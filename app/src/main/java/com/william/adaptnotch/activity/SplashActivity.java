package com.william.adaptnotch.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.william.adaptnotch.R;
import com.william.adaptnotch.utils.DisplayCutoutUtil;

/**
 * 作者：William 时间：2018/7/14
 * 类说明：闪屏页
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        DisplayCutoutUtil.openFullScreenModel(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 3000);
    }

}
