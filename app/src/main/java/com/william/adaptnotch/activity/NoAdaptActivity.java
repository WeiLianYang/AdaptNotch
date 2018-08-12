package com.william.adaptnotch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.william.adaptnotch.R;
import com.william.adaptnotch.utils.StatusBarManager;

/**
 * Author：William Time：2018/8/12
 * Class Comment：not adapt
 */
public class NoAdaptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarManager.setStatusBar(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_adapt);



    }
}
