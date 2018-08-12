package com.william.adaptnotch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.william.adaptnotch.R;
import com.william.adaptnotch.utils.DisplayCutoutUtil;
import com.william.adaptnotch.utils.StatusBarManager;

/**
 * Author：William Time：2018/8/12
 * Class Comment：has handled cutout
 */
public class HasAdaptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarManager.setStatusBar(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_has_adapt);

        // adapt cutout
        int pH = DisplayCutoutUtil.getStatusBarHeight(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = pH;
        findViewById(R.id.rl_top).setLayoutParams(params);
    }
}
