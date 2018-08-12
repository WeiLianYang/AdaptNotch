package com.william.adaptnotch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.william.adaptnotch.R;

public class MainActivity extends AppCompatActivity {

    private boolean exit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * adapt page
     */
    public void hasAdaptNotch(View view) {
        startActivity(new Intent(this, HasAdaptActivity.class));
    }

    /**
     * not adapt page
     */
    public void notAdaptNotch(View view) {
        startActivity(new Intent(this, NoAdaptActivity.class));
    }

    @Override
    public void onBackPressed() {
        if (!exit) {
            exit = true;
            Toast.makeText(this, "Click quit again!", Toast.LENGTH_SHORT).show();
            getWindow().getDecorView().postDelayed(() -> {
                if (!isFinishing()) {
                    exit = false;
                }
            }, 1500);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

}
